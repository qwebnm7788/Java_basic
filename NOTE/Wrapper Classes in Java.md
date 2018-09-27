# Wrapper Classes in Java
wrapper class는 primitive java type을 encapsulate해주는 객체를 말한다.
각각의 모든 Java primitive들은 자신과 상응하는 wrapper가 존재하는데 예를 들면 boolean type에겐 Boolean Wrapper class가 존재한다.
이러한 wrapper class는 java.lang package에 정의되어 있으므로 따로 import할 필요는 없다.

Wrapper Class가 필요한 이유는 generic class가 object만을 지원하기 때문이다. primitive들은 지원하지 않기 때문에 Collectino framework와 
같은 것을 사용할 때 단순히 add(5)를 사용할 수 없고, 5를 wrapper class로 변환한 뒤에 수행해야 한다.
예전에는 Autoboxing을 지원하지 않아서 이러한 작업을 하나씩 직접해주어야 했지만, 최근에는 add(5)와 같은 코드를 작성하더라도
자동으로 wrapper class로 변환하여 값을 저장하게 된다.

primitive value를 그에 맞는 wrapper class로 변환하는 방법은 두가지가 있는데 하나는 생성자를 이용하는 것이고,
다른 하나는 static factory method를 사용하는 것이다.

```java
Integer object = new Integer(1);

Integer anotherObject = Integer.valueOf(1);
```

valueOf() 메서드는 주어진 int value에 해당하는 값을 반환하게 된다. 이 메서드는 값을 캐싱해두어 성능을 향상시키는 방법을 내부적으로
가지고 있다.(-128~+127은 항상 캐싱되어 있음)

이와 반대로 wrapper class를 primitive로 변환하는 방법은 intValue(), doubleValue()와 같은 메서드를 사용한다.

위처럼 수동으로 값을 변환할수도 있지만, Java5 이후부터는 이러한 변환이 autoboxing/unboxing 이라 불리는 방식으로 자동으로 이루어진다.
"Boxing"은 primitive object를 상응하는 wrapper object로 변환하는 것을 의미하는데 이러한 과정이 자동으로 일어나는 것을
autoboxing이라 부른다. 비슷하게 wrapper object가 primitive value로 unwrapped되는 것을 unboxing이라고 한다.

autoboxing을 통해서 wrapper object를 써야하는 자리에 primitive object를 사용하더라도 별다른 처리없이 사용할 수 있게 된다.
unboxing도 마찬가지로 primitive type을 원하는 곳에 wrapper type을 넘겨주더라도 자동으로 처리된다.
```java
Integer val = 3;
Integer val = Integer.valueOf(3);
```

맨 위의 구문은 내부적으로 아래의 구문으로 변환되어 수행되는 것과 같다.

하지만 loop와 같은 곳에서는 autoboxing/unboxing을 사용하는 것에 주의해야 한다.
-> 아마도 performance issue가 있어서 그런듯 싶다..?
