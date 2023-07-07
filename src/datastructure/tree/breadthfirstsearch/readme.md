# # BFS(Breadth-First Search) - 너비 우선 탐색

## Concept

DFS는 트리의 깊이를 중심적으로 노드들을 탐색했습니다. 이름에서 알 수 있드이 BFS는 트리의 너비를 중심적으로 노드들을 탐색합니다.

조금 더 쉽게 이야기 하면 각 레벨의 노드들을 가로방향으로 탐색합니다.

일반적으로 BSF는 반복적으로(iteratively) 구현합니다. 재귀로도 구현할 수 있지만 훨씬 더 까다롭습니다.

BFS를 구현할 때는 큐라는 자료구조를 사용합니다. 조금 더 구체적으로 이야기하자면 deque (데크, 덱)를 사요합니다.

데크는 맨 앞의 요소와 맨 뒤의 요소를 O(1)의 시간복잡도로 제거할 수 있습니다.

[4, 3, 6, 2, null, 5, 7] 의 형태를 가진 트리를 BFS를 이용해서 탐색해보겠습니다.

우리의 목표는 현재 레벨의 모든 노드를 탐색하고, 그 다음 레벨의 노드를 탐색하는 것입니다.

```text
public void bfs(TreeNode root) { 
    // 데크 선언
    Deque<TreeNode> queue = new ArrayDeque<TreeNode>();
    // root가 널이 아니면
    if (root != null) {
        // 큐에 루트 노드를 추가
        queue.add(root);
    }   
    
    // level 변수는 BFS 구현에 영향은 없지만, 현재 어떤 레벨을 순회하는지 확인하는 용도이다 
    int level = 0;
    
    // 큐가 비어있지 않다면 (큐에 노드가 남아있다면)
    while(!queue.isEmpty()) {
        System.out.print("level " + level + ": ");
        // 큐의 사이즈 변수할당
        int levelLength = queue.size();
        // 큐의 사이즈만큼 반복문을 돈다.
        for (int i = 0; i < levelLength; i++) {
            // 큐에서 가장 첫번째 요소(가장 왼쪽의 요소를)를 꺼낸다.
            TreeNode curr = queue.removeFirst(); 
            // 출력한다.
            System.out.print(curr.val + " ");
            // 꺼낸 큐의 왼쪽 포인터가 널이 아니면, 즉 자식 노드가 있으면
            if(curr.left != null) {
                // 왼쪽 자식 노드를 큐에 추가한다.
                queue.add(curr.left);  
            }
            // 꺼낸 큐의 오른쪽 포인터가 널이 아니면, 즉 자식 노드가 있으면
            if(curr.right != null) {
                // 오른쪽 자식 노드를 큐에 추가한다.
                queue.add(curr.right);
            }  
        }
        
        level++;
        System.out.println();
    }
}
```

- 출처 : https://neetcode.io/courses/dsa-for-beginners/20
