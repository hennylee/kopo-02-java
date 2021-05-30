# [day14] java-basic : Set

## Set의 특징

- 순서 없고, 중복을 허용하지 않는다.

- Set은 검색 속도를 빠르게 하기 위해 나왔다. 

- 순서가 있는 자료에는 적합하지 않고, 검색에 적합하다.

- treeset의 경우 각 레벨마다 하나의 데이터만 탐색하기 때문에 더 빠른 것이다. 

  ![image](https://user-images.githubusercontent.com/77392444/112424777-5d8c4d80-8d78-11eb-901e-d377b808089c.png)

- 하지만 전체 데이터에 뽑아내서 정렬하기에는 적합하지 않다.

- 구현클래스는 HashSet, TreeSet이 있다.

- 문자열의 경우에는 사전순으로 출력된다.



## Set메소드

- `remove(Object o)` : 특정 데이터를 삭제한다. index를 매개변수로 사용할 수 없다. 

- Set에는 index가 없기 때문에 List와 달리 `get()`가 존재하지 않는다.

- `add()` : 데이터를 순서없이 입력받는 것이다. 데이터를 넣으면 true, 못 넣으면 false를 반환한다. 

- `size()` : 배열에 들어있는 전체 데이터의 갯수를 반환해준다. 

- `remove(Object o)` : o라는 객체의 데이터를 삭제한다.

- `clear()` : set에 들어있는 데이터를 모두 다 지워서 사이즈를 0으로 만든다. 

- `boolean contains(Object o)` : 데이터 o가 있는지 없는지 확인해서 boolean형태로 반환한다.

- `boolean isEmpty()` : 데이터가 하나라도 존재하는지 체크한다. 

- `addAll(Collection c)` : 기존 콜렉션에 추가할 콜렉션의 전체 데이터를 추가한다. 

- `iterator()` : iterator객체를 반환한다. 

- `toArray()` : Set이 가지고 있는 모든 요소를 Object 형태로 고정된 배열에 저장한다.


## Tree구조

- [10, 4, 20, 9, 16, 14, 3, 12, 23]의 자료를 트리구조에 넣으면 ?

- 이진 트리 구조에서 2<sup>3</sup> < 자료 9개 < 2<sup>4</sup> 이므로 Depth는 4레벨이 되어야 제일 탐색 속도가 빠르다.

- InOrder방식에서는 Parent보다 작은 수는 다음 레벨의 Left, 큰 수는 Right에 넣는다.

- 접근 할 때는 Left - Parent - Right로 접근하면 오름차순 정렬이 된다. (InOrder방식)

- PreOrder, InOder, PostOrder방식은 트리를 구슬로 꿸때 바늘귀가 [왼쪽 / 가운데 / 오른쪽] 중 어디인지 잘 생각해보면 된다. 
