# Factorial - Recursion(One Branch)

재귀는 함수가 더 작은 출력으로 스스로를 호출하는 것을 말합니다.

반복 함수는 for 루프와 while 루프를 사용하지만 재귀 함수는 기준 케이스에 도달할 때까지 스스로를 호출하여 이를 달성합니다.

재귀 함수는 두 가지 부분으로 이루어져 있습니다.

1. The base case (기저 조건)
2. 자기 자신이 받은 input(parameter)과는 다른 input으로 함수 자신이 스스로를 호출하는 부분

## About

재귀함수를 가장 잘 설명할 수 있는 예시는 팩토리얼입니다.

팩토리얼의 식은 아래와 같습니다

```text
n! = n * (n - 1) * (n - 2) * ... 1 
```

n!은 n에서 1까지의 모든 숫자의 누적 곱을 나타내는 간단한 방법입니다

조금 더 간단히 말하자면 n!은 n * (n-1)! 로 나타낼 수도 있습니다.

5!은 5 * 4!입니다.

```java
public int factorial(int n){
    // 기저 조건: n = 0 or 1
    if(n<=1){
        return 1;
    }
    // 재귀파트: n! = n * (n - 1)! <- 자기 자신이 받은 input 보다 -1을 하여 스스로를 다시 호출
    return n*factorial(n-1);
}
```

![image](https://github.com/hwibaski/java-problem-solving/assets/85930725/65bf7811-007d-47a5-be71-f901b34d66e0)
출처 : https://neetcode.io/courses/dsa-for-beginners/8


> 재귀 함수의 기저 조건을 빼먹으면 재귀함수는 무한으로 호출 됩니다. 그리고 이는 stack overflow를 발생시킵니다.

## 시간, 공간 복잡도 분석

위의 factorial 함수는 O(n)의 시간 복잡도를 가집니다. 게다가 O(n)의 공간 복잡도를 가집니다.

재귀는 콜스택을 기반으로 동작하며, n개의 재귀 호출이 있을 경우 n개의 콜스택이 생성되므로 O(n)의 공간이 필요합니다.

이는 재귀 호출이 깊어질수록 콜스택의 크기가 증가한다는 것을 의미합니다.

따라서 재귀 알고리즘의 공간 복잡도는 호출 횟수에 선형적으로 비례합니다.

> 트리 구조에서는 재귀가 깊이 우선 탐색(Depth-First Search, DFS)을 수행하는 데에 매우 유용합니다.

### reference

- https://neetcode.io/courses/dsa-for-beginners/8
