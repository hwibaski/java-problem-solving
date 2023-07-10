# BST Sets and Maps

Set과 Map은 스택과 큐와 비슷하게 추상적인 자료구조 입니다. 이 뜻은 다른 자료구조를 이용해서 Set, Map, Stack, Queue를 구현할 수 있다는 뜻입니다.

Tree를 이용해서 Set과 Map을 구현할 수 있습니다.

## Sets

우리는 Alice, Brad, Collin 이라는 세 명의 이름이 있는 전화번호부를 가지고 있습니다.

동적 배열을 사용하여 저장할 수도 있지만 Set을 사용하면 데이터 구조에 고유한 값을 확보할 수 있고 트리를 사용하여 구현하면 키가 알파벳순으로 정렬될 수 있습니다.

## Maps

맵은 `key-value` 쌍으로 동작합니다.

전화번호부의 예로 돌아가서, Map을 이용하면 이름을 저장할 수 있을 뿐만 아니라 전화번호도 매핑할 수도 있습니다.

Map은 키에 따라 정렬됩니다. 키가 값에 매핑되므로 키와 관련된 모든 정보를 찾을 수 있습니다.

여기서의 value값은 꼭 특정 타입일 필요는 없으며 객체가 될 수도 있습니다.

특정 키를 찾는데 O(logn)이 소요될 것 입니다.

```text
{'Alice' : 123, 'Brad' : 345, 'Collin' : 678}
```

```text
//TreeSet 생성
TreeSet<Integer> set = new TreeSet<Integer>();

//TreeMap 생성
TreeMap<String, String> treeMap = new TreeMap<String, String>();
```
