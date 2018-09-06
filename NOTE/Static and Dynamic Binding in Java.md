# Static and Dynamic Binding in Java
Polymorphism을 통해 한 객체는 여러가지 형태에 mapping될 수 있는데 method가 다형성을 띈다면
컴파일러가 해당 메서드를 특정 implementation으로 연결시켜주어야 하는데
만약 이 과정이 compile time에 일어난다면 static or early binding이라고 하며
runtime에 일어난다면 dynamic or late binding이라고 한다.

overloading method는 static binding으로 결정되는데, 만약 super class타입에 하위 클래스를 대입한 형태로
overriding method를 호출하면 컴파일러는 runtime에 mapping을 수행하므로 dynamic binding으로 수행하게 된다.

static function은 static binding을 거치게 된다. 그 이유는 subclass는 static method를 override할 수 없기 때문이다.
비슷하게 final, private method의 경우 JVM은 static binding을 수행한다. static binding으로 수행하면 수행시간이 좀 더 빠르다(?)

