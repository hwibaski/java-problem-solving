# BST Insert and Remove

BST의 삭제와 삽인은 O(logn)의 시간복잡도를 가집니다.

어떻게 그렇게 동작할 수 있는지 확인해보겠습니다.

## 삽입

BST에 새 노드를 삽입하기 위해서는 BST를 탐색하며 올바른 위치를 찾아야합니다.

우리가 BST [4]를 가지고 있고, 여기다가 6을 삽입하려면 [4, null, 6] or [6, 4, null] 중 하나의 방법을 택할 수 있습니다.

첫 번째 방법은 [4]의 right 노드를 [6]으로 설정하는 방법이고

두 번째 방법은 [6]을 루트 노드로 설정하고 [6]의 left 노드를 [4]로 설정하는 방법입니다.

두 개의 방법 모두 BST에서 유효한 방법입니다만 첫 번째 방법이 조금 더 간단한 방법이므로 이 방법을 살펴보겠습니다.

```java
// Insert a new node and return the root of the BST.
public TreeNode insert(TreeNode root,int val){
        if(root==null){
        return new TreeNode(val);
        }

        if(val>root.val){
        root.right=insert(root.right,val);
        }else if(val<root.val){
        root.left=insert(root.left,val);
        }
        return root;
        }
```

![image](https://github.com/hwibaski/java-problem-solving/assets/85930725/dcbf8c9e-c79a-4e16-8589-cf387227cdbb)

- 출처 : https://neetcode.io/courses/dsa-for-beginners/18

### insert(4, 6)

![image](https://github.com/hwibaski/java-problem-solving/assets/85930725/5b9d09bd-64a5-420f-8b0f-e768a8026a78)

### insert(4, 5)

![img_1](https://github.com/hwibaski/java-problem-solving/assets/85930725/48ed2d9b-6fe7-40df-b778-d889a35436b6)

## 삭제

BST에서 노드를 삭제하기전 우리는 두 가지 경우를 살펴봐야합니다.

1. 삭제하려는 노드의 자식이 없는 경우
    - -> 그냥 삭제
2. 삭제히려는 노드의 자식이 하나인 경우
    - -> 해당 자식 노드를 삭제할 노드의 위치로 끌어올림
3. 삭제하려는 노드의 자식이 두 개인 경우
    - -> 오른쪽 서브 트리의 MIN 값 OR 왼쪽 서브 트리의 MAX 값 중 하나를 삭제할 노드의 위치로 끌어올림

```java
// 삭제할 노드의 오른쪽자식 중에서 가장 작은 값을 찾아삭제할 노드를 대체하는 방식 

// Return the minimum value node of the BST.
public TreeNode minValueNode(TreeNode root){
        TreeNode curr=root;
        while(curr!=null&&curr.left!=null){
        curr=curr.left;
        }
        return curr;
        }

// Remove a node and return the root of the BST.
public TreeNode remove(TreeNode root,int val){
        if(root==null){
        return null;
        }
        if(val>root.val){
        root.right=remove(root.right,val);
        }else if(val<root.val){
        root.left=remove(root.left,val);
        }else{
        if(root.left==null){
        return root.right;
        }else if(root.right==null){
        return root.left;
        }else{
        TreeNode minNode=minValueNode(root.right);
        root.val=minNode.val;
        root.right=remove(root.right,minNode.val);
        }
        }
        return root;
        }    
```

### Case 1 - 삭제하려는 노드의 자식이없는 경우

아래의 그림에서 자식이 없는 노드인 2를 지우려면 3의 left 포인터를 null로 만들면 됩니다.

![image](https://github.com/hwibaski/java-problem-solving/assets/85930725/2db4cda6-e8ee-4a5b-a278-182b86570bff)

- 출처 : https://neetcode.io/courses/dsa-for-beginners/18

#### remove(4, 2)

![image](https://github.com/hwibaski/java-problem-solving/assets/85930725/0ecfbfd4-5e23-425b-b6ef-9de883ed57fa)

### Case 2 - 삭제히려는 노드의 자식이 하나인 경우

또는 자식이 하나인 3을 지우려면 root 노드의 포인터를 3대신 2를 가리키게 하면 됩니다.

![image](https://github.com/hwibaski/java-problem-solving/assets/85930725/55a9ff0c-90d0-41ff-9609-016ed6ae794b)

- 출처 : https://neetcode.io/courses/dsa-for-beginners/18

#### remove(4, 3)

![image](https://github.com/hwibaski/java-problem-solving/assets/85930725/f6f9df5f-40e6-4a27-9f83-76e0514603d0)

### Case 3 - 삭제하려는 노드의 자식이 두 개인 경우

우리가 6 노드를 지우고 싶다고 가정하겠습니다.

이 경우에는 상황이 조금 복잡합니다. 6 노드 자리를 다른 노드가 대체하여야 합니다.

어떤 노드가 6 노드의 자리를 대체할 수 있을까요?

1. 오른쪽자식 중에서 가장 작은 값을 6자리로 옮긴다
    - 삭제 대상의 오른쪽 트리 중 가장 왼쪽에 있는 값을 찾아 6 자리로 옮긴다.

2. 왼쪽 자식 중에서 가장 큰 값을 6자리로 옮긴다.
    - 삭제 대상의 왼쪽 트리 중 가장 큰 값을 찾아 6 자리로 옮긴다.

두 개의 방법 모두 이진트리의 구조를 충족시킵니다.

아래의 그림에서는 2번 방법이 사용되었습니다.

왼쪽 자식 중에서 가장 큰 값은 5이므로 5를 6의 자리로 대체시킵니다.

![image](https://github.com/hwibaski/java-problem-solving/assets/85930725/cca9715d-6f4a-4123-919a-79ff759e4767)

- 출처 : https://neetcode.io/courses/dsa-for-beginners/18

#### remove(4, 6)

![image](https://github.com/hwibaski/java-problem-solving/assets/85930725/b6e4c56d-0d2b-4c3e-82b0-65962a845283)

## 시간 복잡도

이진 탐색 트리의 세 개 연산 (검색, 삽입, 삭제) 는 결국 트리를 순회하며 타겟 데이터의 위치를 찾는 연산이 공통적으로 필요하므로, 트리의 높이에 비례하여 시간 복잡도가 증가 하게 된다.

따라서 O(logn)의 시간 복잡도를 가진다.

하지만 최악의 경우 왜곡된 트리라면 O(n)의 시간 복잡도를 가질 수도 있다.

### reference

- https://neetcode.io/courses/dsa-for-beginners/18
- https://zeddios.tistory.com/492
- https://velog.io/@haero_kim/%EC%9D%B4%EC%A7%84-%ED%83%90%EC%83%89-%ED%8A%B8%EB%A6%AC-Binary-Search-Tree

