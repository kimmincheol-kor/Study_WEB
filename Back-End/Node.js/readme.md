# Node.js : (https://nodejs.org/)

[Timer.md](https://github.com/kimmincheol-kor/Study_WEB/blob/master/Back-End/Node.js/nodejs-timers.md)   
[HTTP.md](https://github.com/kimmincheol-kor/Study_WEB/blob/master/Back-End/Node.js/nodejs-http.md)

Node.js란?
--------
- JavaScript Program을 실행할 수 있게 해주는 V8 JS 엔진으로 빌드된 JS Runtime.
- 이벤트 기반, Non-Blocking I/O 모델을 사용해 가볍고 효울적.
- 2009년 라이언 달 : 파일 업로드 진행 표시줄을 보았을 때, 파일이 얼마나 업로드되었는지 알기 위해서는 서버에 쿼리를 전송하는 것을 보고 쉬운 방법을 찾다가 고안

<img src="https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=http%3A%2F%2Fcfile22.uf.tistory.com%2Fimage%2F997A063B5AD8B56E05044F" width="100%" />

- Node.js 내부 구조 : 개발자가 `JavaScript로 작성한 프로그램`을 `Node.js API`가 `V8 엔진`과 `libuv library`에 연결해준다.

> - **V8 엔진** : 웹 브라우저에 기반을 제공하는 오픈 소스 `자바스크립트 엔진`   
> 빠른 속성 액세스(Fast Property Access)   
> 동적 기계 코드 생성(Dynamic Machine Code Generation)   
> 불필요한 데이터의 효율적인 수집(Efficient Garbage Collection)   
> 
> - **이벤트 루프**   
> 메인 스레드이면서 싱글 스레드로써, 비즈니스 로직을 수행한다.   
> 블로킹 I/O 작업을 만나면 커널 비동기 함수 혹은 Worker Thread Pool에 넘겨준다.   

동작 방식 : 이벤트 루프(Single Thread) 기반 비동기 방식 (Non-Blocking I/O)
--------
- Node.js 를 시작할 때 이벤트 루프를 초기화하고, 스크립트를 처리한다. 이때 이 스크립트는 비동기 API를 호출하거나, 스케줄링된 타이머를 사용하거나, process.nextTick()을 사용한다.

<img src="https://miro.medium.com/max/502/1*ARvCnv04gbE2iyyzr0XvZw.png"/>
- 각 박스는 이벤트 루프의 `단계`를 의미한다.
- 각 단계는 `실행할 콜백의 FIFO Queue`를 가진다.

1. 이벤트 루프가 특정 단계에 진입하면 한정된 작업을 수행한다.
2. 큐를 모두 소진하거나, 실행 콜백 최대 개수(제한)에 이르면 다음 단계로 이동한다.

#### 단계 개요
- `timers` : setTimeout(), setInterval()로 스케줄링한 콜백을 실행
- `pending callbacks` : 연기된 I/O 콜백을 실행
- `idle, prepare` : 내부용으로 사용
- `poll` : 새로운 I/O 이벤트를 가져온다. I/O와 연관된 거의 대부분의 콜백을 실행. (Node가 주로 머무는 곳)
- `check` : setImmediate() 콜백을 호출
- `close` callbacks : 일부 close 콜백들을 

- + 동작하는 중간 다른 비동기 I/O나 타이머를 기다리고 있는지 확인한다.

#### 단계 설명
- timers
   - 타이머는 실행하기 원하는 `정확한 시간`이 아니라, 일정 시간 후에 실행되어야 하는 `기준 시간`을 지정한다. 타이머 콜백은 지정 시간 후에 스케줄링 될 수 있는 가장 이른 시간에 실행될 것이다. 하지만 다른 콜백이나 시스템에 의해 지연될 수 있다.
   `기술적으로는 poll 단계에서 타이머를 언제 실행할지 제어`
- pending
   - TCP 오류와 같은 시스템 작업의 콜백을 실행한다. TCP 소켓이 연결을 시도하다가 실패하면 일부 시스템은 오류를 보고하려할 것입니다. 이는 pending callback 큐에 추가됩니다.
- poll
   1. I/O를 얼마나 오래 블록하고 폴링해야하는지 `계산`
   2. poll 큐에 있는 이벤트를 `처리`
   - poll 큐가 비어있지 않다면 큐를 순회하면서 처리
   - poll 큐가 비어있다면 setImmediate()로 스케줄링 되어있는지 확인 후 check 단계로 이동
   - 그렇지 않다면 타이머가 시간 임계점에 도달했는지 확인 후 timers 단계로 이동
   - 그렇지 않다면 콜백이 큐에 추가되기를 기다린 후 즉시 실행
- check
   - poll 단계가 완료된 직후 사람이 콜백을 실행할 수 있게 한다.
   - 이벤트 루프를 기다리지 않고 즉시 처리
- close
   - 소켓이나 핸들이 갑자기 닫힌 경우에 이 단계에서 'close' 이벤트가 발생한다.
   
#### setImmediate() vs setTimeout()
- `setImmediate()`는 현재 poll 단계가 완료되면 스크립트를 실행하도록 설계되었습니다.
- `setTimeout()`는 최소 임계 값(ms)이 지난 후 스크립트가 실행되도록 스케줄링합니다.
- setImmediate()의 장점은 얼마나 많은 타이머가 존재하냐에 상관없이 `I/O 주기내에서 스케줄된 어떤 타이머보다 먼저 실행된다는 것`
- 동시 실행시,
  - I/O 주기 내에 있지 않은 Context에서는 순서는 프로세스 성능에 따라 바뀐다.
  - I/O 주기 내에 있는 Context에서는 Immediate 콜백이 항상 먼저 실행된다.

#### process.nextTick()
- 비동기 API에 속해있지만, 기술적으로는 이벤트 루프의 일부가 아니다.
- 다른 콜백 함수들보다 먼저 처리된다. (현재 작업이 처리된 후 즉시 처리)
   => 콜백 함수가 모이는 큐인 `태스크 큐`보다 nextTick과 Promise가 모이는 `마이크로 태스크 큐`가 우선적으로 처리되기 때문이다
- vs setImmediate()
   - nextTick()은 같은 단계에서 즉시 실행, setImmediate()는 이어진 순회나 이벤트 루프의 tick에서 실행.
   - 실행 시점이 예상하기 더 쉬운 setImmediate()의 사용이 권장된다.
- 사용하는 이유
  - 이벤트 루프를 계속하기 전에 `오류 처리`, `불필요한 자원 정리`
  - 이벤트 루프가 계속 진행되기 전에 콜백을 실행해야하는 경우

장점
--------
- 개발이 빠르고 쉽다. -> 진입 장벽이 낮다
- Non-blocking I/O와 싱글 스레드 이벤트 루프 -> 뛰어난 처리 성능
- NPM(node package manager)을 통한 다양한 모듈(패키지) 제공 -> 개발 속도와 효율성 향상

- 어울리는 서비스
> 1. 간단한 로직의 서비스   
> 2. 대용량(동시에 여러 request를 처리) 서비스   
> 3. 빠른 응답시간(= 실시간)을 요구하는 서비스   
> 4. 비동기 방식에 어울리는 실시간 서비스 (네트워크 스트리밍 서비스, 채팅 서비스 등)   
> 5. SPA

단점
--------
- 비동기 방식이기 때문에 로직이 복잡한 경우 콜백 함수의 늪(Callback Hell)에 빠질 수 있다.
- 코드가 실행되어야 에러를 확인할 수 있기 때문에 모든 케이스에 대한 철저한 소스코드 검증이 필요하다.

- 어울리지 않는 서비스
> 1. 단일 처리가 오래 걸리는 서비스 -> 싱글 스레드이기 때문에   
> 2. 서버 체크 로직이 많은 서비스 -> 콜백 함수의 늪에 빠질 수 있기 때문에   
> 3. 복잡도 / 난이도가 높은 경우 -> 에러가 나면 서버 프로세스가 종료되기 때문에   



- 참고 : https://sjh836.tistory.com/149
