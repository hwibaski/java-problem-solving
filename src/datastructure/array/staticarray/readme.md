# Static Arrays

배열은 데이터를 연속적으로 저장하는 방법입니다. 배열은 초기화할 때 할당된 크기를 가져야 합니다. 즉, 배열의 크기는 한 번 선언되면 변경할 수 없으며 용량이 다하면 더 이상 값을 저장할 수 없습니다.

배열은 다음과 같은 주요 기능이 있습니다.

1. 읽기 (reading)
2. 삽입 (insertion)
3. 삭제 (deletion)

## 배열에서의 읽기

```test
int[] arr = new int[3];
int[] arr2 = {1, 3, 5};

arr[1];
```

- 배열에서의 읽기는 O(1)의 시간복잡도를 가진다
- 배열의 크기는 배열의 요소에 접근하는데 걸리는 시간에 영향을 주지 않는다.

![img_2.png](img_2.png)

## 배열에서의 삭제

### 배열의 가장 뒤의 요소 삭제

- 배열은 초기화 시 요소들의 값을 설정해주지 않으면 모든 요소들이 0으로 초기화되거나 특정 초기값으로 설정됩니다. 이는 빈 배열을 의미합니다.
- 이를 이용해 가장 끝의 요소를 삭제한 것처럼 작업할 수 있습니다. 실제로는 값이 삭제되는 것이 아니라 덮어 씌워지는 것입니다.

```text
// Remove from the last position in the array if the array
// is not empty (i.e. length is non-zero).
public void removeEnd(int[] arr, int length) {
    if (length > 0) {
        // Overwrite last element with some default value.
        // We would also consider the length to be decreased by 1.
        arr[length - 1] = 0;
        length--;
    }
}
```

![img_3.png](img_3.png)

### i번째 요소 삭제

최악의 경우 0번째 요소를 삭제할 경우 모든 인덱스의 요소를 하나씩 앞으로 이동시켜야한다.

```text
// Remove value at index i before shifting elements to the left.
// Assuming i is a valid index.
public void removeMiddle(int[] arr, int i, int length) {
    // Shift starting from i + 1 to end.
    for (int index = i + 1; index < length; index++) {
        arr[index - 1] = arr[index];
    } 
    // No need to 'remove' arr[i], since we already shifted
}
```

![img_4.png](img_4.png)

## 삽입

### 배열의 가장 뒤에 요소 삽입

```text
public void insertEnd(int[] arr, int n, int length, int capacity) {
    if (length < capacity) {
        arr[length] = n;
    }
}   
```

> 여기서 length는 비어 있지 않은 인덱스의 수이고 capacity는 인스턴스화 시 선언되는 배열의 실제 크기입니다. 이는 현재 마지막 인덱스인 길이 인덱스를 원하는 값인 n에 할당하기 때문에 의미가 있습니다.

### 배열의 i번째 요소 삽입

- 원하는 인덱스에 요소를 바로 삽입할 수도 있습니다. 그럴 경우 기존에 가지고 있던 값을 잃어버리기 때문에 기존의 값들을 한 칸 씩 뒤로 이동시켜주어야 합니다.

```text
// Insert n into index i after shifting elements to the right.
// Assuming i is a valid index and arr is not full.
public void insertMiddle(int[] arr, int i, int n, int length) {
    // Shift starting from the end to i.
    for (int index = length - 1; index > i - 1; index--) {
        arr[index + 1] = arr[index];
    }
    // Insert at i
    arr[i] = n;
}
```

![img_5.png](img_5.png)

| 동작 | 시간 복잡도 | 특이사항                 |
|----|--------|----------------------|
| 접근 | O(1)   |                      |
| 삽입 | O(n)   | 가장 끝에 삽입할 경우 O(1)    |
| 삭제 | O(n)   | 가장 끝의 요소 삭제할 경우 O(1) |
