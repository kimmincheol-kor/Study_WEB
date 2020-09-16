# TypeScript

- TypeScript Intro & Setting
   - https://poiemaweb.com/typescript-introduction
- Why You Shouldn't Be Scared
   - https://han41858.tistory.com/14
   
<img src = "https://poiemaweb.com/img/atscript.png"/>

Introduction
--------

#### `JavaScript`
   - 자바스크립트는 1995년 넷스케이프사의 브렌던 아이크(Brendan Eich)가 자사의 웹브라우저에 탑재하기 위해 개발한 `스크립트 언어`
   - 초창기 자바스크립트는 웹페이지의 보조적인 기능을 수행하기 위해 `한정적인 용도`로 사용
   - HTML5가 등장함으로써 플러그인에 의존하던 구축 방식은 자바스크립트로 대체
   - AJAX의 활성화로 데스크탑 애플리케이션과 유사한 사용자 경험을 제공할 수 있는 SPA(Single Page Application)가 대세
   - 서버 측이 담당하던 업무의 많은 부분이 클라이언트 측으로 이동
   - 서둘러 출시된 문제와 과거 웹페이지의 보조적인 기능을 수행하기 위해 한정적인 용도로 만들어진 `태생적 한계`
   
   - 다른 언어와 구별되는 특성
      - Prototype-based Object Oriented Language
      - Scope & this
      - 동적 타입(Dynamically typed) 언어

#### `TypeScript`
   - 자바스크립트의 한계를 극복하기 위해 파생된 `AltJS`(자바스크립트 대체 언어) : CoffeeScript, Dart, Haxe ,,,
   - TypeScript는 컴파일하면 JavaScript가 되는(`compile-to-JavaScript`) 언어
   - `컴파일 시점에 타입 체크`를 하고, `전통적인 객체기반 프로그래밍 패턴` 등 강력한 기능들이 JavaScript에 추가된 언어
   
   - TypeScript는 `인터페이스`와 `추상 클래스`, `대수(algebraic) 데이터 타입` 등의 기능을 JavaScript 에 더하며, 다른 라이브러리들을 추가적으로 사용하지 않아도 된다.

*TypeScript 또한 자바스크립트 대체 언어의 하나로써 자바스크립트(ES5)의 Superset(상위확장)이다. C#의 창시자인 덴마크 출신 소프트웨어 엔지니어 Anders Hejlsberg(아네르스 하일스베르)가 개발을 주도한 TypeScript는 Microsoft에서 2012년 발표한 오픈소스로, 정적 타이핑을 지원하며 ES6(ECMAScript 2015)의 클래스, 모듈 등과 ES7의 Decorator 등을 지원한다.*


장점
--------
1. 정적 타입 (Statically typed) 언어
   - 컴파일시 변수의 `타입`이 결정된다.
   - 코드의 예측성을 높이고 디버깅을 쉽게 한다.

2. 도구의 지원
   - 다양한 도구의 지원을 받을 수 있다.
   - 높은 수준의 인텔리센스(IntelliSense), 코드 어시스트, 타입 체크, 리팩토링 등을 지원, 대규모 프로젝트를 위한 필수 요소이다.

3. 친숙함 - 강력한 객체 지향 프로그래밍 지원
   - 인터페이스, 제네릭 등과 같은 강력한 객체지향 프로그래밍 지원은 크고 복잡한 프로젝트의 코드 기반을 쉽게 구성할 수 있도록 돕는다.
   - Java, C# 등의 클래스 기반 객체지향 언어에 익숙한 개발자가 자바스크립트 프로젝트를 수행하는 데 진입 장벽을 낮추는 효과도 있다.

4. JavaScript 표준과 상위 호환 - ES6 / ES Next 지원
   - 현재 ES6를 완전히 지원하지 않고 있는 브라우저를 고려하여 Babel 등의 트랜스파일러를 사용해야 하는 현 상황에서 TypeScript 개발환경 구축에 드는 비용은 비슷하다.
   - TypeScript는 아직 ECMAScript 표준에 포함되지는 않았지만 표준화가 유력한 스펙을 선제적으로 도입하므로 새로운 스펙의 유용한 기능을 안전하게 도입하기에 유리하다.
   
단점
--------
1. 개발 환경 구축 : 컴파일을 하기 위한 옵션 설정, 기본적으로 설치해야하는 모듈 존재.

2. VanillaJS에 비해 떨어지는 가독성 : 타입스크립트를 사용하는 목적을 살리기 위해 코드를 작성하면 길어진다.
