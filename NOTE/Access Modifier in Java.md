# Access Modifier in Java
access modifier는 클래스, 변수, 메서드, 생성자에 대한 access level을 설정할 때 사용한다.
여기에는 public, private, protected, default 총 4가지가 존재한다. top-level class에는 public, default만 사용할 수 있으며
member level에서는 4개 모두 사용할 수 있다.
1. Default
keyword를 명시적으로 사용하지 않으면 자바에서는 default access를 부여하게 된다. default access modifier는
package-private이라고 불리기도 하는데, 이는 같은 패키지내에서는 모든 멤버가 visible한 상태가 된다. 그러나 같은 패키지 외에서는
접근이 불가능하다.
2. Public
public 키워드를 쓰면 모든 패키지의 모든 클래스들이 사용할 수 있게 된다. 이것이 access modifier중 가장
least restrictive한 access modifier라고 할 수 있다.
3. Private
private 키워드를 사용한 메서드, 속성, 생성자는 오직 해당 클래스 내에서만 사용이 가능하다.이것이 가장 restrictive한
access modifier가 된다.
4. Protected
public과 private 사이에는 protected가 존재한다. 이 키워드로 선언하게 되면 해당 멤버는 같은 패키지 내의
클래스에서 접근이 가능하다.(package-private과 같음) 여기에 더해서 protected를 선언한 클래스의 모든 subclass에서도 접근이 가능하게 된다.(다른 패키지에 있더라도!)
