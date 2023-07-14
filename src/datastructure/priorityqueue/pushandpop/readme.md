# Heaps Push and Pop

## Push

`[14,19,16,21,26,19,68,65,30,null,null,null,null,null,null]`

위의 힙으로 예시를 들겠습니다.

위의 힙에 17을 푸시하고 싶다고 가정하갰습니다. 힙의 구조적 특성과, 순서를 유지하면서 17을 푸시해야 합니다.

위의 배열에서 10번째 index 즉, 30 다음에 17을 놓는다고 가정하겠습니다.

하지만 그 자리에 17을 놓을 경우 최소힙의 속성을 위반할 수 있습니다.

> 최소힙의 속성 : 부모 노드의 값이 자식 노드보다 작거나 같은 완전이진트리입니다.

따라서 17의 올바른 자리르 찾을 때까지 일련의 과정을 수행해야 합니다.

1. 17의 부모인 26보다 17이 작기 때문에 26과 스왑합니다.
2. 스왑 후 다시 부모 노드를 확인합니다.
3. 부모 노드인 19 역시 17보다 크기 때문에 스왑합니다.

```java
public void push(int val) {
    heap.add(val);
    // i = 전체 힙배열 에서 마지막 자리
    int i = heap.size() - 1;

    // Percolate up
    // 인덱스가 1보다는 크고 push하고자 하는 값이 그 부모보다 작을 경우
    while (i > 1 && heap.get(i) < heap.get(i / 2)) {
        // 추가하고자 하는 값 임시로 저장
        int tmp = heap.get(i);
        // swap
        heap.set(i, heap.get(i / 2));
        heap.set(i / 2, tmp);
        // 인덱스를 부모 인덱스로 변경
        i = i / 2;
    }
}
```

![image](https://github.com/hwibaski/java-problem-solving/assets/85930725/5f3fc3d6-f467-428b-90c6-a4ab3d749716)

- 출처 : https://neetcode.io/courses/dsa-for-beginners/24

## pop

pop은 push보다 상대적으로 복잡합니다.

root 노드인 14를 pop한다고 가정해보겠습니다.

간단한 방법으로는 root 노드를 제거한 후 양쪽 노드에서 작은 값을 root 노드의 자리에 위치하도록 할 수 있습니다.

하지만 이 경우에는 힙의 구조적 특성이 깨집니다.

마지막 레벨이 아닌 레벨에서 모든 노드가 채워진다는 규칙이 깨져버립니다.

![image](https://github.com/hwibaski/java-problem-solving/assets/85930725/49903bad-0b47-433f-b73f-445aa665af14)


> 구조적 특성 : 바이너리 힙은 최하위 레벨 노드를 제외하고 트리의 모든 레벨이 완전히 채워지는 완전 이진 트리입니다.

올바른 방법은 마지막 레벨의 가장 오른쪽 노드(30)를 가져와 루트 노드(14)로 교체하는 것입니다.

![image](https://github.com/hwibaski/java-problem-solving/assets/85930725/fed0676a-98c1-4d65-a9f2-1df628447c45)


이제 구조적 특성을 유지할 수 있습니다.

하지만 순서 특성을 어겼습니다. 30은 자식 노드인 19, 16보다 큽니다.

16, 19 노드 중 더 작은 노드와 30을 스왑합니다.

![image](https://github.com/hwibaski/java-problem-solving/assets/85930725/b9320955-925d-4027-a873-c4e63bcfceca)



스왑한 뒤의 30은 아직도 순서적 특성을 위반하고 있습니다. 자식 노드인 19보다 더 크죠.

19와 30을 스왑해줍니다.

![image](https://github.com/hwibaski/java-problem-solving/assets/85930725/fc7681ab-c796-4472-956d-938370b826ed)


```java
public int pop() {
    // 힙의 사이즈가 1이면 pop할 것이 없으므로 null 리턴, 0번째 인덱스를 채우기 위한 더미데이터가 존재하기 때문에 사이즈 1임
    if (heap.size() == 1) {
        //return null;
    }
    
    // 힙의 사이즈가 2이면 하나의 원소밖에 없다는 뜻이므로 해당 요소만 제거해준다.
    if (heap.size() == 2) {
        return heap.remove(heap.size() - 1); // equivalent to heap.remove(1)
    }


    // 루트 노드 선택
    int res = heap.get(1);
    // 가장 마지막 노드(마지막 레벨의 가장 우측 노드)를 제거함과 동시에 루트 노드에 할당
    heap.set(1, heap.remove(heap.size() - 1));
    // 루트 노드 포인터 지정
    int i = 1;
    // 재배치
    // i * 2는 왼쪽 노드가 있는지 확인하기 위함
    while(2 * i < heap.size()) {
        // 2 * i + 1 : 오른쪽 노드 인덱스
        // 2 * i + 1 < heap.size() : 오른쪽 노드가 존재하는지 확인
        
        // heap.get(오른쪽 노드 index) < heap.get(왼쪽 노드 index) : 오른쪽 노드가 왼쪽 노드보다 작다면
        
        // heap.get(자기 자신) < heap.get(오른쪽 노드 index) : 자기 자신이 오른쪽 노드보다 크다면
        
        // 루트 노드, 왼쪽 노드, 오른쪽 노드 비교 후 오른쪽 노드가 가장 작은 값이라면  
        if (2*i + 1 < heap.size() &&
        heap.get(2 * i + 1) < heap.get(2 * i) &&
        heap.get(i) > heap.get(2 * i + 1)) {
            // 오른쪽 노드와 자기 자신 스왑
            int tmp = heap.get(i);
            heap.set(i, heap.get(2 * i + 1));
            heap.set(2 * i + 1, tmp);
            
            // i 값을 교체한 오른쪽 노드로 재할당
            i = 2 * i + 1;
        } else if (heap.get(i) > heap.get(2 * i)) { // 자기 자신이 오른쪽 노드보다는 작지만 왼쪽 노드보다는 클 경우
            // 왼쪽 노드와 자기 자신을 스왑
            int tmp = heap.get(i);
            heap.set(i, heap.get(2 * i));
            heap.set(2 * i, tmp);
            
            // i 값을 교체한 왼쪽 노드로 재할당
            i = 2 * i;
        } else { // 제자리에 위치했을 경우
            break;
        }
    }
    return res;
}
```
![image](https://github.com/hwibaski/java-problem-solving/assets/85930725/83c890d7-ad9e-423c-937e-f414bb5375ff)

- 출처 : https://neetcode.io/courses/dsa-for-beginners/24

![image](https://github.com/hwibaski/java-problem-solving/assets/85930725/9b2aaaec-a61b-4b3d-b0c2-c783a4b6d474)


