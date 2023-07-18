# Heapify

이진 탐색 트리를 만들기 위해서는 O(n log n)의 시간복잡도가 소요됩니다.
힙을 이용하면 O(log n)의 시간 복잡도가 소요됩니다.
그러나 heapify는 O(n) 시간에 동일한 작업을 수행할 수 있습니다.

## 개념

우선 힙을 구축하기 전에 확인해야할 것은 구조적 특성과 순서적 특성을 만족시키는 것입니다.
완전 이진 트리인지, 모든 노드가 부모의 노드보다 작은지도 확인해야합니다.

```java
public void heapify(ArrayList<Integer> arr) {
    // 0번째 요소 가장 끝으로 이동
    arr.add(arr.get(0));

    heap = arr;
    // 힙의 가장 아래쪽 비단말 노드의 인덱스를 선택합니다. 
    int cur = (heap.size() - 1) / 2;
    while (cur > 0) {
        // Percolate Down
        int i = cur;
        // 왼쪽 자식이 힙의 크기를 벗어나지 않는 한 계속 반복하는 조건.
        // 이 조건은 현재 노드 i가 최소한 하나 이상의 자식을 가지고 있을 때까지 반복합니다.
        while (2 * i < heap.size()) {
            // 오른쪽 자식이 존재하고, 오른쪽 자식의 값이 왼쪽 자식보다 작고, 현재 노드의 값보다 오른쪽 자식의 값이 작은 경우:
            if (2 + i + 1 < heap.size() && heap.get(2 + i + 1) < heap.get(2 * i) && heap.get(i) > heap.get(2 * i + 1)) {
                // 오른쪽 자식과 현재 노드를 교환
                int tmp = heap.get(i);
                heap.set(i, heap.get(2 * i + 1));
                heap.set(2 * i + 1, tmp);
                // i를 오른쪽 자식의 인덱스로 업데이트
                i = 2 * i + 1;
            } else if (heap.get(i) > heap.get(2 * i)) {
                // 그렇지 않고, 왼쪽 자식의 값이 현재 노드의 값보다 작은 경우:
                int tmp = heap.get(i);
                heap.set(i, heap.get(2 * i));
                heap.set(2 * i, tmp);
                // i를 왼쪽 자식의 인덱스로 업데이트
                i = 2 * i;
            } else {
                break;
            }
        }
        // cur을 --함으로써 다음 비단말 노드의 인덱스 선택
        cur--;
    }
    return;
}
```

![image](https://github.com/hwibaski/java-problem-solving/assets/85930725/178f4e07-d844-47eb-bda4-6ca8f47e3d0b)


- 출처 : https://neetcode.io/courses/dsa-for-beginners/25

## 시간 복잡도

이진 트리에서 노드의 개수가 n개인 경우, 대략 n/2 개의 리프 노드가 있습니다.
이 정보를 통해 각 노드가 얼마나 많은 level에서 Percolate Down을 수행해야 하는지와 각 레벨에서 heapify()가 수행하는 작업량을 알 수 있습니다.
heapify()는 마지막 레벨에서 수행되지 않습니다.
2번째 레벨의 노드들은 한 레벨 아래로 Percolate Down을 수행해야 하며, 1번째 레벨의 노드들은 두 개의 레벨 아래로 Percolate Down을 수행해야 합니다.
루트 노드는 모든 레벨을 거쳐 Percolate Down을 수행해야 합니다.
따라서 노드의 개수는 절반씩 감소하더라도 Percolate Down이 수행해야 하는 수준의 개수는 증가합니다.
이를 모두 합산하면 간단한 수학적 합이 형성되는데, 이는 O(n)으로 단순화됩니다.
하지만 이 내용은 다루지 않을 것입니다. heapify()의 시간 복잡도를 증명해야 할 가능성은 매우 낮으므로, O(n)에 해당한다는 것을 알고 있으면 충분합니다.

만약 왜 대략 n/2개의 리프 노드가 있는지에 대한 증명에 관심이
있다면, [Virginia Tech](https://courses.cs.vt.edu/~cs3114/Fall09/wmcquain/Notes/T03a.BinaryTreeTheorems.pdf)의 다음 5개의 슬라이드를
참고하시면 유용할 것입니다.

## reference

- https://courses.cs.vt.edu/~cs3114/Fall09/wmcquain/Notes/T03a.BinaryTreeTheorems.pdf
- https://neetcode.io/courses/dsa-for-beginners/25
