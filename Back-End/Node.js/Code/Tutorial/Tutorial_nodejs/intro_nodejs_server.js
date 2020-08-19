var http = require('http'); // http protocol
var fs = require('fs'); // filesystem
var url = require('url'); // use module 'url'

var app = http.createServer(function(request,response){

    var req_url = request.url; // request.url = '/?id=HTML' after port number in URL

    var queryData = url.parse(req_url, true).query; // extract query , url = "localhost:3000/?id=HTML"
    var page_name = queryData.id;
    var page_data = "nothing.";

    if(req_url == '/'){ // if home.
      req_url = '/index.html';
      page_name = 'home';
      page_data = 'welcome to my home.'
    }
    if(req_url == '/favicon.ico'){
      return response.writeHead(404); // ERROR MESSAGE HEADER
    }

    // Read File in Local Storage
    fs.readFile(`data/${page_name}`, 'utf8', function(err, page_data){
      if(err) return response.writeHead(404);
      else {
        // Make template data for response
        var my_template = `
        <!doctype html>
        <html>
        <head>
          <title>NODE JS</title>
          <meta charset="utf-8">
        </head>
        <body>
          <h1><a href="/">NODE JS</a></h1>
          <ol>
            <li><a href="?id=html">HTML</a></li>
            <li><a href="?id=css">CSS</a></li>
            <li><a href="?id=javascript">JavaScript</a></li>
          </ol>
          <h2>${page_name}</h2>
          <p>${page_data}</p>
        </body>
        </html>
        `

        response.writeHead(200); // ERROR MESSAGE HEADER

        response.end(my_template);
      }
    });
});

app.listen(3000); // port number 3000.
