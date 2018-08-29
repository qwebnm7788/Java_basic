#Difference Between Throw and Throws in Java
Exception은 애플리케이션의 normal flow가 interrupt 되었을 때 발생한다.
throw 키워드는 명시적으로 예외를 던질 때 사용한다. 어떠한 메서드나 static block 안에서 사용할 수 있다.
그리고 이렇게 던져지는 예외는 Throwable의 subclass여야 한다.(혹은 그 자체이거나)

throws는 method declaration에 위치하여 어떠한 예외가 해당 메서드에서 던져질 수 있는 지를 명시한다.
이곳에 명시된 예외들에 대해서는 반드시 try-catch문으로 처리해주어야 한다.

결론적으로 Throw와 Throws는 다르다. 서로 interchangeable 하지 않다!

Exception handling에 있어서 good practice는 최대한 specific 한 exception으로 표현하는 것이다.
예를들면 IllegalArgumentException보다는 NumberFormatException과 같이 원인을 알 수 있는 예외가 좋다.
이러한 방식을 위해서 가장 좋은 방법은 해당 상황에 맞는 exception을 새롭게 정의하여 구현하는 것이다.

만약 특정 메서드를 호출할 때 하나하나 throw, throws등으로 처리해주는 코드를 작성하는 것이 싫다면
wrapping하는 방법이 있다. 특정 메서드에 대해 동일한 인터페이스를 갖는 함수를 재작성한 뒤 모든 예외처리를
수행하도록 작성하는 것이다.

여러개의 exception을 catch해야 한다면 (multi-catch) 항상 더 detail한 exception을 먼저 catch 하도록 해야한다.

checked exception은 compile time에 체크가 된다는 의미이다. 이 것의 예로는 IOException, FileNotFoundException 등이 있다.
다시 말하면 해당 exception들에 대한 handling 구문이 반드시 존재해야 한다는 것이다.
한 메서드에서 발생할 수 있는 exception을 처리하지 못했다면 상위 메서드에서라도 반드시 처리하는 구문이 있어야
컴파일이 가능하다.

그에 반대로는 unchecked exception이 있고 이는 compile time에 확인되지 않는 것이다.
대표적이 예로 NullPointerException, ArrayIndexOutOfBoundsException 등이 있다.