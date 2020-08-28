// External Modules
const express = require('express');
const path = require('path');
const router = require('./src/routes/home');

// Global Variables
const app = express();
const port = process.env.PORT || 3030; // Default = 3030, if Env Var PORT is Existing, then port = PORT)

// Set Property of app
app.set("view engine", "ejs");
app.set('views', path.join(__dirname, 'views'));

// Route : home directory
app.use('/', router);

// Create HTTP Server Object
const server = require('http').Server(app); // Best : useful to reuse
// const server = require('http').createServer(app); // 2nd => Call 1st:Server(app)
// app.listen(3000); // 3rd => Call 2nd:CreateServer(app) -> 1st:Server(app)

// Start Listening
server.listen(port, err => {
    if(err) console.log('ERROR : ', err);
    else    console.log(`*** [ START SERVER ] [ port = ${port} ] ***`);
});