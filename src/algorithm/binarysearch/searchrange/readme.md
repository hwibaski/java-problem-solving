# Search Range - Binary Search

이진 탐색을 베열에만 적용할 수 있는 것은 아닙니다.

누군가 1 - 100 사이의 범위를 제시하고 생각하는 숫자를 맞혀보라고 했다고 가정해 보세요.

세 가지 결과가 나올 수 있습니다. 추측이 맞거나, 너무 작거나, 너무 크거나.

배열에서 사용했던 이진 탐색과의 차이점은 누군가 생각하는 숫자(일명 target 값)를 모른다는 점입니다.

추측할 때마다 누군가로부터 피드백을 받고 그에 따라 다음 추측을 조정할 수 있을 뿐입니다.

물론 친구는 여러분의 추측이 너무 작거나 큰지 판단하는 절차가 있는데, 이 절차는 간단합니다.

친구는 추측한 숫자와 자신이 생각하는 숫자를 비교하여 더 높게 또는 더 낮게 추측해야 하는지 알려주기만 하면 됩니다.

이 방법의 의사 코드는 다음과 같습니다:

```text
// n이 크다면 1을 return, 작다면 -1 리턴, n이 target과 같다면 0을 리턴
public static int isCorrect(int n) {
    int target = 10;
    if (n > target) {
        return 1;
    } else if (n < target) {
        return -1;
    } else {
        return 0;
    }
}
```

위의 헬퍼 메서드를 이용해서 이진 탐색을 할 수 있습니다.

```text
public static int binarySearch(int low, int high) {
    int mid;

    while (low <= high) {
        mid = (low + high) / 2;

        if (isCorrect(mid) > 0) {
            high = mid - 1;
        } else if (isCorrect(mid) < 0) {
            low = mid + 1;
        } else {
            return mid;
        }
    }
    return -1;
}
```

배열에서의 이진탐색에서 사용했던 left, right 포인터가 여기서는 low, high로 대응됩니다.

### reference

- https://neetcode.io/courses/dsa-for-beginners/15
