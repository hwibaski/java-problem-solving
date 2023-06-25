# Merge Sort - 병합 정렬

병합 정렬의 개념은 매우 간단합니다.

하위 배열의 크기가 1이 될 때까지 배열을 계속 반으로 분할하고, 정렬하고, 정렬된 배열을 병합하면 최종 정렬된 배열이 만들어집니다.

![Screen-Recording-2023-06-25-at-11 49 20-PM](https://github.com/hwibaski/java-problem-solving/assets/85930725/f142c5b5-473d-4498-9f03-80c6f6b50833)


출처 : https://visualgo.net/en/sorting


## 개념

우리가 정렬하려는 배열의 크기는 5이고 [3, 2, 4, 1, 6] 이렇게 생겼습니다.

병합 정렬은 두 개의 분기를 가지게 됩니다.

각 분기의 기저 조건(재귀 탈출 조건)은 서브 배열의 길이가 1, 즉 요소가 1개일 때 입니다.

그림을 보면 우리는 [3]과 [2]라는 더 이상 나눌 수 없는 서브 배열을 가지게 됩니다. 이 때 두 개의 요소를 비교하고 [3, 2]인 원본 배열에 병합을 진행합니다.

이를 위해 두 하위 배열의 복사본을 생성하고 투포인터를 사용하여 값을 비교하고 정렬된 순서대로 원래 하위 배열에 넣습니다.

```java
public static int[] mergeSort(int[]arr,int l,int r){ // array, array의 시작 인덱스, array의 끝 인덱스
    if (l < r) {
        // array의 중간 지점 찾기
        int m =(l + r) / 2;

        mergeSort(arr, l, m);   // array의 왼쪽 부분 정렬
        mergeSort(arr, m + 1, r); // array의 오른쪽 부분 정렬
        merge(arr, l, m, r);    // 정렬된 반반을 병합
    }
    return arr;
} 
```
![image](https://github.com/hwibaski/java-problem-solving/assets/85930725/74df0a45-1dec-4786-99ea-dc5ad64372d3)
![image](https://github.com/hwibaski/java-problem-solving/assets/85930725/9a2eb3a6-ba4f-476b-b74c-c0258ba8b3e8)


출처 : https://neetcode.io/courses/dsa-for-beginners/11

## merge() 함수

merge() 함수는 세 개의 포인터를 가지고 있습니다.

- k pointer: 원본 배열의 포인터
- i pointer: 왼쪽 서브 배열의 포인터
- j pointer: 오른쪽 서브 배열의 포인터

```java
// arr[]의 두 개의 서브 배열을 병합.
// 첫 번째 서브 배열은 arr[l..m]
// 두 번째 서브 배열은 arr[m+1..r]
public static void merge(int[]arr,int l,int m,int r){
// l : arr의 시작 idx
// m: 중간 idx
// r: arr의 마지막 idx

// 두 개의 서브 배열의 길이를 구한다.
int length1 = m - l + 1;
int length2 = r - m;

// 두 개의 임시 배열을 만든다.
int[] left = new int[length1];
int[] left = new int[length2];

// 만든 임시 배열에 왼쪽 & 오른쪽 배열의 값을 복사한다.
for(int i = 0; i < length1; i++){
    left[i] = arr[l + i];
}

for(int j = 0; j < length2; j++){
    right[j] = arr[m + 1 + j];
}

// left 배열을 가리킬 포인터, right 배열을 가리키 포인터를 초기화
int i=0; // left 배열을 위한 포인터
int j=0; // right 배열을 위한 포인터
int k=l; // arr(원본 배열)을 가리킬 포인터

// 정렬된 두 개의 서브 배열을 원본 배열에 병합한다.
while(i < length1 && j < length2){
// left 배열의 요소가 right 배열의 요소 보다 작거나 같으면
    if(left[i] <= right[j]){
        arr[k]=left[i];
        i++;
    } else {
        // right 배열의 요소가 left 배열의 요소 작으면
        arr[k] = right[j];
        j++;
    }
    k++;
}

// left 배열과 right 배열의 길이가 다르다면 while 문의 조건문에서 비교가 안 된 요소들이 있을 수 있다.
// left  배열 요소 중에 남은 요소들을 원본 배열에 복사한다.
while(i < length1){
    arr[k] = left[i];
    i++;
    k++;
}

        // right 배열 요소 중에 남은 요소들을 원본 배열에 복사한다.
while(j < length2){
    arr[k] = right[j];
    j++;
    k++;
}
}
```

## 시간 복잡도

병합 정렬읜 시간 복잡도는 O(nlogn) 입니다.

길이가 n인 원본 배열은 다음 레벨에서 n/2인 서브 배열들로 나누어집니다.

우리의 경우에는 초기에 n이 8이였다가 재귀 호출이 이루어질 질 수록 n = 4, n = 2, n = 1 까지 도달합니다.

우리의 궁금점은 우리의 기저 조건까지 도달하는데 n / 2를 몇 번을 해야하는가 입니다.

그 식은 이렇게 표현할 수 있습니다. n / 2^x = 1 (1은 기저 조건입니다.)

x는 n을 2로 나눈 횟수를 의미합니다.

n / 2^x = 1 -> n = 2^x -> logn = log2^x -> logn = xlog2 -> logn = x

우리의 재귀 호출의 시간 복잡도는 logn 입니다.

하지만 병합 과정에서 n만큼의 시간이 소요됩니다.

따라서 O(nlogn)의 시간 복잡도를 가집니다.

https://neetcode.io/courses/dsa-for-beginners/11

## stability

병합 정렬의 안정성은 stable 합니다.

그 이유는 우리가 merge() 함수 내에서 아래의 코드와 같이 병합을 진행하기 때문입니다.

```java
// 왼쪽 서브 배열과 오른쪽 서브 배열의 크기가 같다면 왼쪽 서브 배열을 복사하기 때문에 안정성이 유지된다.
if(leftSubarray[i] <= rightSubarray[j]){
    arr[k] = leftSubarray[i];
    i+=1;
}
```

## 삽입 정렬과의 비교

삽입 정렬은 최악의 경우 O(n^2)의 시간 복잡도를 가집니다. 하지만 병합 정렬은 최악, 평균, 최상의 경우에도 O(nlogn)의 시간 복잡도를 가집니다.
배열의 요소 수가 적고 이미 정렬되었거나 거의 정렬된 경우, 스와핑을 건너뛰기 때문에 삽입 정렬이 선호될 수 있습니다.
하지만 주어진 입력의 내용을 알지 못하면 삽입 정렬이 병합 정렬보다 성능이 떨어지므로 시간 측면에서 병합 정렬이 더 효율적입니다.

### reference

- https://neetcode.io/courses/dsa-for-beginners/11
- https://visualgo.net/en/sorting
