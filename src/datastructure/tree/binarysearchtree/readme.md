# Binary Search Tree(BST) - 이진 탐색 트리

이진 탐색 트리(Binary Search Tree)는 이진 트리(Binary Tree)의 한 종류로서 특성이 있습니다.

이 특성은 모든 왼쪽 자식 노드는 부모 노드보다 작아야 하고, 모든 오른쪽 자식 노드는 부모 노드보다 커야 한다는 것을 알려줍니다.

BST는 중복을 허용하지 않습니다.

또한 하나의 이진 탐색 트리 내의 서브 트리들도 이진 탐색 트리 입니다.

## 이진 탐색 트리의 사용 이유

여기서 의문은 sorted array가 있으면 굳이 BST가 필요한가? 라는 것입니다.

BST도 그렇습니다만 우리는 정렬된 배열에서 O(logn)의 시간 복잡도를 가지고 특정 값을 탐색할 수 있습니다.

하지만 BST는 값을 삽입하거나 삭제하려고 할 때 장점이 있습니다.

BST에서는 삽입과 삭제가 O(logn)의 시간 복잡도를 가집니다. 하지만 배열에서는 O(n)의 시간 복잡도를 가집니다.

이번 장에서는 탐색에 대해서만 집중적으로 알아보도록 하겠습니다.

## BST Search

트리는 재귀를 사용하여 탐색하는 것이 가장 좋습니다.

반복적으로(iterably) 탐색할 수도 있지만 스택을 유지해야 하므로 훨씬 더 복잡합니다.

재귀를 사용하려면 앞서 설명한 것처럼 베이스 케이스와 함수 호출 자체가 필요합니다.

[2, 1, 3, null, null, 4] 로 이루어진 트리에서 3을 찾는 탐색을 예로 들어보겠습니다.

이진 탐색에서는 현재 요소가 목표보다 크면 왼쪽으로 이동하고, 현재 요소가 목표보다 작으면 오른쪽으로 이동했습니다.

여기에서도 비슷한 접근 방식을 사용할 수 있습니다.

기본적으로 BST는 왼쪽에 있는 모든 노드가 현재 노드보다 작고 오른쪽에 있는 모든 노드가 현재 노드보다 크다는 것을 알고 있습니다.

그렇기 때문에 현재 노드가 목표인 3보다 작으면 오른쪽으로 이동하고 현재 노드가 목표보다 크면 왼쪽으로 이동할 수 있습니다.

![image](https://github.com/hwibaski/java-problem-solving/assets/85930725/6f252a90-704c-4305-b4a0-228bc04ee7cc)


- 출처 : https://neetcode.io/courses/dsa-for-beginners/17

```java
public boolean search(TreeNode root, int target) {
    if (root == null) {
        return false;
    }

    if (target > root.val) {
        return search(root.right, target);
    } else if (target < root.val) {
        return search(root.left, target);
    } else {
        return true;
    }
}

```

## 시간복잡도

탐색하려는 트리가 균형 이진 트리(Balanced Binary Tree) 라면 탐색의 시간복잡도는 O(logn) 입니다.

균형 이진 트리는 왼편의 서브 트리와 오른편의 서브 트리의 높이가 같거나 그 차이가 1인 트리를 의미합니다.

우리가 왜곡된 이진 트리를 가지고 있는 경우 탐색의 시간 복잡도는 최악의 경우 O(n)이 됩니다.

예를 들어 우리의 트리의 요소가 [2, 3, 4, 5, 6]이고 우리가 찾고자 하는 요소가 6이라면 해당 트리는 결국 링크드 리스트의 형태를 띄게 됩니다.

따라서 O(n)의 시간 복잡도를 가지게 됩니다.

### reference

- https://neetcode.io/courses/dsa-for-beginners/17

