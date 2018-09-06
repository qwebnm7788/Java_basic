# Polymorphism in Java
polymorphism의 가장 핵심적인 두 가지 타입은 static/compile-time polymorphism과 dynamic/runtime polymorphism이 있다.

## Static Polymorphism
static polymorphism은 compile time에 resolve되어 run-time virtual-table lookup을 제거한 polymorphism이라고 할 수 있다.

```java
public class TextFile extends GenericFile {
    //...
 
    public String read() {
        return this.getContent()
          .toString();
    }
 
    public String read(int limit) {
        return this.getContent()
          .toString()
          .substring(0, limit);
    }
 
    public String read(int start, int stop) {
        return this.getContent()
          .toString()
          .substring(start, stop);
    }
}
```
위와 같은 코드는 컴파일 과정에서 컴파일러가 read() 메서드를 호출하는 모든 부분에 대해서 위의 세 개중 어느것을
호출하는지를 결정짓는다. (어느것이 적합한 것인지)

##Dynamic Polymorphism
상위 클래스 타입의 인스턴스에게 하위 클래스가 할당되었을 때 JVM이 적절한 메서드를 탐지하여 실행시켜주는 형태의
다형성을 Dynamic Polymorphism이라고 한다. 이를 다시 말하면 method overriding을 했을때의 처리를 JVM이 해주는데
이것을 말하는 것이다. 상위 클래스 타입의 객체에 하위 클래스가 할당되면 오버라이딩 된 함수가 호출된다는 것을 알 수 있다. (예제코드 참조)

Polymorphism이 자바에서 사용되는 예를 살펴보자
1. Coercion
```java
String str = “string” + 2;
```
컴파일러가 implicit type conversion을 진행함으로써 type error를 방지한다.
2. Operator Overloading

+기호는 수학적인 기호로도, String concatenation으로도 사용될 수 있다.
3. Polymorphic Parameters
```java
public class TextFile extends GenericFile {
    private String content;
     
    public String setContentDelimiter() {
        int content = 100;
        this.content = this.content + content;
    }
}
``` 
4. Polymorphic Subtypes
?

Polymorphism의 문제점

사용중에 Upcasting을 하게 되면 하위 클래스에서 새롭게 구현한 메서드를 사용할 수 없게 되는 일이 발생하는데
이러한 문제를 해결할때 DownCasting을 이용하게 된다. 그런데 이렇게 되면 실제 type checking을 보장하지 않기 때문에
문제가 발생할 수 있다. 이러한 것을 위해 JVM은 Run-Time Type Information(RTTI) check를 수행한다. 거기에 또
우리가 instanceof keyword를 통해 명시적으로 type identification을 수행할 수 있다.
그렇지만 RTTI는 high cost이고 instanceof를 남발하는 코드는 좋지 않은 코드라고 알려져 있다.

 또다른 문제는 base class에 수정이 하위 클래스들에게 문제를 일으킬 수 있다는 것이다. 이를 방지하기 위해서는
 적절한 final keyword와 documentation이 필요하다.