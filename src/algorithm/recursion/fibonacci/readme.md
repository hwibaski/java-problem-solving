# Fibonacci Sequence - Recrusion(Two Branch)

two-branch 재귀의 예시는 피보나치 수열입니다.

피보나치 수열은 각 항이 바로 앞의 두 항의 합으로 이루어진 수열로, 처음 두 항은 0과 1입니다.

```text
fib(n)=fib(n−1)+fib(n−2)
```

## About

```java
// Base case: n = 0 or 1
public static int fibonacci(int n){
    if(n<=1){
        return n;
    }
    
    // Recursive case: fib(n) = fib(n - 1) + fib(n - 1)
    return fibonacci(n-1)+fibonacci(n-2);
}
```

위의 예제는 팩토리얼을과 유사하지만 2개의 재귀로 분기된다는 것이 다릅니다. 재귀 파트에서 자기 자신을 2번 호출 함으로써 트리가 생성됩니다.

![image](https://github.com/hwibaski/java-problem-solving/assets/85930725/6971b887-e2ec-47b2-a8bf-c7f607ca279a)

출처 : https://neetcode.io/courses/dsa-for-beginners/9

## 시간 복잡도 분석

트리에서 가장 긴 경로를 찾게 되면 이 트리의 높이를 구할 수 있습니다. 이 트리의 높이는 곧 레벨이다.

그림의 트리에서 각 노드의 수는 각 레벨 마다 2의 거듭제곱으로 증가할 수 있습니다.

각 레벨(n)에는 2^n만큼의 노드를 가질 수 있습니다.

이 트리에서의 노드들은 로직을 실행하는 단계로 볼 수 있으므로 피보나치 수열은 O(2^n)의 시간 복잡도를 가진다고 볼 수 있습니다.

![image](https://github.com/hwibaski/java-problem-solving/assets/85930725/c7db6d97-3598-4bec-bde6-72bf62bfdedf)
출처 : https://neetcode.io/courses/dsa-for-beginners/9


### reference

- https://neetcode.io/courses/dsa-for-beginners/9
