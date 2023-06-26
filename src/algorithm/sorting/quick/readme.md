# Quick Sort - 퀵 정렬

퀵정렬은 간단한 개념은 아래와 같습니다.

pivot이라고 불리는 index의 요소를 하나 선택합니다.

그리고 pivot 보다 작거나 같은 요소들은 pivot의 왼편에 두고, pivot 보다 큰 요소들은 pivot의 오른편에 둡니다.

![Screen-Recording-2023-06-26-at-11 40 39-AM](https://github.com/hwibaski/java-problem-solving/assets/85930725/a15e1048-07a3-49b6-8c3c-33c902e79750)

(이 gif에서는 pivot을 첫 번째 요소로 지정했다.)
출처 : https://visualgo.net/en/sorting

## pivot 선택하기

일반적으로 피벗을 선택할 때는 여러 가지 테스트를 거쳐 검증된 옵션이 있습니다:

1. 첫번째 요소 선택하기
2. 마지막 요소 선택하기
3. 중간 요소 선택하기
4. 랜덤 요소 선택하기

> 데이터 자체, 즉 크기와 초기 순서에 따라 피벗을 선택하는 기준은 달라집니다. 코딩 인터뷰의 경우 작업을 단순하게 유지할 수 있으므로 마지막 인덱스를 피벗으로 사용하겠습니다.

## 구현

재귀로 퀵정렬을 구현합니다. 병합 정렬과 비슷하게 정렬할 필요가 없는 서브 배열(길이가 1)이 나올 때 까지 퀵정렬을 재귀 호출할 것입니다.

우선 pivot 포인터는 배열의 마지막 요소를 선택합니다.

left pointer를 선택합니다. 이 포인터는 원본 배열의 제일 왼쪽 요소를 가리킵니다.

그런 다음, 배열을 순회하며 피벗 요소보다 작은 요소를 찾으면 현재 요소를 왼쪽 포인터의 요소와 스왑하고 left pointer를 그 다음 위치로 이동시킵니다.

이 순회가 끝나면 left pointer가 가리키고 있는 요소와 pivot pointer가 가리키고 있는 요소를 스왑합니다.

left pointer 요소와 pivot pointer 요소를 스왑함으로써 pivot 포인터의 왼쪽에는 pivot보다 작거나 같은 요소들이 배치되고, 오른쪽에는 pivot보다 큰 요소들이 배치됩니다.

![image](https://github.com/hwibaski/java-problem-solving/assets/85930725/042e662f-4e7d-4a63-b34e-48f3d3aafe21)

출처 : https://neetcode.io/courses/dsa-for-beginners/12

> 중요한 점은 이 과정에서 새로운 메모리를 사용하지 않았습니다. 즉 서브 배열을 복사하거나 하지 않고 원본 배열에 바로 수정을 가했습니다.

```java
public static int[] quickSort(int[] arr, int s, int e) {
    if (e - s + 1 <= 1) {
        return arr;
    }

    int pivot = arr[e];
    int left = s;       // left 포인터
        
    // Partition: pivot 보다 작은 값들은 left 포인터 가리키는 값과 swap 됩니다.
    // arr[i]의 값이 pivot보다 작지만 left 포인터가 arr[i]를 가리키는 경우에는 자기 자신과 스왑됩니다.
    for (int i = s; i < e; i++) {
        if (arr[i] < pivot) {
            int tmp = arr[left];
            arr[left] = arr[i];
            arr[i] = tmp;
            left++;
        }
    }

    // pivot과 left 요소를 스왑합니다. 이로써 pivot의 왼편에는 pivot보다 작거나 같은 값들이, 오른편에는 큰 값들이 위치하게 됩니다.
    arr[e] = arr[left];
    arr[left] = pivot;

    // pivot의 왼편들을 퀵정렬 합니다.
    quickSort(arr, s, left - 1);

    // pivot의 오른편들을 퀵정렬 합니다.
    quickSort(arr, left + 1, e);

    return arr;
}
```

## 시간 복잡도

퀵정렬은 평균적으로 O(n log n)의 시간 복잡도를 갖습니다. 이는 대부분의 경우에 대해 매우 효율적인 정렬 알고리즘이라는 것을 의미합니다.

퀵정렬의 최악 시간 복잡도는 O(n^2)입니다. 이는 입력 배열이 이미 정렬되어 있거나 거의 정렬된 경우에 발생할 수 있습니다.

pivot을 요소들 중 가장 큰 값이나 가장 작은 값으로 선택할 경우 최악의 시간 복잡도를 가질 수 있습니다.

## stability

병합 정렬의 안정성은 unstable 합니다.

[7(x), 3, 7(o), 4, 5]  배열을 퀵정렬 한다고 가정해보겠습니다. 우리의 피벗은 5입니다.

7요소들을 주목해주세요. 괄호 안의 표시 7을 특정하기 위함입니다.

퀵정렬 과정 중에 7(x)요소가 7(o) 요소보다 뒤쪽에 배치되게 됩니다.

[3, 7(x), 7(o), 4, 5] ->  [3, 4, 7(o), 7(x), 5]

### reference

- https://neetcode.io/courses/dsa-for-beginners/12
- https://visualgo.net/en/sorting
- https://velog.io/@eddy_song/quick-sort
