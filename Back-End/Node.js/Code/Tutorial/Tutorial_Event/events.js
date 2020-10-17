const { EventEmitter } = require('events');
const EventEmiiter = require('events');

const myEvent = new EventEmitter();

// 기본적인 이벤트 리스너 생성
myEvent.addListener('e1', () => {
    console.log('이벤트 1');
});

// 이벤트 리스너 추가.
myEvent.on('e2', () => {
    console.log('이벤트 2');
});
myEvent.on('e2', () => {
    console.log('이벤트 2 추가적인 동작');
}); 

// 리스너 동작을 한번만 실행.
myEvent.once('e3', () => {
    console.log('이벤트 3');
});

myEvent.emit('e1');
myEvent.emit('e2');
myEvent.emit('e3');
myEvent.emit('e3'); // 무시됨