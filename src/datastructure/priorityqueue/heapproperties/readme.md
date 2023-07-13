# Heap Properties - 힙의 특성들

힙(Heap)은 우선순위 큐를 위해 고안된 완전이진트리 형태의 자료구조입니다..
여러 개의 값 중 최댓값 또는 최솟값을 찾아내는 연산이 빠릅니다.

큐는 먼저 들어오는 데이터가 먼저 나가는 FIFO(First In First Out) 형식의 자료구조입니다.
하지만 우선순위 큐(Priority Queue)는 먼저 들어오는 데이터가 아니라, 우선순위가 높은 데이터가 먼저 나가는 형태의 자료구조입니다.

## 힙의 두 가지 형태

1. Min Heap (최소 힙)
    - 최소 힙은 루트 노드에서 가장 작은 값을 가지며 삭제할 때 가장 작은 값이 가장 높은 우선순위를 갖습니다.
    - 부모 노드의 키 값이 자식 노드보다 작거나 같은 완전이진트리입니다.
2. Max Heap (최대 힙)
    - 최대 힙은 루트 노드에서 가장 큰 값을 가지며 삭제할 때 가장 큰 값이 가장 높은 우선순위를 갖습니다.
    - 부모 노드의 키 값이 자식 노드보다 크거나 같은 완전이진트리입니다.

이 장에서는 최소 힙에 초점을 맞추겠지만, 최소값 대신 최대값에 우선순위를 부여한다는 점을 제외하면 구현은 완전히 동일합니다.

## 힙의 특성들

일반적인 이진 트리가 힙이 되기 위해서는 다음 속성을 충족해야 합니다

1. Structure Property

바이너리 힙은 최하위 레벨 노드를 제외하고 트리의 모든 레벨이 완전히 채워지는 완전 이진 트리입니다.

2. Order Property

최소 힙의 순서에 관한 특성은 모든 자손 노드가 조상보다 크거냐 같아야 한다는 것입니다.

다시 말해 특정 노드 y를 조상으로 하는 자손 노드들은 모두 y보다 크거나 같아야 합니다.

최대힙은 그 반대로 모든 자손 노드가 조상 노드보다 작거나 같아야 합니다.

- 출처 : https://neetcode.io/courses/dsa-for-beginners/23

## 구현

이진 힙은 트리 데이터 구조를 사용하여 그려지지만 내부적으로는 배열을 사용하여 구현됩니다.

`[14,19,16,21,26,19,68,65,30,null,null,null,null,null,null]`

1. 우리는 주어진 노드 n개 보다 하나 큰 n + 1 사이즈의 배열을 만듭니다.
2. BFS와 비슷한 방법으로 루트 노드부터 아래로 값을 채워나갑니다.
3. 단, 배열의 0번째가 아닌 1번째부터 채워나갑니다.

- 출처 : https://neetcode.io/courses/dsa-for-beginners/23

인덱스 1부터 배열을 채우기 시작하는 이유는 노드의 왼쪽 자식, 오른쪽 자식 또는 부모가 있는 인덱스를 파악하는 데 도움이 되기 때문입니다.
바이너리 힙은 완전한 바이너리 트리이므로 포인터를 위한 공간이 필요하지 않습니다.
대신, 노드의 왼쪽 자식, 오른쪽 자식 및 부모는 다음 공식을 사용하여 계산할 수 있습니다. 여기서 i는 주어진 노드의 인덱스입니다.

leftChild = 2 * i
rightChild = 2 * i + 1
parent = i / 2

- 출처 : https://neetcode.io/courses/dsa-for-beginners/23

그림에서 19의 인덱스i는 2 입니다.
19의 부모 인덱스는 i / 2, 즉 1이고, 그 자리에는 14가 있습니다.
19의 양쪽 자식을 구해보겠습니다.
우선 왼쪽 자식은 2 * i, 즉 4 이고, 그 자리에는 21이 있습니다. 또한 오른쪽 자식은 2 * i + 1이고, 그 값은 5이며 그 자리에는 26이 있습니다.

```text
public class Heap {
    
    List<Integer> heap;

    public Heap() {
        heap = new ArrayList<Integer>();
        heap.add(0);
    }
}
```

### reference

- https://neetcode.io/courses/dsa-for-beginners/23
- https://velog.io/@emplam27/%EC%9E%90%EB%A3%8C%EA%B5%AC%EC%A1%B0-%EA%B7%B8%EB%A6%BC%EC%9C%BC%EB%A1%9C-%EC%95%8C%EC%95%84%EB%B3%B4%EB%8A%94-%ED%9E%99Heap
- https://codingdog.tistory.com/entry/%EC%99%84%EC%A0%84%EC%9D%B4%EC%A7%84%ED%8A%B8%EB%A6%AC-vs-%ED%8F%AC%ED%99%94%EC%9D%B4%EC%A7%84%ED%8A%B8%EB%A6%AC-%EC%9D%B4-%EB%91%98%EC%97%90-%EB%8C%80%ED%95%B4-%EC%95%8C%EC%95%84%EB%B4%85%EC%8B%9C%EB%8B%A4
