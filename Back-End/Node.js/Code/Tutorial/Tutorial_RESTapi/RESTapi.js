const http = require('http');

http.createServer((req, res) => {
    try { // Server Operation
        if (req.method === 'GET') {
            // Read Data and Send
            res.writeHead(200, { 'Content-Type': 'text/plain; charset=utf-8' });
            res.end('data : asdasd');
        } else if (req.method === 'POST') {
            // Create New Data
            res.writeHead(201, { 'Content-Type': 'text/plain; charset=utf-8' });
            res.end('POST OK');
        } else if (req.method === 'PUT') {
            // Change Exist Data => New Data
            res.writeHead(200, { 'Content-Type': 'text/plain; charset=utf-8' });
            res.end('PUT OK');
        } else if (req.method === 'PATCH') {
            // Edit Part of Exist Data
            res.writeHead(200, { 'Content-Type': 'text/plain; charset=utf-8' });
            res.end('PATCH OK');
        } else if (req.method === 'DELETE') {
            // Delete Exist Data
            res.writeHead(200, { 'Content-Type': 'text/plain; charset=utf-8' });
            res.end('DELETE OK');
        } else {
            res.writeHead(404);
            res.end('NOT FOUND');
        }
    } catch (err) { // Server Error Handler
        console.error(err);
        res.writeHead(500, { 'Content-Type': 'text/plain; charset=utf-8' });
        res.end(err);
    }
}).listen(8080, () => {
    console.log('Running RESTapi Server at PORT:8080');
});