# Doubly Linked Lists

더블리 링크드 리스트는 싱글리 링크드 리스트의 변형입니다. 마찬가지로 ListNode를 가지고 있고 ListNode는 싱글리 링크드 리스트에서와 다르게 prev라는 속성을 하나 더 가지고 있습니다.

prev 속성은 이전의 요소를 가리키는 속성입니다.

prev 속성이 null인 ListNode가 head가 됩니다.

1. value
    - ListNode가 가지고 있는 값
2. next
    - 다음 요소를 가리키는 포인터 (참조값, reference)
3. prev
    - 이전 요소를 가리키느 포인터

## 더블리 링크드 리스트의 동작들

### 요소 추가

더블리 링크드 리스트도 싱글리 링크드 리스트와 마찬가지로 어느 위치에 요소를 추가하던 O(1)의 시간 복잡도를 가집니다. 링크드 리스트의 요소들은 포인터로 연결되어 있기 때문에 포인터만 변경해주면 됩니다.
다만 prev라는 속성이 있으므로 적절한 코드를 추가해줘야합니다.

```java
// singly linked list
tail.next=ListNode4;

// doubly linked list
        tail.next=ListNode4;
        ListNode4.prev=tail;
        tail=tail.next;
```

### 요소 삭제

싱글리 링크드 리스트와 마찬가지로 O(1)의 시간복잡도를 가지게 됩니다.

```java
// singly linked list
head.next=head.next.next;

// doubly linked list
        ListNode2=tail.prev;
        ListNode2.next=null;
        tail=ListNode2;
```

| 동작 | 시간 복잡도 | 특이사항                        |
|----|--------|-----------------------------|
| 접근 | O(n)   |                             |
| 탐색 | O(n)   |                             |
| 삽입 | O(1)   | 삽입할 요소의 위치(참조)를 알고 있다는 가정하에 |
| 삭제 | O(1)   | 삽입할 요소의 위치(참조)를 알고 있다는 가정하에 |

### reference

- https://neetcode.io/courses/dsa-for-beginners/6
