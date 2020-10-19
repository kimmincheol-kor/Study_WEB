const http = require('http');
const numCPUs = require('os').cpus().length;

const cluster = require('cluster');

function sleep(delay) {
  var start = new Date().getTime();
  while (new Date().getTime() < start + delay);
}

if (cluster.isMaster) {
  // Master Process
  console.log(`I'm Master [${process.pid}]`);
  try {
    // Create Worker Process
    for (let i = 0; i < numCPUs; i += 1) {
      const workerPid = cluster.fork().process.pid;
      console.log(`New Worker [pid=${workerPid}]`);
    }
    // Listening Exsit of Worker
    cluster.on('exit', (worker, code, signal) => {
      console.log(`Exit Worker [pid=${worker.process.pid}][code=${code}][signal=${siganl}]`);
      cluster.fork(); // Restore Worker
    });
  } catch (err) {
    console.log(err);
  }
} else {
  // Worker Process
  const workerPid = process.pid;
  http.createServer((req, res) => {
    console.log(`I'm Working ! ${workerPid}`);
    sleep(1000);
    res.writeHead(200, { 'Content-Type': 'text/html; charset=utf-8' });
    res.end(`<h1>Hellow, I'm Cluster ${workerPid}</h1>`);
  }).listen(8080, () => {
    console.log(`Running Cluster Server at PORT:8080, PID:${workerPid}`);
  });
}
