# [day14] java-basic : Set

## Set의 특징

- 순서 없고, 중복을 허용하지 않는다.

- Set은 검색 속도를 빠르게 하기 위해 나왔다. 

- 순서가 있는 자료에는 적합하지 않고, 검색에 적합하다.

- treeset의 경우 각 레벨마다 하나의 데이터만 탐색하기 때문에 더 빠른 것이다. 

![image](https://user-images.githubusercontent.com/77392444/112424777-5d8c4d80-8d78-11eb-901e-d377b808089c.png)

- 하지만 전체 데이터에 뽑아내서 정렬하기에는 적합하지 않다.

- 구현클래스는 HashSet, TreeSet이 있다.

## Set메소드

- `remove(Object o)` : 특정 데이터를 삭제한다. index를 매개변수로 사용할 수 없다. 

- Set에는 index가 없기 때문에 List와 달리 `get()`가 존재하지 않는다.
