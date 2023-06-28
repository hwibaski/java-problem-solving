# Search Array - Binary Search

이진 탐색은 정렬된 배열내에서 효과적으로 목표 요소를 찾는 탐색 방법입니다.

이진 탐색은 주어진 배열(오름차순 정열된 배열 가정)에서 중간 요소를 찾고 우리가 찾고자 하는 요소(이하 타겟)와 비교합니다.

중간의 요소가 타겟보다 큰 경우 중간 요소의 왼편을 탐색하고, 중간의 요소가 타겟보다 작은 경우 중간 요소의 오른편을 탐색합니다.

이런식으로 타겟을 찾을 때 찾을 대상을 반씩 줄여가면서 탐색을 합니다.

## 동작 방식

1. left = 가장 왼편의 요소
2. right = 가장 오른편의 요소
3. mid = left + right / 2 , 가운데의 요소

> 주어진 배열에서 left pointer가 right pointer를 넘어설 때까지 탐색을 진행합니다. left가 right를 넘어선 경우는 타켓값이 주어진 배열에 존재하지 않는 케이스 입니다.

## 타켓이 주어진 배열에 존재하는 경우

```text
arr = [1,2,3,4,5,6,7,8]
target = 5
```

출처 : https://neetcode.io/courses/dsa-for-beginners/14

```text
int[] arr = {1, 3, 3, 4, 5, 6, 7, 8};

public static int binarySearch(int[] arr,  int target) {
    int L = 0, R = arr.length - 1;
    int mid;

    while (L <= R) {
        mid = (L + R) / 2;
        if (target > arr[mid]) {
            L = mid + 1;
        } else if (target < arr[mid]) {
            R = mid - 1;
        } else {
            return mid;
        }
    }
    return - 1;
}
```

> mid = (L + R) / 2 : 이 코드는 overflow 현상으로 인해 버그가 발생할 수 있습니다. 정확히는 L + R이 int 범위(2^31 - 1)를 넘어서는 순간 문제가 발생합니다.
> 오버플로우가 발생하지 않게 하기 위해서 int mid = L + ((R + L) / 2) 를 하거나 참고 문서에 나오는 코드들을 사용해도 됩니다.

## 타켓이 주어진 배열에 존재하지 않는 경우

출처 : https://neetcode.io/courses/dsa-for-beginners/14

## 시간, 공간 복잡도 분석

O(logN)의 시간복잡도를 가집니다.

logN의 시간복잡도가 구해지는 과정을 한 번 살펴보겠습니다.

우리가 알고 있는 사실은 이진탐색을 진행할 때마다 1/2씩 탐색해야할 크기가 줄어듭니다.

그리고 우리가 알고 싶은 사실은 몇 번만 탐색해야할 사이즈가 1이 되어서 목표를 찾느냐 입니다.

이를 식으로 바꾸면 원본 배열의 크기가 N이라고 할 때,

N * (1/2)^k = 1 이고 우리는 몇 번 탐색을 해야하는지가 궁금하니 k값을 찾는 것이 목표입니다.

k를 구하기 위해 식을 조절하겠습니다.

N / 2^k = 1 -> N = 2^k -> logN = k

logN번을 수행해야 우리가 목표하는 값을 찾을 수 있다라는 식이 도출됩니다.

### reference

- https://neetcode.io/courses/dsa-for-beginners/14
- https://endorphin0710.tistory.com/112
- https://ai.googleblog.com/2006/06/extra-extra-read-all-about-it-nearly.html
- https://www.youtube.com/watch?v=tTFoClBZutw
