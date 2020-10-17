const {Worker, isMainThread, parentPort, workerData} = require('worker_threads');


if (isMainThread) { // Main Thread
    
    // Create Worker Threads

    // // Bad at Maintenance
    // const worker1 = new Worker(__filename);
    // const worker2 = new Worker(__filename);
    // const worker3 = new Worker(__filename);
    // const worker4 = new Worker(__filename);
    // const worker5 = new Worker(__filename);
    
    // Using Set => Good at Maintenance
    const workers = new Set();
    workers.add(new Worker(__filename, {
        workerData: {start: 1},
    }));
    workers.add(new Worker(__filename, {
        workerData: {start: 2},
    }));

    // Listening Message From All Workers
    for (let worker of workers) {
        worker.on('message', (value) => console.log(value));
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
    const data = workerData;
    parentPort.postMessage(data.start);

    // // Listening Message From Main
    // parentPort.on('message', (value) => {
        
    //     console.log(value);

    //     // Post Message To Main
    //     parentPort.postMessage('Hellow, Main.');
        
    //     // Close Worker Thread
    //     parentPort.close();
    // });
}