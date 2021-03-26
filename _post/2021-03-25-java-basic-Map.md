# [day14] java-basic : Map

## Map의 특징

- Key와 Value의 한 쌍으로 나누어서 데이터를 관리한다. 

- 목적은 Value값들을 저장하는 것이다.

- 이때, Value값들 빠르게 탐색하기 위한 대안으로 Key를 활용하는 것이다. 

- Key는 반드시 구분되어야 하기 때문에 중복값을 허용하지 않는다.

- Map은 Collection을 상속받지 않는다. 

- 구현클래스는 HashMap과 TreeMap이 있다.

## Map의 메소드

- `put(K key, V value)` : key와 value쌍으로 데이터를 입력한다. key가 중복되는 경우 새로운 값으로 업데이트하고 기존 값을 반환한다.

- `get(Object key)` : key를 매개변수로 value값을 반환한다. 값이 없을 경우에는 null을 반환한다.

- `remove(Object key)` : 데이터를 삭제하는 것이다. 값이 없을 경우엔 null을 반환한다.

- `boolean containsKey(Object Key)` : 특정 키 확인하기, key가 존재하면 true를 반환한다.

- `boolean containsValue(Object value)`

- `putAll(Map<K key, V value> m)` : 

- `getOrDefault` : 

- `containsKey(Object key)`

- `Set<Map.Entry<K,V>>	entrySet()` : 실제 데이터를 가지고 있는 `Map.Entry`의 `Set` 집합을 반환한다.

```java
class Map {
  
  // Entry : Map의 inner Class ==> Map.Entry
  class Entry {
    Object key;
    Object value;
  }

}
```

- `keySet()` : key들은 set으로 묶어서 반환한다.

- Set이 검색속도를 빠르게 해주기 때문에 Set으로 변환해서 출력하는 것이다.


## Map의 내용 비교
* Object클래스의 equals메소드는 주소값만 비교하는데,

* Map에는 주소값이 상관없에 내용이 같으면 같은 객체로 인식할 수 있는 방법이 있다.

* 그것이 바로 equals 메소드를 오버라이딩 해서 내용 비교를 하게 만들고 hash코드도 같게 만드는 방법이다.
 
* 근데 해시코드까지 같게 만드는 것은 너무 귀찮다.

* 그래서 Source에서 hashcode와 equals를 클릭해 자동으로 만드는 방법이 사용하면 된다.

```java
	/**
	 * 이클립스에서 자동으로 생성해준 hashcode와 equals
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((phone == null) ? 0 : phone.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Member other = (Member) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (phone == null) {
			if (other.phone != null)
				return false;
		} else if (!phone.equals(other.phone))
			return false;
		return true;
	}
```
