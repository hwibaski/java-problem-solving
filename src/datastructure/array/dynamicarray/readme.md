# Dynamic Arrays

동적 배열은 static arrays에 비해 크기 조정이 가능하기 때문에 유용합니다. 정적 배열과의 차이점은 초기화 시 크기를 지정할 필요가 없다는 것입니다.

## 동적 배열의 동작 방식

동적 배열은 배열의 공간이 부족할 때 스스로 공간을 늘립니다. 다만 기존에 있던 배열의 크기는 느릴 수 없으므로 새로운 배열을 기존 배열의 크기의 2배 만큼 할당하고 기존의 데이터들을 새로운 데이터로 이동시킵니다.

이 동작은 분할상환시간 O(1) - Amortized O(1)이 소요됩니다.
![image](https://github.com/hwibaski/java-problem-solving/assets/85930725/4782754a-d7f0-4148-badc-f67719076f79)

출처 : https://neetcode.io/courses/dsa-for-beginners/3

![image](https://github.com/hwibaski/java-problem-solving/assets/85930725/330f15cd-b358-47c2-8866-06c8cae0d96c)

출처 : https://neetcode.io/courses/dsa-for-beginners/3


## Amortized Analysis란?

동적 배열의 doubling 과정은 항상 발생하지 않습니다. 배열의 공간이 부족할 때만 발생하죠.

doubling을 수행할 경우 O(N)의 시간 복잡도를 가지지만 doubling은 항상 발생하지는 않습니다.

가끔 발생하는 doubling 때문에 동적 배열의 요소 삽입의 시간 복잡도를 O(N)으로 분석하는 건 제대로된 분석이 아닌 것 같습니다.

doubling을 하지 않을 때는 O(1)의 시간 복잡도를 가지고 doubling은 자주 발생하지 않으니까요.

이러한 점을 고려해서 시간 복잡도를 분석할 수 있는 분석법이 분활상환분석(Amortized Analysis)입니다.

## 왜 더블링을 하는가?

크기가 1인 동적배열에서 크기가 8인 동적 배열을 만들기 위해서는 아래의 그림과 같은 과정이 필요합니다. (초기에 동적 배열의 크기를 지정해주는 경우는 제외합니다.)

크기가 2인 동적배열에서 크기가 4인 동적배열로 더블링을 할 경우 새로운 배열을 생성하고 이전의 요소들(5, 6)을 복사하는데 두 번의 동작이 필요하고 새로운 요소들(7, 8)을 삽입하는데 2번의 동작이 필요합니다.

따라서 총 4번의 단계가 소요됩니다.

각각의 단계에서 1 -> 2 -> 4 -> 8의 단계가 필요합니다. 이는 크기가 8인 동적 배열의 삽입 과정에는 16 단계가 필요하다는 이야기고 정적 배열이 8번의 단계가 필요한 것 대비 2배가 더 소요 됩니다.

2n이 소요됩니다만 상수인 2는 무시하므로 n의 시간복잡도가 소요됩니다.

크기가 8인 정적 배열에 8개의 요소를 삽입하는데 소요되는 단계는 8입니다. n만큼이 소요됩니다.

크기1인 동적 배열에서 8개의 요소를 삽인하는데 소요되는 단계는 총 16입니다. 2n만큼 소요됩니다.

즉 요소 삽입 시 정적 배열보다는 아니지만 충분히 빠른 성능을 보장할 수 있습니다.

![image](https://github.com/hwibaski/java-problem-solving/assets/85930725/46c13116-4d14-47d7-a379-da6571b06f60)
출처 : https://neetcode.io/courses/dsa-for-beginners/3

![img_1.png](img_1.png)
출처 : https://neetcode.io/courses/dsa-for-beginners/3

| 동작 | 시간 복잡도 | 특이사항              |
|----|--------|-------------------|
| 접근 | O(1)   |                   |
| 삽입 | O(1)   | 중간에 삽입 시 O(n)     |
| 삭제 | O(1)   | 중간 요소 삭제할 경우 O(n) |

### reference

- https://neetcode.io/courses/dsa-for-beginners/3
