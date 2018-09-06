# The Basics of Java Generics
```java
List list = new LinkedList();
list.add(new Integer(1));
Integer i = list.iterator().next();
```

위와 같은 코드에서 맨 마지막 줄에서 컴파일 에러가 나게 되는데 그 이유는 List에서
반환되는 값이 어떤 data type인지 명확하지 않기 때문에 explicit casting을 추가할 것을 요구하기 때문이다.
선언된 리스트는 어떤 객체던지 가질 수 있도록 선언되었기 때문에, 값을 반환하는 것은 단순히 context를 보고 반환하기 때문에 이 값이
Object라는 것만 알 수 있을 뿐이므로 casting이 필요하다.

이와 같은 형태의 코드는 매번 번거롭기도 하며, casting 부분에서 실수를 하게 되면 run-time error로 이어질 수 있다.
```java
List<Integer> list = new LinkedList<>();
```
그러나 위와 같이 리스트를 선언하게 되면 해당 리스트는 Integer type을 위해 specialization으로 축소되어 이 리스트는 Integer type만을
담을 것임을 명시하게 되므로, 컴파일러가 compile time에 타입을 강제하게 된다.
따라서 위에서와 같이 명시적으로 casting을 할 필요가 없어진다.

## Generic method
Generic method는 하나의 메서드로 작성되어 여러가지 타입의 argument로 호출 될 수 있는 메서드를 말한다.
컴파일러는 입력된 타입을 통해 correctness 를 확인한다.
- generic method는 메서드 선언부의 return type 전에 type parameter(다이아몬드 연산자가 type을 감싸는 것)이 추가된다.
- type parameter can be bounded
- method signature에 서로 다른 type parameter가 comma로 분리되어 사용될 수 있다.
- 그 외의 body부분은 일반 메서드와 동일하다.

```java
public <T> List<T> fromArrayToList(T[] a) {
    return Arrays.stream(a).collect(Collectors.toList());
}
``` 

위 코드는 T를 type parameter로 사용하는 함수의 예시이다. type parameter는 대문자로 쓰는 것이 좋다.

### Bounded Generics
type parameter는 bounded 될 수 있는데 여기서 bound의 의미는 "restricted" 이다. 즉 메서드에 의해 허용되는
타입을 제한할 수 있다는 것이다. (제네릭은 원래 어느 타입이 와도 동작하는 것이었지만)
예를 들면 메서드는 특정 타입과 그것의 모든 sub-class들을 허용하거나(upper bound) 혹은 모든 super-class를 허용할 수도 있다(lower bound)

upper bound를 설정할 때는 "extends" 키워드를 사용한다. 여기서의 extends는 해당 타입을 상속받거나, 인터페이스라면 implement한 타입을 허용하겠다는 의미이다.
```java
public <T extends Number> List<T> fromArrayToList(T[] a) {...}
<T extends Number & Comparable>
``` 
또한 여러개를 upper bound로 설정할 수도 있다.

## Using WildCards with Generics
자바에서 wildcard는 "?"로 표시된다. 이는 unknown type을 표현할 때 주로 사용한다.

우선 한 가지 체크할 점은 Object는 모든 자바 클래스의 supertype이라고 할 수 있지만. List<Object>는 모든 List<Type>의 supertype이 아니라는 점이다.
따라서 List<String> 타입의 객체에 List<Object>를 대입하면 컴파일 에러가 발생한다.

```java
public static void paintAllBuildings(List<Building> buildings) {
    buildings.forEach(Building::paint);
}
```

위와 같은 코드를 이용하던 중 Building을 상속받은 House 또한 위와 같은 메서드가 필요해 졌다고 가정하자.
이 때 매개변수로 List<House>를 넘기면 컴파일 에러가 발생한다. (만약 그냥 Building이었다면 사용이 가능했겠지만)
이 경우에 upper bounded wildcard를 사용하면 Building을 상속받는 모든 클래스에 대해서 저 메서드를 공유할 수 있게 된다.
```java
public static void paintAllBuilding(List<? extends Building> buildings) {
    buildings.forEach(Building:paint);   
}
```
만약 해당 클래스와 그 것의 모든 super-class에 대해 사용하고 싶다면 <? super T>와 같은 형식으로 사용하면 된다.

## Type Erasure
generics는 type safety를 보장하기 위해 추가되었지만, runtime시 발생하는 오버헤드를 최소화 하려고 하였다.
그래서 컴파일 타입에 generics에 대한 "type erasure"라는 과정을 컴파일러가 수행한다.
이는 모든 type parameter를 제거하고 그것을 해당하는 실제 타입으로 모두 대체하는 작업을 한다. 만약 unbounded라면 Object 타입이 된다.
따라서 컴파일 과정 후에 생성된 bytecode는 normal class만을 포함하고 있게 된다.