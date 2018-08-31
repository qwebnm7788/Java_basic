#Why String is Immutable in Java?
Immutable object란 완전히 생성된 이후에는 내부 상태가 변화하지 않는 객체를 말한다.
즉 해당 객체에 대한 reference나 내부 상태 자체를 어떠한 방식으로던지 수정할 수 없는 것이다.

한 클래스를 immutable하게 만들게 되면 caching, security, synchronization, performance 등에 대해서
여러가지 이득을 볼 수 있게 된다.

String class가 immutable이기에 얻는 이득을 위의 항목에 나누어 살펴보자.
1) Caching
String은 굉장히 자주 사용되는 자료구조라고 할 수 있는데, 이러한 String literal을 재사용 한다면
상당히 많은 양의 heap space를 절약할 수 있다. 실제로 String intern pool은 이러한 목적으로 사용되는 영역인데
이 공간을 이용해서 동일한 literal에 대해서는 단 하나의 copy만을 가진 채 운영되므로 메모리 측면에서 매우 좋다.
2) Security
String은 자바 애플리케이션 내에서 매우 다양하게 사용되는데 비밀번호나, connection 정보 등에 사용되기도 한다.
전달받은 String 값에 대한 reference는 다른 곳에서 계속해서 가지고 있기 때문에 그 값이 중간에 변경된다면
원치않는 결과를 초래할 수 있어진다. 예를 들면 유효성 검사를 통과한 이후, 해당 값이 변화하는 경우도 존재한다.
3) Synchronization
Immutable이라는 것은 자동적으로 thread-safe하다는 것을 보장해주게 된다. 왜냐하면 동시에 여러 스레드에서 해당 객체에 접근하더라도
그 값이 변화하지 않는다는 것이 보장되기 때문이다.
4) Hashcode Caching
String class는 hash 를 구현할때도 자주 사용된다. 해시를 이용할때 hashCode() 메서드를 이용해서
해시코드를 얻게되는데 String이 immutable하기 때문에 동일한 String을 넣으면 항상 동일한 코드가 나오는 것이 보장된다.
따라서 이러한 해시코드 값 자체도 캐시해두고 나중에 동일한 String에 대해서는 재계산하지 않고 저장된 값을 반환할 수 있게 된다.
5) Performance
1, 4번 항목에서 보았듯 Immutable하기 때문에 캐싱이 가능해지고 그에 따라 성능적으로 더 많은 이득을 볼 수 있다. 