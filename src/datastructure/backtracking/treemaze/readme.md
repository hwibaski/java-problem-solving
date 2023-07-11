# Backtracking

해를 찾아가는 도중, 지금의 경로가 해가 될 것 같지 않으면 그 경로를 더이상 가지 않고 되돌아갑니다.

즉, 코딩에서는 반복문의 횟수까지 줄일 수 있으므로 효율적입니다.

이를 가지치기라고 하는데, 불필요한 부분을 쳐내고 최대한 올바른 쪽으로 간다는 의미입니다.

일반적으로, 불필요한 경로를 조기에 차단할 수 있게 되어 경우의 수가 줄어들지만, 만약 N!의 경우의 수를 가진 문제에서 최악의 경우에는 여전히 지수함수 시간을 필요로 하므로 처리가 불가능 할 수도 있습니다.
가지치기를 얼마나 잘하느냐에 따라 효율성이 결정되게 됩니다.

정리하자면, 백트래킹은 모든 가능한 경우의 수 중에서 특정한 조건을 만족하는 경우만 살펴보는 것입니다.

즉 답이 될 만한지 판단하고 그렇지 않으면 그 부분까지 탐색하는 것을 하지 않고 가지치기 하는 것을 백트래킹이라고 생각하면 됩니다.
주로 문제 풀이에서는 DFS 등으로 모든 경우의 수를 탐색하는 과정에서, 조건문 등을 걸어 답이 절대로 될 수 없는 상황을 정의하고, 그러한 상황일 경우에는 탐색을 중지시킨 뒤 그 이전으로 돌아가서 다시 다른 경우를
탐색하게끔 구현할 수 있습니다.

- 출처 : https://chanhuiseok.github.io/posts/algo-23/

## 예시

우리는 아래의 문제를 해결해야합니다.

> 트리의 루트에서 리프 노드까지 0이 포함되지 않은 경로가 존재하는지 판별하세요.

이 문제는 기본적으로 루트 노드에서 0의 값 없이 리프 노드로 이동할 수 있는지 묻는 것입니다. 경로가 존재하면 참을 반환하고 존재하지 않으면 거짓을 반환합니다.

가장 먼저 떠오르는 것은 깊이 우선 검색을 사용하는 것입니다. 우리의 제약 조건은 경로에 값이 0인 노드가 없어야 합니다.
또한 노드가 비어 있으면 유효한 경로도 존재할 수 없다는 것도 알고 있습니다.
마지막으로, 리프 노드에 도달했는데 false를 리턴하지 않았다면 루트에서 리프까지 존재하는 경로가 있다는 의미이므로 true를 리턴하면 됩니다.

트리가 [4,0,1,null,7,2,0]이라고 가정할 때 유효한 경로는 그림과 같이 다음과 같습니다. 경로에 0이 포함되어 있으면 유효하지 않은 경로입니다.

```text
public class TreeNode {

    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int val) {
        this.val = val;
        this.left= null;
        this.right = null;
    }
}

public boolean canReachLeaf(TreeNode root) {
    // root가 null 이거나 root의 값이 0이면 false 리턴
    if (root == null || root.val == 0) {
        return false;
    } 
    
    // root의 양쪽 노드 모두 없으면 true 리턴 
    if (root.left == null && root.right == null) {
        return true;
    }
    
    // 재귀로 root의 왼쪽 노드들 판별
    if (canReachLeaf(root.left)) {
        return true;
    }
    
    // 재귀로 root의 오른쪽 노드들 판별
    if (canReachLeaf(root.right)) {
        return true;
    }
    return false;
}
```

- 출처 : https://neetcode.io/courses/dsa-for-beginners/22

문제를 조금 변경해보겠습니다.

> 트리의 루트에서 리프 노드까지 0이 포함되지 않은 경로를 구하세요.

주어진 트리는 [4,0,1,null,7,3,2,null,null,null,0] 입니다.

아래의 과정은 정확하게 코드의 흐름과 일치하지는 않지만 대략적인 흐름을 보여줍니다.

1. 우리는 먼저 리스트에 root 노드를 추가합니다.
2. root 노드의 왼쪽 자식 노드를 확인합니다.
3. 0이므로 유효하지 않습니다.
4. root 노드의 오른쪽 자식 노드를 확인합니다.
5. 1이므로 유효합니다.
6. 리스트에 오른쪽 자식 노드를 추가합니다.
7. 노드(1, root의 오른쪽 자식)의 왼쪽 자식을 확인합니다.
8. 값이 3이므로 유효합니다.
9. 리스트에 노드(3)을 추가합니다.
10. 노드(3)의 왼쪽 자식을 확인합니다.
11. null이므로 유효하지 않습니다.
12. 노드(3)의 오른쪽 자식을 확인합니다.
13. 0이므로 유효하지 않습니다.
14. 노드(3)은 list에서 제거됩니다.
15. 노드(1)의 오른쪽 자식을 확인합니다.
16. 값이 2이므로 유효합니다.
17. 리스트에 노드(2)를 추가합니다.
18. 노드(2)의 왼쪽 자식과 오른쪽 자식이 모두 null이면 true를 리턴합니다.

- 출처 : https://neetcode.io/courses/dsa-for-beginners/22

```text
public boolean leafPath(TreeNode root, ArrayList<Integer> path) {
    if (root == null || root.val == 0) {
        return false;
    }
    path.add(root.val);

    if (root.left == null && root.right == null) {
        return true;
    }
    if (leafPath(root.left, path)) {
        return true;
    }
    if (leafPath(root.right, path)) {
        return true;
    }
    path.remove(path.size() - 1);
    return false;
}
```

## 시간복잡도

우리는 모든 노드를 방문하고 탐색해야 합니다. 따라서 트리의 노드 개수인 n에 따라 O(n)의 시간복잡도가 소요됩니다.

## reference

- https://neetcode.io/courses/dsa-for-beginners/22
