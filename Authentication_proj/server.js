//console.log(`Hi`);
const bcrypt = require(`bcrypt`);
const express = require(`express`);
const app = express();

const users = [
    {
        name: "Baz",
        password: "Honululu"
    },
    {
        name: "Kim",
        password: "Konukulu"
    }
];

app.get('/users', (req, res)=> {
    res.json(users);
});

app.get('/login', (req, res)=> {
    // Authenticate the user
});

app.post('/users', async (req, res)=> {
    try {
        console.log('Going..');
        //const salt = await bcrypt.genSalt();
        //console.log('Going..');
        //const hashedPassword = await bcrypt.hash(req.body.password, 10);
        console.log('Going..');
        //console.log(salt);
        //console.log(hashedPassword);
        const user = { name: req.body.name, password: req.body.password};
        users.push(user);
        res.status(201).send();
    } catch {
        res.status(500).send();
    }
});

app.listen(3000);