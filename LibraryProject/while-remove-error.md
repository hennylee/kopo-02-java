	
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



- remove안에 interator를 조작하는 기능이 있어서....그렇다는데... 해결방법은 interator를 사용하라고 함

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
		
