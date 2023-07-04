# DFS(Depth-First Search) - 깊이 우선 탐색

DFS는 트리를 탐색하는 방법 중 하나로, 넓이(폭)보다는 깊이를 우선시하는 탐색 방법 입니다.

탐색할 노드가 남지 않을 때까지 왼쪽 하위 트리 또는 오른쪽 하위 트리를 계속 탐색하는 것이 핵심 아이디어입니다.

깊이 우선 검색이 수행되는 방법에는 여러 가지가 있습니다.

- Inorder
- Preorder
- Postorder

DFS는 재귀를 이용하는 것이 가장 좋은 방법입니다. 스택을 사용하여 반복적으로 수행할 수도 있지만 훨씬 복잡합니다.

[4, 3, 6, 2, null, 5, 7] 의 트리가 있다고 가정하겠습니다.

## Inorder Traversal(중위 순회)

inorder 순회 방법은 왼쪽 노드를 우선시 합니다.

왼쪽 자식을 먼저 방문한 다음 부모 노드, 오른쪽 자식을 차례로 방문합니다.

`왼쪽 -> 부모 -> 오른쪽`

이 방식은 노드를 정렬된 순서대로 방문하게 됩니다.

```text
public void inorder(TreeNode root) {
    if (root == null) {
        return;
    }
    inorder(root.left);
    System.out.println(root.val);
    inorder(root.right);
}
```

이 탐색 방법은 [2, 3, 4, 5, 6, 7] 순으로 노드들을 탐색합니다.

> 노드가 정렬된 프린트되는 이유는 BST 속성 때문입니다. 노드의 왼쪽에 있는 모든 값이 더 작다는 것을 알기 때문에 가장 작은 노드인 가장 왼쪽 노드에 도달할 때까지 기본 케이스에 도달하지 않습니다.

- 출처 : https://neetcode.io/courses/dsa-for-beginners/19

## Preorder Traversal(전위 순회)

왼쪽보다 오른쪽에 우선순위를 두는 Preorder 탐색은 부모, 왼쪽 자식, 오른쪽 자식 순서로 방문합니다.

`부모 -> 왼쪽 -> 오른쪽`

```text
public void preorder(TreeNode root) {
    if (root == null) {
        return;
    }
    System.out.println(root.val);
    preorder(root.left);
    preorder(root.right);
}
```

이 탐색 방법은 [4, 3, 2, 6, 5, 7] 순으로 노드들을 탐색합니다.

- 출처 : https://neetcode.io/courses/dsa-for-beginners/19

## Postorder Traversal(후위 순회)

오른쪽보다 왼쪽에 우선순위를 두는 Postorder 탐색은 왼쪽 자식, 오른쪽 자식, 부모 순으로 방문합니다.

`왼쪽 -> 오른쪽 -> 부모`

이 탐색 방법은 [2, 3, 5, 7, 6, 4] 순으로 노드들을 탐색합니다.

- 출처 : https://neetcode.io/courses/dsa-for-beginners/19

### reference

- https://neetcode.io/courses/dsa-for-beginners/19
- https://mommoo.tistory.com/101
