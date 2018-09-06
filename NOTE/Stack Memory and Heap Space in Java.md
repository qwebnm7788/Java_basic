# Stack Memory and Heap space in Java
새로운 변수나 객체를 선언하거나, 메서드를 호출하는 것 등의 작업을 하게 되면 JVM은 이러한 작업들을
Stack Memory나 Heap Space에 할당하게 된다.

1. Stack Memory
자바에서의 stack memory는 static memory allocation이나 thread의 실행에 사용된다.
이곳에는 메서드에 속하는 primitive value나 heap의 객체에 대한 reference가 포함된다.
이 메모리에 접근하는 것은 LIFO(Last in First Out) 순서로 진행된다. 새로운 메서드가 호출되면 스택의 최상단에
공간이 생기고 해당 메서드에 속하는 primitive variable이나 reference를 추가하게 된다. 메서드의 실행이 종료되면
상응하는 stack frame은 제거되고 해당 영역은 다시 다른 메서드에게 사용가능한 상태가 된다.

stack memory의 다른 특징은 다음과 같다.
- 새로운 메서드가 호출되고 반환되면서 grow되거나 shrink한다.
- 스택 내부의 변수는 해당 메서드가 수행되는 동안에만 유효하다.
- 메서드의 실행/반환에 따라 자동으로 allocate/deallocate 된다.
- 메모리가 꽉차게 되면 java.lang.StackOverFlowError가 발생한다.
- heap memory에 접근하는 것에 비해 접근 속도가 빠르다.
- 각 스레드는 각자의 stack상에서 동작하므로 이 메모리에 접근하는 것은 thread-safe하다.

2. Heap Space
heap space는 object의 dynamic alloaction이나 JRE 클래스가 runtime에 사용될 떄 이용된다.
새로 생성되는 객체는 항상 heap 영역에 생기며, 이에 대한 reference는 stack memory에 생긴다.
이러한 object들은 global access를 가지며, 애플리케이션의 어디서든지 접근이 가능하다.

이를 좀 더 세분화하면 다음과 같은 영역으로 나눌 수 있다.
1) Young Generation
모든 새로운 객체들이 allocate되며 aged되는 공간이다. 이 곳이 차오르면, minor garbage collection이 일어난다.
2) Old or Tenured Generation
long surviving obejct가 저장되는 곳이다. young generation에 생긴 객체가 나이가 들어서 일정 threashold를 넘어가면
해당 객체는 이곳으로 이동되게 된다.
3) Permanent Generation
runtime class나 application method같은 것을 위한 JVM metadata로 이루어져 있는 공간이다.

힙 영역의 특징은 다음과 같다.
- stack에 비해 굉장히 복잡한 memory management 기술을 통해 접근된다.
- heap 이 꽉차면, java.lang.OutOfMemoryError 가 발생한다.
- stack memory보다 접근 속도가 느리다.
- 스택과 다르게, 자동으로 deallocate되지 않고, Garbage Collector가 unused되는 객체를 수거해가야 한다.
- heap은 thread-safe하지 않아서 synchronize를 위한 별도의 코드가 필요하다. 
