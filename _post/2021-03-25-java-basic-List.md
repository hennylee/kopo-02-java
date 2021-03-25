# [day14] java-basic : (1) List

## List 특징
- 순서가 있고 중복을 허용한다. 

- List는 인터페이스이므로 객체 생성이 불가하다. 

- 그래서 List는 ArrayList나 LikedList로 구현해야 한다.(구현클래스)

- LinkedList의 장점은 순서를 가지고 있기 때문에 루프를 통해 모든 데이터에 접근하기가 편이하다. 

- 반면, LinkedList에서 앞쪽은 빨리 검색되지만 뒷쪽을 검색하면 속도가 느려질 수 밖에 없다는 단점이 있다. 

- List는 0부터 순차적으로 모든 자료를 탐색하기 때문에 검색 시, 최악의 시간복잡도는 `O(N)`이다.

- 그래서 검색을 목적으로 했을 경우에는 List는 적합하지 않다.

## List 메소드

- 배열을 기반으로 만들어졌다.

- `add()` : 데이터를 순차적으로 차곡차곡 입력받는 것이다. 데이터를 넣으면 true, 못 넣으면 false를 반환한다. 

- `get(int index)` : index에 해당하는 데이터를 알려준다.

- `size()` : 배열에 들어있는 전체 데이터의 갯수를 반환해준다. 

- `remove(int index)` : index위치의 데이터를 삭제하고 동적으로 남은 데이터들의 index를 변경한다. 

- `remove(Object o)` : o라는 객체의 데이터를 삭제한다. 중복 데이터가 있다면 0번지부터 검색해서 앞쪽의 데이터 하나만 지운다.

- `clear()` : list에 들어있는 데이터를 모두 다 지워서 사이즈를 0으로 만든다. 

- `boolean contains(Object o)` : 데이터 o가 있는지 없는지 boolean형태로 반환한다.

- `boolean isEmpty()` : 데이터가 존재하는지 체크한다. 

- `addAll(Collection c)` : 기존 등록된 콜렉션 뒷부분에 추가할 콜렉션의 전체 데이터를 추가한다. 

- `iterator()` : iterator객체를 반환한다. 

- `toArray()` : 리스트가 가지고 있는 모든 요소를 고정된 배열에 저장한다.


## Iterator(순환자) 주요 메소드

- 순환자는 순차적으로 접근하도록 만들어진 객체이다.(= 이전 버전의 enumerate와 같은 기능이다.)

- `next()` : 데이터추출한다.

- `hasNext()` : 추출할 다음 데이터의 존재여부를 판단

- 맨 처음에 Iterator는 -1번지 index를 가르킨다. 

- hasNext()를 통해 다음 데이터가 있으면, next로 데이터 추출 후 Iterator가 1번지로 옮겨간다.

- 또 hasNext()를 통해 다음 데이터가 있으면, next로 데이터 추출 후 Iterator가 2번지로 옮겨간다.

- 반복하다가 hasNext()를 통해 다음 데이터가 없으면, next를 수행하지 않으면 된다.
