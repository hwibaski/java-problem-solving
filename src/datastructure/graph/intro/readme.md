# Introduction to Graphs

그래프는 노드와 이를 서로 연결하는 포인터로 구성된 추상적인 데이터 구조입니다.

## 그래프 용어

그래프에서 노드들을 정점들(vertices)이라고 하고 이러한 노드를 연결하는 포인터를 간선(edge)라고 합니다.
그래프에서는 노드를 배치하는 위치와 노드와 노드를 연결하는 에지에는 제한이 없습니다.

노드가 어떤 에지로도 연결되지 않은 경우에도 여전히 그래프, 즉 널 그래프로 간주될 수 있습니다.

간선의 개수는 E, 주어진 노드의 개수를 V라고 했을 때, `E <= V^2`의 관계가 성립됩니다.
즉 총 간선의 개수는 총 노드의 개수의 제곱보다 작거나 같습니다.

노드를 연결하는 간선에 방향이 있을 경우 이를 방향성 그래프 (directed graph)라고 합니다.
간선에 방향이 없을 경우 방향이 없는 그래프(undirected graph)라고 합니다.
트리와 링크드 리스트는 directed graph입니다.
left_child, right_child, prev, next 포인터들이 특정 방향으로 연결되어 있기 때문입니다.

![image](https://github.com/hwibaski/java-problem-solving/assets/85930725/f46f0622-f0c5-4ce7-b3ac-cdcd4fb22d1c)

- 출처 : https://neetcode.io/courses/dsa-for-beginners/28

## 그래프를 표현하는 방법들

1. 행렬 (Matrix)
2. 인접 행렬 (Adjacency Matrix)
3. 인접 리스트  (Adjacency List)

### 행렬

행렬은 행과 열이 있는 2차원 배열이며, 그래프는 행렬을 사용하여 표현할 수 있습니다.
아래 코드에서 쉼표로 구분된 각 배열은 각 행을 나타냅니다. 여기에는 4개의 행과 4개의 열이 있습니다.

```java
// Matrix (2D Grid)
int[][] grid = {{0, 0, 0, 0},
                {1, 1, 0, 0},
                {0, 0, 0, 1},
                {0, 1, 0, 0}};
```

이 행렬을 어떻게 그래프로 표현할 수 있을까요?
그래프는 여러 방법으로 구현될 수 있는 추상적인 데이터 구조입니다.
그리드에 있는 정점이 모두 0이라고 가정해 보겠습니다.
그래프를 가로지르기 위해 위, 아래, 왼쪽, 오른쪽으로 이동할 수 있습니다.
가장자리를 사용하여 0을 서로 연결하면 결국 연결된 구성 요소인 연결된 0이 많아지고 이는 그래프를 나타냅니다.

![image](https://github.com/hwibaski/java-problem-solving/assets/85930725/ecbd3a61-b31f-46c9-873e-431a82d2e658)

- 출처 : https://neetcode.io/courses/dsa-for-beginners/28

## 인접 행렬

```java
// Adjacency matrix
int[][] adjMatrix = {{0, 0, 0, 0},
                     {1, 1, 0, 0},
                     {0, 0, 0, 1},
                     {0, 1, 0, 0}};
```

인정 행렬으로 구현된 그래프에서는 다음과 같은 규칙이 있습니다.
adjMatrix[v1][v2]일 때, v1에서 v2로 가는 간선이 있으면 1이고 아니면 0입니다.
간선에 가중치가 있는 그래프라면 1 대신 가중치를 넣어주는 방식으로 구현할 수 있습니다.

```text
// v1 에서 v2로 가는 간선은 이어져 있다.
adjMatrix[v1][v2] = 1;

// v2에서 v1으로 가는 간선은 이어져 있다.
adjMatrix[v2][v1] = 1;

// v1 에서 v2로 가는 간선은 이어져 있지 않다..
adjMatrix[v1][v2] = 0;

// v2 에서 v1로 가는 간선은 이어져 있지 않다..
adjMatrix[v2][v1] = 0;
```

인접 행렬의 주요한 문제점은 메모리를 많이 사용한다는 점입니다.
이 문제의 문제점은 이것이 매우 큰 메모리를 사용한다는 것입니다.
이는 정사각 행렬이기 때문에 시간 복잡도는 O(V^2)입니다.
여기서 V는 정점(노드)의 수를 나타냅니다.

## 인접 리스트

일반적으로 그래프를 표현하는 가장 일반적인 방법입니다. 이 또한 2차원 배열입니다.
여기서 편리한 점은 그래프노드라는 클래스를 사용해 선언할 수 있고, 이 클래스에는 이웃이라는 리스트 필드가 포함되어 있어 주어진 정점의 모든 이웃에 액세스할 수 있다는 것입니다.

```java
public class GraphNode {
    int val;
    List<GraphNode> neighbors;
    
    public GraphNode(int val) {
        this.val = val;
        this.neighbors = new ArrayList<GraphNode>();
    }
}
```

이렇게 하면 연결된 노드만 신경 쓰기 때문에 공간 효율성이 높아집니다.

![image](https://github.com/hwibaski/java-problem-solving/assets/85930725/827ee2b0-108e-49b8-82b3-ae126b2cf4f8)


- 출처 : https://neetcode.io/courses/dsa-for-beginners/28

