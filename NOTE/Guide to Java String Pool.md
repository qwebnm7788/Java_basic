#Guide to Java Spring Pool

Java String Pool이란 JVM에 의해 Strings가 저장되는 특별한 메모리 공간을 말한다.

자바에서의 String은 Immutable하기 때문에 JVM은 이러한 속성을 이용하여 pool안에 특정 String에 대해
오직 단 하나의 copy만을 저장해 둠으로써 저장공간을 optimize시켜 사용한다. 이러한 과정을 "Interning"이라고 한다.

예를들어, String 변수를 만들고 값을 할당하면 JVM은 pool에서 동일한 value를 갖는 String이 존재하는 지를 먼저 탐색한다.
만약 존재한다면, 단순히 그것의 메모리 주소에 대한 참조를 반환하게 되고, 없다면 해당 값을 pool에 등록하고(interned) 그것의 참조를 반환하게 된다.

Constructor를 이용하여 String 값을 할당하게 되면 컴파일러는 새로운 객체를 생성하여 heap영역에 두게 되므로
새롭게 생성되는 동일한 문자열을 갖는 String 값들은 모두 서로 다른 메모리 영역에 고유한 메모리 주소를 갖게된다.

Manual Interning을 이용하면, 사용자가 직접 intern을 할 수 있다. intern() 메서드를 호출하면
해당 String을 pool에 등록하고, JVM은 그것에 대한 reference를 반환한다.

Java7 이전에는 이러한 Pool이 PermGen space에 저장되어 GC의 영역에서 벗어나기 때문에
너무 많은 String을 등록하게 되면 OutOfMemory Error를 보게 되었지만, 이후에는 Heap space에
저장되도록 수정되어, 사용되지 않는 pool내의 String은 GC가 제거하게 되어 이러한 위험이 줄어들게 되었다.

pool size를 키우게 되면, 메모리를 더 사용하지만 String을 이 테이블에 넣는데 드는 시간이 줄어들게 된다.