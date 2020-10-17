function findPrimes(a, b) {
    const start = a;
    const min = 2;
    const range = b;
    const max = 10000000;
    const primes = [];

    let isPrime = true;
    const end = start + range;
    for (let i = start; i < end; i++) {
        for (let j = min; j < Math.sqrt(end); j++) {
            if (i !== j && i % j === 0) {
                isPrime = false;
                break;
            }
        }
        if (isPrime) {
            primes.push(i);
        }
        isPrime = true;
    }

    console.log("End of getPrimes :", start, range, primes.length);
    return primes.length;
}

module.exports = findPrimes;