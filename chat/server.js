const path = require('path');
const http = require('http');
const express = require('express');
const socketio = require('socket.io');
const formatMessage = require('./utils/messages');
const {
    userJoin,
    getCurrentUser,
    userLeave,
    getRoomUsers,
    getUserSocketID
} = require('./utils/users');

const app = express();
const server = http.createServer(app);
const io = socketio(server);

var fs = require('fs'); // required for file serving

// Set static folder
app.use(express.static(path.join(__dirname, 'public')));

const botName = 'Admin';

// When client first connects
io.on('connection', socket => {
    socket.on('joinRoom', ({ username, room }) => {
        const user = userJoin(socket.id, username, room);

        socket.join(user.room);

        // Welcome current user
        socket.emit('message', formatMessage(botName, 'Welcome to room ' + room + '!'));

        // Broadcast when a user connects
        socket.broadcast
            .to(user.room)
            .emit(
                'message',
                formatMessage(botName, `${user.username} joined`)
            );
        // Send users and room info
        io.to(user.room).emit('roomUsers', {
            room: user.room,
            users: getRoomUsers(user.room)
        });
    });

    //forward chat messages
    socket.on('chatMessage', ({ msg, mulusers }) => {

        if (mulusers.length != 0) {
            var multiUsers = mulusers.split(',');
            var num = multiUsers.length;

            const user = getCurrentUser(socket.id);
            io.to(user.id).emit('message', formatMessage(user.username, msg));

            for (var i = 0; i < num; i++) {
                var sock = getUserSocketID(multiUsers[i]);
		if(sock!=-1)
                io.to(sock).emit('message', formatMessage(user.username,msg));
            }
        } else {
            const user = getCurrentUser(socket.id);
            io.to(user.room).emit('message', formatMessage(user.username, msg));
        }

    });

    //when user send the image, server then broadcasted it those who are connected
    socket.on("image", (imgData) => {
        const user = getCurrentUser(socket.id);
        io.to(user.room).emit('image', imgData);
        //socket.broadcast.emit("image", imgData);
    });




    // When client exits
    socket.on('disconnect', () => {
        const user = userLeave(socket.id);

        if (user) {
            io.to(user.room).emit(
                'message',
                formatMessage(botName, `${user.username} left`)
            );

            // Send users and room info
            io.to(user.room).emit('roomUsers', {
                room: user.room,
                users: getRoomUsers(user.room)
            });
        }
    });
});

const PORT = process.env.PORT || 3000;

server.listen(PORT, () => console.log(`Server running on port ${PORT}`));