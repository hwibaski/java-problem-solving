# Singly Linked Lists

링크드 리스트는 요소를 정렬된 순서로 저장한다는 점에서 배열과 유사하지만 차이점이 있습니다.

링크드 리스트는 ListNode(이름은 크게 중요하지 않음)라는 객체로 이루어져있고, ListNode는 value와 next라는 속성을 가지고 있습니다.

1. value
    - ListNode가 가지고 있는 값
2. next
    - 다음 요소를 가리키는 포인터 (참조값, reference)

## 링크드 리스트 만들기

링크드 리스트는 ListNode의 연결로 이루어져 있습니다. ListNode는 아래와 같이 생겼습니다.

```java
public class ListNode {
    int val;
    ListNode next;

    public ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}
```

> low level의 관점에서 우리는 메모리에 어느 지점에 데이터를 저장할 지 결정할 수 없습니다. 따라서 개별적으로 초기화되는 객체들은 메모리 내에서 임의의 위치에 위치합니다.

우리는 아래와 같은 방법으로 이전의 노드가 다음 노드를 가리키게 할 수 있습니다. 다음 요소가 없다면 null로 초기화하면 됩니다.
next의 값이 null인 노드는 다음 노드가 없음을 나타내므로 링크드 리스트에서 마지막 요소가 됩니다.

```java
ListNode1.next=ListNode2;
```

```java
ListNode1.next=ListNode2;
ListNode2.next=ListNode3;
ListNode3.next=null;
```

![image](https://github.com/hwibaski/java-problem-solving/assets/85930725/dfc3059c-a18a-4f67-9995-80931a48773b)
출처 : https://neetcode.io/courses/dsa-for-beginners/5


## 탐색

링크드 리스트를 탐색하기 위해서는 여러가지 구현이 있지만 간단한 while문으로 탐색이 가능합니다.

```java
ListNode cur=ListNode1;
while(cur!=null){
    cur=cur.next;
}
```

![image](https://github.com/hwibaski/java-problem-solving/assets/85930725/28d48cb2-17f0-4251-b6f7-01a2a5622ab3)
출처 : https://neetcode.io/courses/dsa-for-beginners/5


## 순환 링크드 리스트 (Circular Linked List)

링크드 리스트의 가장 마지막 요소가 null 대신 가장 첫번째 요소를 가리키게 되면 탐색 시 무한 루프가 발생하게 되고 적절한 조치를 하지 않으면 프로그램이 크래쉬될 것입니다.

![image](https://github.com/hwibaski/java-problem-solving/assets/85930725/33322ca5-02d3-48cb-9105-280adc2a49d3)
출처 : https://neetcode.io/courses/dsa-for-beginners/5

## 링크드 리스트의 동작들

링크드 리스트는 head와 tail이라는 포인터를 가지고 있습니다. head 포인터는 링크드 리스트의 가장 첫번째 요소를 가리키고, tail 포인터는 링크드 리스트에서 가장 마자믹 요소를 가리키고 있습니다.
만약에 링크드 리스트의 요소가 하나밖에 없다면 head와 tail 포인터 모두 그 요소를 가리키고 있습니다.

### 요소 추가

링크드 링스트의 큰 장점 중 하나는 어느 위치에 요소를 추가하던 O(1)의 시간 복잡도를 가진다는 점입니다. 링크드 리스트의 요소들은 포인터로 연결되어 있기 때문에 포인터만 변경해주면 됩니다.
배열에서 그러했던 것처럼 중간에 요소 삽입 시 이후의 요소들을 하나씩 밀어주지 않아도 된다는 뜻입니다.

![image](https://github.com/hwibaski/java-problem-solving/assets/85930725/9d05f484-f3ba-47ff-88e6-3e1db66a84c0)
출처 : https://neetcode.io/courses/dsa-for-beginners/5
```java
tail.next = ListNode4;
```
![image](https://github.com/hwibaski/java-problem-solving/assets/85930725/b33c8dba-54a6-4b2a-94ce-f61bd00a3883)
출처 : https://neetcode.io/courses/dsa-for-beginners/5

```java
tail = ListNode4;
```
![image](https://github.com/hwibaski/java-problem-solving/assets/85930725/4e117f68-fc22-40c1-a2fe-8e2fb2f076da)
출처 : https://neetcode.io/courses/dsa-for-beginners/5


> 순수하게 요소를 추가하는 동작에만 O(1)이고 그 요소를 찾는 데는 O(n)이 소요된다는 것을 잊으면 안됩니다! 링크드 리스트는 인덱스가 없으므로 해당 요소에 바로 접근할 수 없음을 유의해야합니다.

### 요소 삭제
![image](https://github.com/hwibaski/java-problem-solving/assets/85930725/419605ea-4654-4eff-b7a7-26b5b09f6928)
출처 : https://neetcode.io/courses/dsa-for-beginners/5


```java
head.next=head.next.next;
```
![image](https://github.com/hwibaski/java-problem-solving/assets/85930725/ee822b74-6db2-45a3-a48d-bbca41a0082c)
출처 : https://neetcode.io/courses/dsa-for-beginners/5

![image](https://github.com/hwibaski/java-problem-solving/assets/85930725/81a13c02-99cc-4994-9912-14e88a773d8f)
출처 : https://neetcode.io/courses/dsa-for-beginners/5



삭제도 삽입과 마찬가지로 포인터들의 변경으로 간단하게 구현이 가능하고 이 역시 요소들을 하나하나 재배치하지 않아도 되므로 O(1)의 시간복잡도를 가지게 됩니다.

| 동작 | 시간 복잡도 | 특이사항                        |
|----|--------|-----------------------------|
| 접근 | O(n)   |                             |
| 탐색 | O(n)   |                             |
| 삽입 | O(1)   | 삽입할 요소의 위치(참조)를 알고 있다는 가정하에 |
| 삭제 | O(1)   | 삽입할 요소의 위치(참조)를 알고 있다는 가정하에 |

### reference

- https://neetcode.io/courses/dsa-for-beginners/5
