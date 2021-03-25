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

- `add()` : 데이터를 순서없이 입력받는 것이다. 데이터를 넣으면 true, 못 넣으면 false를 반환한다. 

- `size()` : 배열에 들어있는 전체 데이터의 갯수를 반환해준다. 

- `remove(Object o)` : o라는 객체의 데이터를 삭제한다.

- `clear()` : list에 들어있는 데이터를 모두 다 지워서 사이즈를 0으로 만든다. 

- `boolean contains(Object o)` : 데이터 o가 있는지 없는지 boolean형태로 반환한다.

- `boolean isEmpty()` : 데이터가 존재하는지 체크한다. 

- `addAll(Collection c)` : 기존 등록된 콜렉션 뒷부분에 추가할 콜렉션의 전체 데이터를 추가한다. 

- `iterator()` : iterator객체를 반환한다. 

- `toArray()` : Set이 가지고 있는 모든 요소를 Object 형태로 고정된 배열에 저장한다.
