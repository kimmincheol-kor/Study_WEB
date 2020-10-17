const crypto = require('crypto');

const pass = 'pass';
const salt = 'salt';
const start = Date.now();

for (let i = 1; i <= 8; i++) {
    crypto.pbkdf2(pass, salt, 1_000_000, 128, 'sha512', () => {
        console.log(i, Date.now() - start);
    });
}

/* 
그룹이 정해진다는 것을 알수있다.
[1,2,3,4]
[5,6,7,8]

==> 스레드가 4개가 존재한다. 4개씩 동시에 처리.
*/