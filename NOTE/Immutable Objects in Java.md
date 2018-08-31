#Immutable Objects in Java
Immutable object는 생성 이후 내부 상태가 변하지 않는 객체를 말한다.
이것을 좀 더 자세히 말하자면 이러한 객체는 public API로 자신의 상태를 수정하는 기능을 제공하지 않는다.
예를 들어 String.replace() 메서드는 자신을 수정하는 것처럼 보이지만 실제로는 수정하지 않고 새로운 객체를 만들어 반환한다.

immutability 를 달성하는 방법은 무엇이 있을까?
final keyword를 먼저 보면, 처음 값이 할당된 이후에는 변경하지 못하도록 도와주는데, 이것은 단지 reference를 변경하지 못하게 하는 것 뿐이다.
실제 객체 내부는 변화할 수 있는데 다음의 예를 보면 알 수 있다.
```java
final List<String> strings = new ArrayList<>();
assertEquals(0, strings.size());
strings.add("baeldung");
assertEquals(0, strings.size());
```
두번째 assertEquals는 실패하게 된다.

모든 primitive type에 대해서는 final 키워드를 추가하게 되면 immutable하게 관리할 수 있지만 그 외의 경우에는
reference로 존재하는 것이기 때문에 참조하는 거기에 final을 붙힌다고 해도 internal state는 변화할 수 있다. 따라서
참조하고 있는 object 자체가 immutability를 보장해야 의미가 있다. 그리고 그것을 사용하는 객체에서는 참조하는 객체의 read-only 메서드만을
public하게 제공해야 한다.

이러한 immutable object를 사용하게 되면 항상 thread-safe를 보장할 수 있으며, side-effect free하다.