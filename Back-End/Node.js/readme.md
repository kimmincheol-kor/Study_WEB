# Node.js : (https://nodejs.org/)

- As an asynchronous event-driven JavaScript runtime

<br>

## Node.js란?
- JavaScript Program을 실행할 수 있게 해주는 Runtime.
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

#### 동작 방식 : 이벤트 루프(Single Thread) 기반 비동기 방식 (Non-Blocking I/O)
- 하나의 스레드가 request를 받으면 바로 다음 처리에 요청을 보내놓고 다른 작업을 처리하다가 먼저 요청한 작업이 끝나면 이벤트를 받아서 응답을 보낸다.
- 동시 request가 오더라도 처리가 완료될때까지 기다리지 않아도 되기 때문에 서버 부하가 적다.

#### 장점
- 개발이 빠르고 쉽다. -> 진입 장벽이 낮다
- Non-blocking I/O와 싱글 스레드 이벤트 루프 -> 뛰어난 처리 성능
- NPM(node package manager)을 통한 다양한 모듈(패키지) 제공 -> 개발 속도와 효율성 향상

- 어울리는 서비스
> 1. 간단한 로직의 서비스   
> 2. 대용량(동시에 여러 request를 처리) 서비스   
> 3. 빠른 응답시간(= 실시간)을 요구하는 서비스   
> 4. 비동기방식에 어울리는 서비스 (네트워크 스트리밍 서비스, 채팅 서비스 등)   


#### 단점
- 비동기 방식이기 때문에 로직이 복잡한 경우 콜백 함수의 늪(Callback Hell)에 빠질 수 있다.
- 코드가 실행되어야 에러를 확인할 수 있기 때문에 모든 케이스에 대한 철저한 소스코드 검증이 필요하다.

- 어울리지 않는 서비스
> 1. 단일 처리가 오래 걸리는 서비스 -> 싱글 스레드이기 때문에   
> 2. 서버 체크 로직이 많은 서비스 -> 콜백 함수의 늪에 빠질 수 있기 때문에   
> 3. 복잡도 / 난이도가 높은 경우 -> 에러가 나면 서버 프로세스가 종료되기 때문에   



- 참고 : https://sjh836.tistory.com/149
