#Introduction to Java Serialization
Serialization이란 객체의 상태를 byte stream으로 변환하는 것을 말한다. (Deserialization은 그 반대)
다시 말하면 자바 객체를 데이터베이스에 저장되거나 네트워크를 통해 전송될 수 있는 byte sequence로 변환하는 것을 말한다.

serialization 과정은 instance-independent하다. 즉 한 플랫폼에서 serialize된 것은 다른 곳에서 deserialize 될 수 있다.
Serializable이란 인터페이스를 구현한 클래스만 serialization을 할 수 있다.

예를 들어 ObjectInput(Output)Stream은 이러한 (De)Serialization 과정을 수행하는 데 사용할 수 있다.

```java

public class Person implements Serializable {
    private static final long serialVersionUID = 1L;
    static String country = "ITALY";
    private int age;
    private String name;
    transient int height;
 
    // getters and setters
}
``` 

static 필드는 serialize 대상에서 제외되며 또한 transient 키워드를 통해 특정 필드를 대상에서 제외할 수 있다.

Serializable 인터페이스를 구현할 때 주의해야 할 점은, 한 클래스가 이를 구현한다면 그 아래의 모든 sub class는 모두 serializable하게 된다.
그와 반대로 만약 한 객체가 다른 객체에 대해 reference를 갖는 상태로 serializable을 구현한다면
그 객체는 serializable을 따로 구현해야 한다.

JVM은 serializable class와 version number를 연관시켜 관리하는데 이는 객체가 저장되고 로드되면서 이 값을 비교함으로써
serialization상에서 compatible 한지 여부를 판단하는데 사용된다.
이 수는 SerialVersionUID라고 하는데 대부분의 IDE는 자동으로 생성해준다. 만약 이 필드가 존재하지 않는다면 JVM은 런타임에 만들어 사용한다.

자바에서는 serialize하는 default way를 제공하지만 custom하게 수정하여 사용할 수도 있다. 이때는 readObject(), writeObject()를
오버라이딩 하여 사용하는데 이를 통해 직렬화 할 수 없는 값을 가능한 형태로 수정할 수 있다는 장점이 있다.