const {Worker, isMainThread, parentPort, workerData} = require('worker_threads');
const getPrimes = require('./getPrimes');

if (isMainThread) { // Main Thread

    // This is Important To Find Suitable Number For CPU
    const threadCount = 8;
    
    // Create Worker Threads
    const workers = new Set();
    for (let i = 0; i < threadCount; i++) {
        const wStart = i+1;
        const wEnd = 10000000-i
        workers.add(new Worker(__filename, {
            workerData: {
                start: wStart, 
                end: wEnd,
            }
        }));
    }

    // Listening Message From All Workers
    for (let worker of workers) {
        worker.on('message', (value) => console.log("From Worker :",value));
        worker.on('exit', () => {
            console.log('End of Worker');
            workers.delete(worker);

            if(workers.size === 0) {
                console.log('All Workers are End');
            }
        });
    }
}
else { // Worker Thread
    const result = getPrimes(workerData.start, workerData.end)
    parentPort.postMessage(result);
    parentPort.close();
}