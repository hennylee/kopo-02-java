# [day14] java-basic : Map

## Map의 특징

- Key와 Value의 한 쌍으로 나누어서 데이터를 관리한다. 

- 목적은 Value값들을 저장하는 것이다.

- 이때, Value값들 빠르게 탐색하기 위한 대안으로 Key를 활용하는 것이다. 

- Key는 반드시 구분되어야 하기 때문에 중복값을 허용하지 않는다.

- Map은 Collection을 상속받지 않는다. 

- 구현클래스는 HashMap과 TreeMap이 있다.

## Map의 메소드

- `put(K key, V value)` : key와 value쌍으로 데이터를 입력한다. 

- `get(Object key)` : key를 매개변수로 value값을 반환한다. 값이 없을 경우에는 null을 반환한다.

- `remove(Object key)` : 데이터를 삭제하는 것이다. 값이 없을 경우엔 null을 반환한다.

- `boolean containsKey(Object Key)` : 특정 키 확인하기, key가 존재하면 true를 반환한다.

- `boolean containsValue(Object value)`

- `putAll(Map<K key, V value> m)` : 

- `Set<Map.Entry<K,V>>	entrySet()` : 

- `getOrDefault` : 

- `containsKey(Object key)`
