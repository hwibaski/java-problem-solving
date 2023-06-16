# Stack

스택은 요소들을 포함하는 데이터 구조로, 한쪽 끝(top, 스택의 상단이라고 함)에서만 요소를 추가하고 삭제할 수 있습니다.

스택은 책이 쌓여있는 모습이나 접시를 상상하면 이해하기 쉽습니다.

쌓여있는 접시에서 접시를 가져가려면 위에서부터 꺼내야하고, 접시를 쌓아올려야 접시 더미(스택)를 만들 수 있습니다.

스택은 선입선출(LIFO - Last In First Out) 방식으로 작동하는 동적 데이터 구조입니다. 스택은 보통 세 가지 연산을 지원합니다.

1. push
2. pop
3. peek

## push

```java
// using the pushback function from dynamic arrays to add to the stack
public void push(int n){
        stack.add(n);
}
```

push는 스택의 가장 위에 데이터를 추가하는 오퍼레이션입니다. 실제 동작은 동적 배열에 요소를 추가하는 것과 같으며 O(1)의 시간복잡도를 가집니다.

스택에서는 가장 위의 요소를 가리키는 포인터가 존재합니다.

![image](https://github.com/hwibaski/java-problem-solving/assets/85930725/e683dbd6-c5e1-4df0-9656-5b326ae90bad)
출처 : https://neetcode.io/courses/dsa-for-beginners/4

> 스택은 데이터 구조로서 추상적인 인터페이스일 뿐이며 구현 방식은 중요하지 않으며, 단지 끝에서 요소를 추가하고 제거할 수 있어야 한다는 특징이 있습니다.

> 스택은 요소를 삽입한 순서와 반대로 요소를 제거하기 때문에 문자열과 같이 문자의 연속인 시퀀스를 역순으로 처리하는 데 사용할 수 있습니다.

## pop

```java
public int pop(){
        return stack.remove(stack.size()-1);
}
```

pop은 스택의 맨 위에서 마지막 요소를 제거하는 동작입니다. 동적배열에서 마지막 요소를 제거하는 것과 같습니다.

![image](https://github.com/hwibaski/java-problem-solving/assets/85930725/e518aa44-9b82-439d-a58d-ce617fb83fa8)
출처 : https://neetcode.io/courses/dsa-for-beginners/4

> 대부분의 언어에서는 팝하기 전에 스택이 비어 있는지 확인하여 오류를 방지하는 것이 좋습니다.

## peek

```java
public int peek(){
        return stack.get(stack.size()-1);
        }
```

peek은 top 포인터가 가리키고 있는 요소를 리턴합니다. 즉, 스택의 가장 위에 있는 요소를 리턴합니다.

| 동작       | 시간 복잡도 | 특이사항            |
|----------|--------|-----------------|
| push     | O(1)   |                 |
| pop      | O(1)   | 스택이 비어있는지 확인 필요 |
| peek/top | O(1)   |                 |

### reference

- https://neetcode.io/courses/dsa-for-beginners/4
