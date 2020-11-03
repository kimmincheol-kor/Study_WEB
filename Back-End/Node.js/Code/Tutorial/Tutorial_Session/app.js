// External Modules
const express = require('express');
const session = require('express-session');
const cookieParser = require('cookie-parser');
const logger = require('morgan');

const mySignature = "12345";

// Set Middleware
const app = express();

app.use(logger('dev'));
app.use(express.json());
app.use(express.urlencoded({ extended: false }));
app.use(cookieParser(mySignature));
app.use(session({
    secret: mySignature,
    resave: false,
    saveUninitialized: true,
    cookie: {
        httpOnly: true,
        secure: false,
    }
}));

app.get('/', (req, res) => {
    console.log(req.session);
    if (req.session.num === undefined) {
        req.session.num = 1;
    }
    else {
        req.session.num += 1;
    }
    res.send(`Hello Session : ${req.session.num}`);
});


// Create HTTP Server Object
const server = require('http').Server(app);
const port = process.env.PORT || 8000;

// Start Listening
server.listen(port, err => {
    if (err) console.log('ERROR : ', err);
    else {
        console.log('----------------------------------------------------')
        console.log(`    [ START SERVER ]   [ PORT = ${port} ]`);
        console.log('----------------------------------------------------')
    }
    console.log('')
});