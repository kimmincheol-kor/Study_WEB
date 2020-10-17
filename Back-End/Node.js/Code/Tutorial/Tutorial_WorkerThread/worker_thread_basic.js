const wt = require('worker_threads');

const Worker = wt.Worker;
const parentPort = wt.parentPort;

if (wt.isMainThread) { // Main Thread
    
    // Create Worker Thread
    const worker = new Worker(__filename);

    // Listening Message From Worker
    worker.on('message', (value) => console.log(value));
    worker.on('exit', () => console.log('End of Worker'));

    // Post Message To Worker
    worker.postMessage('Hi Worker?');
}
else { // Worker Thread
    // Listening Message From Main
    parentPort.on('message', (value) => {
        
        console.log(value);

        // Post Message To Main
        parentPort.postMessage('Hellow, Main.');
        
        // Close Worker Thread
        parentPort.close();
    });
}