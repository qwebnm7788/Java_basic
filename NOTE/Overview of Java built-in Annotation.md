#Overview of Java Built-in Annotations
Annotation이란 "@" 기호로 시작하는 자바 타입을 말한다. spring이나 hibernate와 같은 프레임워크에서는 이러한
애노테이션을 많이 사용하고 있다. 이러한 애노테이션을 추가함으로써 다음과 같은 추가적인 metadata를 할당할 수 있다.
1. 컴파일러에게 warning이나 error를 알려줄 수 있다.
2. 소스코드를 compile time에 수정할 수 있다.
3. runtime의 behavior를 수정하거나 알아낼 수 있다.

- @Override
overriding은 subclass가 기존의 superclass의 기능을 replace하는 작업을 말하고, overloading은 subclass가 
새로운 기능을 추가할 때 사용한다. 그런데 이 둘은 매우 유사하기 때문에 실수로 오버라이딩을 해야하는 곳에 오버로딩을 할 수 있다.
이럴 때 @Override 애노테이션을 해당 메서드에 추가해주면 정상적인 오버라이딩이 아닌 상태가 될 때 에러를 보여준다.

- @SuppressWarnings
compiler warning은 매우 유용하지만 종종 이를 처리하고 싶지 않거나, 그럴 필요가 없는 경우가 있다.
이럴 때 이 애노테이션을 추가하면 되는데 어떤 타입의 warning을 제거하고 싶은 지 명시할 수 있다. 가장 많이
사용되는 것은 deprecated method나 type을 사용할 때 생기는 "deprecated", raw type을 사용할 때 생기는
"unchecked"가 있다. 명시적인 표현은 둘 이상의 타입에도 적용 가능하다.

- @Deprecated
특정 API를 deprecated시키고 싶을 때 사용한다. 이것이 붙은 메서드를 호출하게 되면 컴파일러가 warning을 뿌리게 된다.
@depreated가 달린 Javadoc과 함께 사용하는 것이 좋은 사용 방법이다.

- @SafeVarargs
varargs(?)

- @FunctionalInterface
lambda(?)

Meta-Annotation

- @Target
annotation이 적용되는 범위를 특정짓기 위해서 사용한다. 생성자, 필드, 메서드 등 이 중에서
사용한 annotation들이 적용되는 것을 명시한다.

- @Retention
annotation이 어느 시점에 유효한 것인지를 명시한다. Source, Class, Runtime으로 구성된다.

- @Inherited
annotation이 사용한 클래스의 sub-class들에게 까지 영향을 줌을 명시한다.

- @Documented
기본적으로 자바는 Javadocs에 annotation의 사용처를 저장하지 않는데, 이 annotation을 사용함으로써 저장하게 해준다. 