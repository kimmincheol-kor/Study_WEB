# Node.js - HTTP
출처 : [Node.js 공식 문서](https://nodejs.org/ko/docs/guides/anatomy-of-an-http-transaction/)

서버 생성
--------
- 모든 Node 웹 서버 어플리케이션은 `웹 서버 객체`를 만들어야한다. => `createServer()`
- createServer()가 반환하는 `Server` 객체는 `EventEmitter` 객체이다. => 리스너를 추가.
- 서버가 수신하는 HTTP 요청마다 createServer 객체에 전달된 함수가 호출된다.
```
const http = require('http');

const server = http.createServer((request, response) => {
  // 여기서 작업이 진행됩니다!
});
```

HTTP 요청 처리
--------
- HTTP 요청이 서버에 오면 Node가 트랜잭션을 다루기 위해 Request와 Response 객체를 server 객체에 전달하며 핸들러 함수를 호출한다.
```
const server = http.createServer();
server.on('request', (request, response) => {
  // 여기서 작업이 진행됩니다!
});
```

- 요청을 처리할때, request 객체에는 `headers`, `method`, `url` 프로퍼티가 존재한다.
```
const {headers, method, url} = request;
```

- POST나 PUT 요청을 처리할때에는 Body 요소가 중요하다.
```
let body = [];
request.on('data', (chunk) => {
  body.push(chunk);
}).on('end', () => {
  body = Buffer.concat(body).toString();
  // 여기서 `body`에 전체 요청 바디가 문자열로 담겨있습니다.
});
```

오류 처리
--------
- request 객체는 `ReadableStream`이므로 `EventEmitter`이기도 하기 때문에, 오류 발생시 EventEmitter처럼 동작한다. => 이벤트 리스너에 오류 처리가 등록되어 있지 않다면 시스템에 영향을 준다.
```
request.on('error', (err) => {
  // 여기서 `stderr`에 오류 메시지와 스택 트레이스를 출력합니다.
  console.error(err.stack);
});
```

- response 객체는 `WritableStream`이므로 동일하다.

HTTP 응답 처리
--------
- HTTP `상태 코드`는 response.statusCode = 200 | 404 | etc...
- HTTP `응답 헤더`는 response.setHeader('Content-Type', 'application/json')
	- 헤더를 여러번 설정한다면, 마지막에 설정한 헤더가 적용된다.

- 명시적인 헤더 데이터 전송
```
response.writeHead(200, {
  'Content-Type': 'application/json',
  'X-Powered-By': 'bacon'
});
```

- 응답 `Body` 전송
```
response.write('<html>');
response.write('<body>');
response.write('<h1>Hello, World!</h1>');
response.write('</body>');
response.write('</html>');
response.end();
```

에코 서버 예제
--------
- 요청받은 데이터를 그대로 응답으로 돌려보내는 서버 => `에코 서버`
```
const http = require('http');

http.createServer((request, response) => {
  let body = [];
  request.on('data', (chunk) => {
    body.push(chunk);
  }).on('end', () => {
    body = Buffer.concat(body).toString();
    response.end(body);
  });
}).listen(8080);
```

- 요청 메소드가 `POST`이면서 URL이 `/echo`인 경우에만 처리
```
const http = require('http');

http.createServer((request, response) => {
  if (request.method === 'POST' && request.url === '/echo') {
    let body = [];
    request.on('data', (chunk) => {
      body.push(chunk);
    }).on('end', () => {
      body = Buffer.concat(body).toString();
      response.end(body);
    });
  } else {
    response.statusCode = 404;
    response.end();
  }
}).listen(8080);
```
이렇게 특정 Method, 특정 URL을 검사하여 처리하는 것을 `라우팅`한다고 한다.

요약
--------
- 요청 핸들러 함수로 HTTP 서버의 인스턴스를 생성하고 특정 포트로 서버를 열 수 있습니다.
- request 객체에서 헤더, URL, 메서드, 바디 데이터를 가져올 수 있습니다.
- URL이나 request 객체의 데이터에 기반을 둬서 라우팅을 할 수 있습니다. 
- response 객체로 헤더, HTTP 상태 코드, 바디 데이터를 보낼 수 있습니다.
- request 객체에서 response 객체로 데이터를 파이프로 연결할 수 있습니다.
- request와 response 스트림 모두에서 스트림 오류를 처리할 수 있습니다.
