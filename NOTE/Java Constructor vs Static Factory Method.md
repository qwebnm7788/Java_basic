# Java Constructor vs Static Factory Method

Java의 Constructor는 fully-initialized된 class instance를 생성하는
기본적인 메커니즘이다. 이를 통해 필요한 모든 dependency를 주입해준다 (수동/자동으로)

그렇지만 가끔은 static factory method를 통해서 이러한 작업을 수행해야 할 때가 있다.

자바와 같은 객체지향언어에서 생성자를 사용함으로써 얻는 문제점은 없다. 그렇지만
Effective Java에서도 생성자 대신 static factory method를 이용하는 것을 고려해보라고 할 정도로
고려해볼만한 사항이다.

static factory method를 사용하면 얻는 이점은 다음과 같다.

1. Constructor와 달리 의미있는 메서드 이름을 지을 수 있다. 생성자는 언어에서 강제하는 이름으로만 만들 수 있다.
2. 반환형을 다양하게 선택할 수 있다.
3. Static factory methods can encapsulate all the logic required for pre-constructing fully initialized instances(?)
4. Static factory methods can be controlled-instanced methods(?)

JDK에서 static factory method를 사용하는 예는 다음과 같다.

1) String class
String 자체는 "interning" 때문에 생성자를 이용하여 사용되는 일은 거의 없다. 그렇지만
new String("") 형태는 올바른 문법이다. 만약 새로운 String 객체를 static factory method를 이용하여
생성하고 싶다면 valueOf() 라는 메서드를 사용하면 된다.

```java
String value1 = String.valueOf(1);
String value2 = String.valueOf(1.0L);
```

2) Optional Class
3) Collections Class

생성자에서 field들을 초기화 하는 것 이외에 여러가지 로직을 추가적으로 계속 넣는 것은
Single Responsibility Principle을 위배하게 되어 monolithic constructor를 만들어내게 되는
원인이 된다. 따라서 static factory method를 이용하여 객체의 생성에 추가적인 사항을
더해주는 역할을 하게 만드는 것이 좋다.