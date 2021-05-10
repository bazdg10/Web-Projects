const chatForm = document.getElementById('chat-form');
const chatMessages = document.querySelector('.chat-messages');
const roomName = document.getElementById('room-name');
const userList = document.getElementById('users');
const sendImage = document.querySelector('#sendImage');

// Get username and room from URL
const { username, room } = Qs.parse(location.search, {
    ignoreQueryPrefix: true,
});

user1=username

const socket = io();

// Join chatroom
socket.emit('joinRoom', { username, room });

// Get room and users
socket.on('roomUsers', ({ room, users }) => {
    outputRoomName(room);
    outputUsers(users);
});

// Message from server
socket.on('message', (message) => {
    console.log(message);
    outputMessage(message);

    // Scroll down
    chatMessages.scrollTop = chatMessages.scrollHeight;
});

// For image
sendImage.addEventListener('change', () => {
    var filesSelected = document.getElementById("sendImage").files;
    if (filesSelected.length > 0) {
        var fileToLoad = filesSelected[0];

        var fileReader = new FileReader();

        fileReader.onload = (fileLoadedEvent) => {

            var srcData = fileLoadedEvent.target.result; //  data: base64

            var newImage = document.createElement('img');
            newImage.src = srcData;

            let imgData = {
                message: srcData
            }

            displayImage(srcData); //display image in the message area 

            socket.emit('image', imgData); //send image to the server to broadcast it so that users can see image
        }
        fileReader.readAsDataURL(fileToLoad);
    }
});

//display image in the message area
displayImage = (srcData) => {
    const div = document.createElement('div');
    var newImage = document.createElement('img');
    newImage.src = srcData;

    // document.getElementById("historyMsg").innerHTML = user + newImage.outerHTML;

    //messageArea.append(newImage);
    //appendMessage(`send image...`);
    div.append(newImage);
    document.querySelector('.chat-messages').append(div);
    //autoScrollDown();
    // alert("Converted Base64 version is " + document.getElementById("historyMsg").innerHTML);

};

//incoming image message 
socket.on("image", (imgData) => {
    displayImage(imgData.message);
    // autoScrollDown();
});

// Message submit
chatForm.addEventListener('submit', (e) => {
    e.preventDefault();

    // Get message text
    let msg = e.target.elements.msg.value;

    msg = msg.trim();

    if (!msg) {
        return false;
    }

    let mulusers = e.target.elements.mulusers.value;
    mulusers = mulusers.trim();

    socket.emit('chatMessage', { msg, mulusers });

    // Clear input
    e.target.elements.msg.value = '';
    e.target.elements.msg.focus();
});


// Output message to DOM
outputMessage = (message) => {
    const div = document.createElement('div');
    div.classList.add('message');
    const p = document.createElement('p');
    p.classList.add('meta');
    p.innerText = message.username;
    p.innerHTML += ` <span>${message.time}</span>`;
    div.appendChild(p);
    const para = document.createElement('p');
    para.classList.add('text');
    para.innerText = message.text;
    div.appendChild(para);
    document.querySelector('.chat-messages').appendChild(div);
}

// Add room name to DOM
outputRoomName = (room) => {
    roomName.innerText = room;
}

// Add users to DOM
outputUsers = (users) => {
    userList.innerHTML = '';
    users.forEach((user) => {
        const li = document.createElement('li');
        li.innerText = user.username;
        userList.appendChild(li);
    });
}


//Prompt the user before leave chat room
document.getElementById('leave-btn').addEventListener('click', () => {
    const leaveRoom = confirm('Are you sure you want to leave?');
    if (leaveRoom) {
        window.location = '../index.html';
    } else {}
});