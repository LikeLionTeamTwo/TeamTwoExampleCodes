## 문제 1: 기본적인 인터페이스 구현

### 요구사항

1. `Printer` 인터페이스를 정의한다.
    - 메서드: `void print(String message)`
2. `Printer` 인터페이스를 구현하는 `ConsolePrinter` 클래스를 만든다.
    - `print(String message)` 메서드에서 전달받은 메시지를 콘솔에 출력한다.
3. `main` 메서드에서 `Printer` 타입 변수에 `ConsolePrinter` 객체를 할당하고, `print` 메서드를 호출해 메시지를 화면에 출력해보자.

### 포인트

- 인터페이스 선언과 구현 연습
- 인터페이스 타입으로 구현 클래스를 참조하는 기본 패턴 익히기

---

## 문제 2: 다중 구현 연습

### 요구사항

1. `Movable` 인터페이스를 정의한다.
    - 메서드: `void move(int x, int y)`
2. `Drawable` 인터페이스를 정의한다.
    - 메서드: `void draw()`
3. `GameObject` 클래스를 만들고, `Movable`, `Drawable`를 동시에 구현한다.
    - `int x, y` 필드를 갖는다.
    - `move(int x, int y)` 메서드 구현 시: x,y 좌표를 갱신
    - `draw()` 메서드 구현 시: 현재 좌표를 "객체가 (x,y)에 그려졌습니다." 형태로 출력
4. `main` 메서드에서 `GameObject` 객체를 만들고, `move`와 `draw`를 호출해 동작을 확인한다.

### 포인트

- 인터페이스 다중 구현 경험
- 한 클래스에서 여러 기능(이동, 그리기)을 인터페이스로부터 강제하는 구조 이해

---

## 문제 3: 인터페이스를 통한 기능 확장

### 요구사항

1. `Calculator` 인터페이스를 정의한다.
    - 메서드: `int add(int a, int b)`, `int subtract(int a, int b)`
2. `Calculator`를 구현하는 `BasicCalculator` 클래스를 만든다.
    - 단순히 `+`, `-` 연산 결과를 반환
3. 기존 코드 수정 없이 기능을 확장하기 위해 `Multipliable` 인터페이스를 추가한다.
    - 메서드: `int multiply(int a, int b)`
4. `Multipliable`을 구현하는 `AdvancedCalculator` 클래스를 만든다.
    - `multiply` 메서드 구현
    - 추가로 `AdvancedCalculator`는 `Calculator`도 구현해 `add`, `subtract`도 가능하게 한다.
5. `main` 메서드에서 `Calculator` 타입으로 `BasicCalculator`와 `AdvancedCalculator`를 각각 사용해보고, `AdvancedCalculator`를 `Multipliable` 타입으로 사용해 `multiply`도 호출해본다.

### 포인트

- 인터페이스를 이용한 기능 확장과 다형성 체험
- 기존 코드(인터페이스)는 건드리지 않고 새 인터페이스와 클래스를 추가하여 기능을 확장하는 구조 이해

---

## 문제 4: 인터페이스를 이용한 전략 교체 (Strategy Pattern 맛보기)

### 요구사항

1. `Attackable` 인터페이스를 정의한다.
    - 메서드: `void attack()`
2. `SwordAttack`, `BowAttack` 클래스를 만들어 `Attackable` 구현
    - `SwordAttack`: "칼로 공격합니다!"
    - `BowAttack`: "활로 공격합니다!"
3. `Character` 클래스를 만들고, `Attackable attackStrategy` 필드를 갖는다.
    - `setAttackStrategy(Attackable strategy)` 메서드로 현재 공격 전략을 교체할 수 있게 한다.
    - `performAttack()` 메서드에서 `attackStrategy.attack()` 호출
4. `main` 메서드에서 `Character` 객체를 만들고, 처음에는 `SwordAttack`으로 설정 후 `performAttack()` 호출, 이후 `BowAttack`으로 전략을 바꿔 다시 `performAttack()` 호출한다.

### 포인트

- 인터페이스를 통한 전략(행동) 교체 아이디어 체험
- 코드 수정 없이(인터페이스 규격 유지만으로) 다양한 구현 클래스를 쉽게 교체 가능함을 이해

---

## 문제 5: 인터페이스 상속

### 요구사항

1. `Readable` 인터페이스 정의
    - 메서드: `String readContent()`
2. `Writable` 인터페이스 정의
    - 메서드: `void writeContent(String content)`
3. `ReadWritable` 인터페이스를 만들고, `Readable`과 `Writable`을 상속받는다.
4. `FileHandler` 클래스를 만들어 `ReadWritable` 구현
    - `readContent()` 메서드: "파일에서 내용을 읽습니다." 반환
    - `writeContent(String content)` 메서드: "파일에 내용을 썼습니다." 출력
5. `main`에서 `ReadWritable` 타입으로 `FileHandler` 객체를 다루며 `readContent()`, `writeContent()` 호출

### 포인트

- 인터페이스 상속을 통해 인터페이스의 기능 확장 연습
- `Readable`, `Writable`로 나눠진 기능을 상속해 `ReadWritable`로 통합하는 구조 이해

- 인터페이스 선언과 구현하는 방법
- 다중 구현을 통한 클래스의 다기능화
- 인터페이스로부터 강제되는 일관된 메서드 이름과 시그니처
- 인터페이스 타입 변수를 통해 구현 클래스를 유연하게 교체하는 방법
- 인터페이스 상속을 통한 기능 확장

# 예외처리

---

## 문제 1: 나눗셈 예외 처리

### 요구사항

1. 두 개의 정수 `a`, `b`를 코드 상에서 정하거나 `Scanner`로 입력받는다.
2. `a / b` 연산을 수행하는 메서드를 만들고, `main`에서 호출한다.
3. `b`가 0일 경우 `ArithmeticException`이 발생할 수 있다.
4. `try-catch` 블록을 사용하여 `0으로 나눌 수 없습니다.`라는 메시지를 출력하고, 예외 상황을 안전하게 처리한다.

### 포인트

- 0으로 나누는 상황에서 발생하는 `ArithmeticException` 처리
- 기본적인 `try-catch` 사용법 익히기

---

## 문제 2: 배열 인덱스 예외 처리

### 요구사항

1. 길이가 3인 정수 배열을 선언하고, `{10, 20, 30}`으로 초기화한다.
2. 사용자에게 배열 인덱스를 하나 입력받은 후, 해당 인덱스의 값을 출력하는 메서드를 만든다.
3. 0~2 이외의 인덱스를 입력하면 `ArrayIndexOutOfBoundsException`이 발생한다.
4. `try-catch`를 통해 인덱스 범위를 벗어난 경우 `"인덱스 범위를 확인하세요!"`라는 메시지를 출력하고 프로그램이 정상 종료되도록 한다.

### 포인트

- 범위 밖의 인덱스로 배열 접근 시 발생하는 예외 처리
- 사용자 입력에 대한 유효성 검증 연습

---

## 문제 3: 문자열 길이 예외 처리

### 요구사항

1. 문자열 변수를 하나 선언하고, `null`로 초기화한다.
2. 해당 문자열의 길이를 출력하는 코드를 작성한다. (`str.length()`)
3. `null` 상태에서 `length()`를 호출하면 `NullPointerException` 발생
4. `try-catch`로 `NullPointerException`을 처리하고 `"문자열이 null 상태입니다."`라고 출력한다.

### 포인트

- `NullPointerException` 처리 연습
- 변수가 null일 수 있는 상황에서의 예외 대비

---

## 문제 4: 형변환 예외 처리(선택 문제)

### 요구사항

1. 문자열 변수 `String numStr = "123a"` 라고 초기화한다.
2. `Integer.parseInt(numStr)`를 호출해 정수로 변환하려 한다.
3. `Integer.parseInt("123a")`는 숫자 이외의 문자를 포함하므로 `NumberFormatException` 발생
4. `try-catch`로 `NumberFormatException`을 처리하고 `"숫자가 아닌 값은 정수로 변환할 수 없습니다."`라고 출력한다.

### 포인트

- `NumberFormatException` 처리 연습
- 문자열 파싱 시 예외 상황 경험

---