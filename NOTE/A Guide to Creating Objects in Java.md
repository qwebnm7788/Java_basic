# A Guide to Creating Objects in Java
JVM 상에서 객체를 사용하기 전에는 반드시 초기화를 수행해야 한다.

"Declaration"은 변수를 정의하는 과정을 말하고 "Initialization"은 값을 할당하는 것을 말한다.
field의 타입별로 초기화하는 부분이 다르게 동작하게 된다.

## Objects vs Primitives
자바는 두가지 타입의 data representation을 제공하는데 하나는 primitive type이고 다른 하나는 reference type이다.

자바는 기본적으로 8가지의 built-in data type을 갖는데 이를 primitive type이라고 한다. 이러한 타입은 자신의 값을 직접 쥐고 있는 형태이다.
reference type은 객체에 대한 reference를 갖고 있는데 primitive type과 달리 변수가 할당된 메모리 공간에 그 값을 직접적으로 갖는 것이 아닌
실제 object가 저장된 공간에 대한 memory address의 값을 갖고 있게 된다.

object creation은 primitive type과 달리 좀 더 많은 초기화 과정을 거치게 된다. 우선 new keyword를 이용하는데 이는 새로운 객체를 생성자를 통해
메모리를 할당 받도록 해준다. 생성자는 보통 객체가 갖는 주요 속성인 instance variable을 초기화 하는데 사용된다. explicit하게 생성자를 
정의하지 않았다면 컴파일러가 기본 생성자를 만들어준다. 생성자는 overloading하여 여러개 만들어 줄 수도 있으며, 모든 생성자는 따로 명시하지 않더라도
자신의 상위 클래스의 생성자를 부르게 된다. (super()를 통해)

## Variable Scope
Instance와 class variable은 따로 초기화할 필요가 없는데, 그 이유는 default value를 갖기 때문이다. 처음 선언되는 순간 이러한 기본값을 갖도록
설정되어 있다. 그와 반대로 local variable은 사용하기 전에 반드시 초기화 되어야 한다. 기본값을 갖지 않기 때문인데, 만약 초기화 하지 않았다면
컴파일러가 에러를 뿜게될 것이다.

final keyword를 사용하게 되면 initialization 이후 더 이상 field의 값이 변하지 않을 것임을 의미하게 되는 것이다. 이렇게 된 변수를 보통 
상수(Constant)라고 하는데 이런 상수는 declare될 때나, constructor안에서 초기화 되어야만 한다.

## Initializers
자바에서의 initializer는 이름이나 data type이 명시되지 않은 단순한 block of code의 형태로 메서드나, 생성자, block 어디에도 속하지 않은
채로 존재한다. 우선 instance initalizer는 instance variable을 초기화 하기 위한 것이고, static initialization block은 static field를
초기화 하기 위한 곳이다. (즉 static keyword가 달린 변수를 초기화 하기 위한 공간)

초기화 되는 순서는 다음과 같다.
1. static variable and static initializers in order
2. instance variable and instance initializers in order
3. constructor

## Object Life Cycle
자바에서는 object destruction을 따로 신경쓰는 것이 아닌, garbage collector가 관리해주는 방식을 따른다.
자바의 모든 객체는 프로그램의 heap memory에 저장된다. garbage collector는 더이상 reachable하지 않은 object를 지워줌으로써
자동으로 메모리를 관리해주는 프로그램이라고 할 수 있다.
object 가 unreachable되는 상황은 두 가지가 있는데 하나는 객체가 더 이상 누구에게도 reference당하지 않는 경우이고 다른 하나는
해당 객체를 가리키는 reference가 out of scope가 될 때이다.


## Other Methods for Creating Objects
Reflection는 class, field, method를 run-time에 조사하는 mechanism이라고 할 수 있다.
(예를 들어 클래스의 constructor를 찾아서 invoke하는 형태로 코드를 작성할 수 있다.)

Cloning은 object의 exact copy를 만들어내는 방법이다. 이를 위해서는 해당 object가 Cloneable interface를 구현하고 있어야 한다.
그러면 clone() method를 호출하여 기존 객체가 가진 property와 동일한 값을 갖는 객체를 얻어낼 수 있다.

또한 sun.misc.Unsafe 클래스를 통해 생성자를 호출하지 않고 객체를 위한 메모리를 할당받을 수도 있다..

