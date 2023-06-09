# Binary Tree - 이진 트리

바이너리 트리는 노드와 포인터를 포함하는 또 다른 데이터 구조입니다.
링크드 리스트 또한 노드를 가지고 있습니다.
링크드 리스트에서는 노드들을 다음 포인터(next)와 이전 포인터(prev)를 사용해 직선으로 연결합니다.
이진 트리의 노드에도 최대 두 개의 포인터가 있지만, 이를 왼쪽 자식과 오른쪽 자식 포인터라고 부릅니다.
이진 트리의 첫 번째 노드를 루트 노드라고 합니다. 포인터를 직선이 아닌 아래쪽으로 그립니다.

노드의 값은 모든 데이터 유형이 될 수 있습니다. TreeNode 클래스는 다음과 같습니다.
링크드 리스트의 Node와 구현의 상당 부분이 유사하지만, 왼쪽 자식과 오른쪽 자식이 있다는 점만 다릅니다.

```java
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val) {
        this.val = val; 
        left = null;
        right = null; 
    }
}
```

노드에 자식이 없는 경우 단말 노드(leaf node)로 분류됩니다. 노드에 왼쪽 또는 오른쪽에 자식이 하나라도 있는 경우 비단말 노드(non-leaf node)로 분류됩니다.

링크된 리스트와 달리 이진 트리 노드 포인터는 한 방향만 가리킬 수 있습니다.
따라서 이진 트리에서는 순환(cycle)이 허용되지 않습니다.
수학적으로 말하면 이진 트리는 주기가 없는 방향이 없는 그래프입니다.
이 말은 무조건적으로 리프 노드가 존재하게 됨을 의미합니다.

## 속성

### 1. Root Node

루트 노드는 트리에서 가장 높은 노드이며 부모 노드가 없습니다. 루트 노드를 통해 트리의 모든 노드에 도달할 수 있습니다.

### 2. Leaf Node

리프 노드는 자식이 없는 노드입니다. 트리의 마지막 레벨에 있는 노드는 리프노드가 됩니다.
하지만 다른 레벨에서도 리프 노드는 존재할 수 있습니다.

![image](https://github.com/hwibaski/java-problem-solving/assets/85930725/40c8bdf1-a85e-4193-b5eb-2a1e569194ff)


출처 : https://neetcode.io/courses/dsa-for-beginners/16

### 3. Childeren

특정 노드의 left 포인터와 right 포인터로 이어지는 노드들이 특정 노드의 자식 노드가 됩니다.

![image](https://github.com/hwibaski/java-problem-solving/assets/85930725/b4d75c98-95c1-4b7b-9a43-67bca0a35086)


출처 : https://neetcode.io/courses/dsa-for-beginners/16

### 4. Height

이진 트리의 높이는 실생활에서 사물의 높이와 마찬가지로 루트 노드에서 가장 낮은 리프 노드까지 측정됩니다.

하나의 노드만 존재하는 트리의 경우, 자기 자신을 높이에 포함한다면 높이가 1이되고 그렇지 않다면 0이 됩니다.

때로는 노드 자체 대신 노드 사이에 있는 간선(edge) 수로 높이를 계산하기도 합니다.
이 방법을 사용하면 루트에서 가장 낮은 리프 노드까지의 경로에서 높이는 n-1이 되며, 여기서 n은 루트 노드에서 가장 낮은 리프 노드까지의 경로에 있는 노드의 수입니다.

> 간선의 개수는 모든 노드의 개수 - 1 (n - 1) 입니다.

### 5. Depth

이진 트리 노드의 깊이는 해당 노드가 루트 노드로 부터 얼마나 떨어져 있는가를 나타냅니다.

루트 노드의 깊이는 1입니다.

아래로 내려갈수록 깊이가 증가합니다.

특정 노드의 깊이는 자기 자신을 포함하여 자신보다 위에 있는 노드 수를 확인하여 측정합니다.

![image](https://github.com/hwibaski/java-problem-solving/assets/85930725/a1a833ae-7652-4e24-b6a7-2032ebf45e2d)


출처 : https://neetcode.io/courses/dsa-for-beginners/16

### 6. Ancestor

간선(edge)을 따라 루트 노드까지 가는 경로상에 있는 모든 노드들
즉, 4번의 조상 노드는 1번, 2번 입니다.

### 7. Descendent

자기 자신을 기준으로 아래쪽으로 연결되어 있는 모든 노드

![image](https://github.com/hwibaski/java-problem-solving/assets/85930725/71aa2a78-39d3-44c5-accf-d97f25b0ee37)


출처 : https://neetcode.io/courses/dsa-for-beginners/16
