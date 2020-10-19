const http = require('http');

http.createServer((req, res) => {
  try {
    const ip = req.connection.remoteAddress;
    console.log(`Cookie of Request(${ip}) : ${req.headers.cookie}`);
    if (req.headers.cookie === undefined) {
      res.writeHead(200, { 'Set-Cookie': 'testCookie=New' });
    } else {
      res.writeHead(200, { 'Set-Cookie': 'testCookie=Exsit' });
    }
    res.end('Hello Cookie');
  } catch {
    console.error(err);
    res.writeHead(500, { 'Content-Type': 'text/plain; charset=utf-8' });
    res.end(err);
  }
}).listen(8080, () => {
  console.log('Running Cookie Server at POST:8080');
});