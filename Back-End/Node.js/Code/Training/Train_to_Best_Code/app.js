const express = require('express');
const app = express();

const server = require('http').Server(app); // Best : useful to reuse
// const server = require('http').createServer(app); // 2nd : Call Server(app)
// app.listen(3000); // 3rd : Call CreateServer(app) -> Server(app)

app.get('/', (req, res) => {

    res.status(200).send("Hello World");

});


server.listen(3030);