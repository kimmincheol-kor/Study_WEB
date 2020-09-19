# Node.js - Timers

시간 연속체 제어하기
--------
- Node.js API는 현시점 이후 어떤 특정 순간에 코드를 실행하도록 스케줄링하는 여러 가지 방법을 제공한다.
- Timers 모듈이 존재, require할 필요없이 Node.js 전역에서 사용 가능.

#### `지정한 시간 이후에 실행` - setTimeout()
- JavaScript API의 window.setTimeout()과 비슷하지만 다르다.
- 첫 번째 인자로 `실행시킬 함수`를 입력받으며, 두 번째 인자로 지연시킬 `밀리 초`를 입력 받는다.
- 부가적인 세 번째 인자를 실행시킬 함수에 전달할 수 있다.
```
function sample(arg) {
	console.log("i'm sample : ${arg} zz");
}

setTimeout(sample, 1500, 'funky');
```
sample 함수는 setTimeout 함수로 인해 1500밀리초(1.5초) 이후에 실행될 것이다.

- 이벤트 루프의 블로킹 혹은 다른 실행 코드로 인해 타이머의 실행 시간이 늦어질 수 있다.
- setTimeout() 함수는 `지정된 시간보다 더 빨리 실행되지 않는다`만을 보장한다.
- setTimeout()함수는 Timeout 객체를 반환하는데 이를 사용하여 실행 동작을 변경하거나, 타임 아웃을 취소할수도 있다.
-  

#### `바로 다음에 실행` - setImmediate()
- 현재 이벤트 루프 주기가 끝나면 코드를 실행한다.
- 이 코드는 현재 이벤트 루프의 작업이 종료된 다음 `스케줄링된 모든 타이머` 이전에 실행된다.
- 첫 번째 인자로 `실행할 함수`를, 두 번째 인자는 실행할 `함수로 전달될 인자`이다.
```
console.log('before immediate');

setImmediate((arg) => {
	console.log(arg);
}, 'i'm immediate');

console.log('after immediate')
```
before, after, immediate 순으로 출력될 것이다. setImmediate() 함수는 `실행할 수 있는 코드를 모두 실행한 후`에 실행하기 때문이다.
- setTimeout() 함수와 마찬가지로 Immediate 객체를 반환하여 스케줄 취소할 수 있다.

#### `무한 루프 실행` - setInterval()
- 여러 번 실행해야하는 코드 블럭에 사용된다.
- setInterval()의 첫 번째 인자는 `실행할 함수`를, 두 번째 인자는 밀리초 단위의 시간으로 `지연 시간마다 함수를 실행`할 시간 단위이다. 세 번째 인자에 함수에 전달할 인자를 입력할 수 있다.
- setTimeout() 함수와 마찬가지로 실행 시간을 보장하지는 못한다.

```
function sample() {
	console.log("Can't stop me now!");
}

setInterval(sample, 1500);
```
1500밀리 초 마다 함수가 실행될 것이다.

- setInterval() 함수도 Timeout 객체를 반환하여 동작을 수정할 수 있도록 한다.

#### 타이머 함수 취소하기
- clearTitmeout(TimerObject)
- clearImmediate(TimerObject)
- clearInterval(TimerObject)

- setTimeout(), setInterval() => Timeout 객체 반환
- setImmediate() => Immediate 객체 반환

- Timeout 객체는 동작을 강화하는 두 개의 함수 `unref()`, `ref()`를 제공한다.
	- unref() : 타임아웃이 실행되지 않도록 한다.
	- ref() : unref()가 호출된 객체를 실행되도록 한다. (초기 동작을 완벽 복구는 X)
