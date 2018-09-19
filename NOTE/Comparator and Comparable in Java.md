# Comparator and Comparable in Java

custom type을 사용하거나 직접적으로 비교가 불가능한 두 객체를 비교할 때는 직접 comparision strategy를 정의해야 하는데
이 때 가장 쉽게 사용할 수 있는 방법이 Comparator 나 Comparable interface를 구현하는 것이다.

# Comparable
Comparable 은 서로 같은 타입의 객체간의 비교 전략을 정의하는 인터페이스이다. 이는 클래스의 "natural ordering"이라고 한다.
sorting order는 compareTo() 메서드의 반환값에 의해 결정되는데 이 값을 통해 현재 비교하는 클래스가 인자로 주어진 객체보다
작은지, 같은지, 큰지 여부에 따라 값이 달라진다.

# Comparator
Comparator 인터페이스는 compare(arg1, arg2) 메서드를 통해 Comparable.compareTo()와 비슷하게 매개변수로 주어진 두 객체를
비교하는 연산을 수행한다.

이렇게 만든 Comparator는 Collections.sort 메서드의 두 번째 인자로 전달하여 원하는 형태로 값을 정렬할 수 있도록 해준다.

# Comparator VS Comparable
Comparable interface는 default ordering을 정의하고 싶을 때 유용하다. Comparator를 사용하는 경우는 몇 가지가 있는데 우선 기존의 
소스코드를 수정할 수 없어서 Comparable을 구현하도록 만들 수 없는 경우가 있다. 또한 Comparator를 쓰면 기존에 있던 Domain class에
별도의 코드가 추가되지 않을 수 있고, 동일 타입에 대해 여러가지의 comparision strategy를 정의할 수 있다는 장점이 있다.

Java8 에서는 람다를 이용하거나 comparing 메서드를 이용한 방식이 추가되었는데 궁금하다면 찾아보자.