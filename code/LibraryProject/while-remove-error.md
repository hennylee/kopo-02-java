	
  - 이 부분에서 `ArrayList$Itr.checkForComodification`라는 오류 발생함
  
```java
  for(ReservationVO vo : reserveList) {
    System.out.println(reserveList.size());
    if(vo.getBookBarcode() == bookBarcode ) {
      reserveList.remove(vo);
    }
    System.out.println(reserveList.size());
    System.out.println("!!!!!!!!!!!!!!!!!!!!");
  }
```



- 인터넷에 찾아보니 remove안에 interator를 조작하는 기능이 있어서....그렇다는데... 해결방법은 interator를 사용하라고 함...잘 모르겠지만 따라해봄

```java
Iterator iter = reserveList.iterator(); 
ReservationVO rvo = new ReservationVO();
while(iter.hasNext()) { 
	if(rvo.getBookBarcode() == bookBarcode &&   rvo.equals(iter.next())) { 
		iter.remove(); 
	}
	break;
}
```
		
- 근데 이렇게 하면 List의 개별 요소에 접근할 수 없게 된다.

- 다시 for문으로 돌아와서 오류가 난 이유를 생각해보니, `for(ReservationVO vo : reserveList) {}` 안에서 `reserveList.remove(vo)`를 수행하기 때문이다. 
따라서 새로운 임시 List에 값을 담아두고 그 리스트의 값을 remove해주면 된다.
