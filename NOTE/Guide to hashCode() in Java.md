# Guide to hashCode() in Java
Hashing은 HashMap, HashSet등의 Collections에서 사용되는 중요한 알고리즘 중 하나이다.
여러 Map Interface들은 Hash Table을 이용하여 구현되는데, 이러한 해시 테이블을 사용할 때 주어진 key에 대해
hashCode() 메서드를 이용하여 hash code를 계산해낸다.

hashCode()는 내부의 hashing algorithm을 이용하여 정수 값을 반환하게 된다. 동일한 두 객체는 (equals()로 판단할 때) 반드시
동일한 값을 반환해야 하지만 서로 다른 객체라도 동일한 값을 반환할 수 있다. (좋은 해시 알고리즘일수록 이런 일은 적게 발생한다)

equals()와 hashCode()는 각각 다르게 구현할 수 있지만 서로 consistency를 잘 유지하도록 주의하여 작성해야 한다(?)
hashCode()는 직접 작성할 수도 있지만 이클립스, 인텔리제이 등의 IDE가 제공해주는 기본적인 구현이 있고 Lombok을 이용하면 간단히 annotation을
추가하는 것만으로도 사용할 수 있다.

좀 더 좋은 hashCode()를 설계하는 법이 궁금하다면 "Effective Java"를 보자.
종종 이런 함수의 구현에 31이란 숫자가 등장하는데 31은 다음과 같은 특성이 있는 소수라 자주 사용된다고 한다.
```java
31 * i == (1 << 5) - i
```
이렇게 되면 곱셈을 비트 연산과 뺄셈으로 치환할 수 있어 좀 더 빠른 속도로 계산이 가능하다.

좋은 해시 알고리즘을 사용하더라도 collision은 발생할 수 있다. 이 문제를 해결하는 가장 대표적인 방법은
linked list를 이용한 separate chaining이다. 자바의 HashMap은 이 방식을 사용한다. 그러나 이런 방식에서도 동일한
bucket에 계속해서 값이 들어가게 되면 탐색 시간이 linear하게 변한다. Java8 이후에는 한 bucket의 크기가 특정
threshold를 넘어가면 balancedTree로 변환하여 저장하는 구현방법이 적용되어 최악의 경우에도 O(logN)의 탐색시간을 보장한다.

참고 http://openjdk.java.net/jeps/180