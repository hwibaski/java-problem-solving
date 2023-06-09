# queue

큐는 FIFO(Fisrt In First Out)로 동작한다는 것을 제외하고서는 스택과 비슷합니다.

현실에서 비슷한 예로는 일반적인 줄서기 입니다. 줄을 가장 먼저 서서 가장 앞에 있는 사람에 줄에서 가장 먼저 제외됩니다.

소프트웨어 세계에서는 프린트 대기열 같은 것들이 있겠습니다.

## 큐의 구현

큐의 가장 일반적인 구현은 연결된 목록을 사용하는 것입니다.

큐는 아래의 두 가지 오퍼레이션을 지원합니다.

1. enqueue
2. dequeue

> 큐는 스택과 마찬가지로 추상 데이터 구조로 다양한 자료 구조로 구현될 수 있습니다.

### Enqueue(가장 뒤에 삽입)

Enqueue는 tail에 요소를 추가하는 것입니다. 링크드 리스트로 구현 시 요소들의 이동 또한 필요 없으므로 O(1)의 시간 복잡도를 가집니다.

![image](https://github.com/hwibaski/java-problem-solving/assets/85930725/f5e1c213-7506-4a76-87d7-71c17fd8f345)
출처 : https://neetcode.io/courses/dsa-for-beginners/7


### Dequeue(가장 앞에 요소 제거)

Dequeue는 가장 앞의 요소를 제거하고 이를 리턴하는 것입니다. 큐가 만약에 dynamic array로 구현되었다면 이 동작을 할 시 O(n)의 시간복잡도를 가질 것입니다.

하지만 링크드 리스트로 구현 시에는 O(1)의 시간 복잡도를 가집니다

![image](https://github.com/hwibaski/java-problem-solving/assets/85930725/35e75bb7-ecea-41bc-92ca-7176a063f110)
출처 : https://neetcode.io/courses/dsa-for-beginners/7

> 대기열의 변형인 양쪽 끝 대기열인 deque("데크"로 발음)라는 대기열도 있습니다. Deque를 사용하면 머리와 꼬리 모두에서 요소를 추가하고 제거할 수 있습니다

| 동작      | 시간 복잡도 | 특이사항                        |
|---------|--------|-----------------------------|
| dequeue | O(1)   | 삽입할 요소의 위치(참조)를 알고 있다는 가정하에 |
| enqueue | O(1)   | 삽입할 요소의 위치(참조)를 알고 있다는 가정하에 |

### reference

- https://neetcode.io/courses/dsa-for-beginners/7
