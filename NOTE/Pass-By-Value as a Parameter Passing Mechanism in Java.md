#Pass-By-Value as a Parameter Passing Mechanism in Java
메서드에 argument를 전달하는 가장 유명한 두 가지 방법은 "pass by value"와 "pass by reference"가 있다.
프로그래밍 언어마다 이러한 내용을 다른 방식으로 적용하여 사용하는데, 자바에서는 모든 것을 "pass by value"로 처리한다.

1) Pass-by-Value
parameter가 pass-by-value로 전달되면 caller와 callee 는 복사된 형태의 서로 다른 변수가 된다.
따라서 어느 한 쪽의 변화가 다른 한쪽에 영향을 주지 않는다.
2) Pass-by-Reference
pass-by-reference로 전달되면 caller와 callee는 같은 객체를 이용하게 되는데, 다시 말해 변수가 메서드에 전달될 때
unique identifier가 메서드로 전달되므로 메서드 내부에서 해당 변수를 수정하게 되면 그 외에서 사용하는 변수 또한
동일한 영향을 받게 된다.

primitive variable은 실제 값을 저장하며, non-primitive는 실제 객체를 저장하고 있는 곳의 주소를 가리키는 reference variable을 저장하게 된다.
(그러나 실제 객체를 저장하고 있는 공간은 heap 영역임에 주의하자)
이 둘은 모두 stack memory에 저장되는데, 자바는 항상 pass-by-value로 전달되므로 스택 메모리에 있던 변수가
그대로 동일한 형태로 스택 메모리에 또 다시 생기게 되는데, non-primitive의 경우 reference 값이 스택 메모리에 있으므로
실제 객체가 복사되는 것이 아닌 reference 값이 복사되게 된다. 따라서 실제 객체는 하나지만 reference는 두 개가 되는 결과를 낳게 된다.
