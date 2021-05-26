
## 1. java.net API

1. IP 관련 : InetAddress

2. Web 관련 : URL

3. TCP 관련 : Socket, ServerSocket


### 1.1 InetAddress API

- IP 관련 정보를 받아올 때 사용하는 클래스

- 공식문서 : https://docs.oracle.com/javase/8/docs/api/java/net/InetAddress.html

- 인스턴스 객체를 만들 필요가 없다. 생성자가 없다. static 메소드를 이용해 접근하는 것이다. 

![image](https://user-images.githubusercontent.com/77392444/119456056-3a304f80-bd75-11eb-8a53-f487a7fbb06b.png)



#### InetAddress API 메소드 및 생성자

```java
package kr.ac.kopo.day17;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetAddressMain {
	public static void main(String[] args) {
		
		try {
			InetAddress localhost = InetAddress.getLocalHost();
			
			System.out.println("내 컴퓨터의 네트워크 이름 : "+localhost.getHostName());
			System.out.println("내 컴퓨터의 IP 주소 : "+localhost.getHostAddress());
			
			System.out.println(localhost); 			  // 이것을 출력하면 호스트네임과 호스트주소가 둘 다 출력되는 이유는?
			System.out.println(localhost.toString()); // toString 메소드를 오버라이딩해서 둘 다 출력하도록 정의했기 때문이다.
			
			InetAddress addr = InetAddress.getByName("www.hanati.co.kr");
			System.out.println("하나금융티아이 IP : " + addr.getHostAddress());
			System.out.println("하나금융티아이 IP : " + addr.getHostName());
			
			InetAddress[] addrs = InetAddress.getAllByName("www.naver.com");
			System.out.println("------------------------------------------");
			System.out.println("\t\t네이버 ip 주소");
			System.out.println("------------------------------------------");
			for(InetAddress address : addrs) {
				System.out.println(address);
			}
			System.out.println("------------------------------------------");
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		
	}
}
```

### 1.2 URL API

- 공식문서 : https://docs.oracle.com/javase/8/docs/api/java/net/URL.html

- URL은 어떤 컴퓨터에 어떤 작업을 할지 명시하는 키워드이다. 

- URL : `protocol://host:post/filename(경로포함)`
  - protocol : 통신규약
  - HTTP - 하이퍼텍스트, FTP - 파일, SMTP - 메일

#### URL API 생성자 및 메소드

```java
package kr.ac.kopo.day18;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class URLMain {
	public static void main(String[] args) {
		try {
			URL urlObj = new URL("https://comic.naver.com/webtoon/list.nhn?titleId=670143&weekday=wed");
			URL urlObj2 = new URL("http://www.naver.com:80");
			
			// 1. URL 정보를 알고 싶을 때 사용하는 메소드
			System.out.println("프로토콜 : " +  urlObj.getProtocol());
			System.out.println("호스트명 : " +  urlObj.getHost());
			System.out.println("포트 : " +  urlObj.getPort()); // 포트를 명시하지 않으면 -1로 인식
			System.out.println("경로 : " +  urlObj.getPath());
			System.out.println("쿼리 : " +  urlObj.getQuery());
			
			
			// 2. openStream 메소드 => 페이지 소스 보기 했을때의 내용이 불러와짐, input만 가능하다
			System.out.println("===================================================================");
			
			// input
			InputStream is = urlObj.openStream();
			InputStreamReader isr = new InputStreamReader(is, "utf-8"); // 한글이 깨지지 않도록 바이트스트림을 문자스트림으로 받는 필터
 			
			while(is.read() != -1) {
				int c = isr.read();
				System.out.print((char)c);
			}
			
			
			// 3. openConnection() => input, output 객체를 모두 사용 가능하다.
			System.out.println("===================================================================");

			// input
			URLConnection uc = urlObj.openConnection();
			InputStream is2 = uc.getInputStream();
			InputStreamReader isr2 = new InputStreamReader(is2, "utf-8"); // 한글이 깨지지 않도록 바이트스트림을 문자스트림으로 받는 필터
 			
			while(is2.read() != -1) {
				int c = isr2.read();
				System.out.print((char)c);
			}
			
			// output
			uc.getOutputStream();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
```


### 1.3 ServerSocket API


#### 소켓(Socket)이란?

![image](https://user-images.githubusercontent.com/77392444/119587900-9b563280-be0a-11eb-9367-e212a097ae76.png)


- A컴퓨터와 B 컴퓨터의 각 컴퓨터에서 둘을 연결하고 있는 각각의 연결통로의 문을 Socket이라고 한다. 

- 소켓통신에서 데이터가 손실되지 않을 거라는 신뢰성이 중요하기 때문에 TCP 프로토콜 방식을 통해 데이터를 주고 받는다.

  - TCP : A컴퓨터~ 너 나랑 통신할 준비 되어 있니? 응! => B컴퓨터~ 너 나랑 통신할 준비 되어 있니? 응! => 데이터를 주고 받는다.
  - UDP : 내가 보냈다는 것에 의의를 둘 뿐, 받았다는 것을 보장하지 않는 통신 규약이다. 데이터 전송속도가 TCP에 비해 빠르지만, 신뢰성이 낮다.
  - 데이터그램 소켓 - UDP / 소켓통신 - TCP
  - [TCP 3 Way-Handshake](https://sleepyeyes.tistory.com/4)

#### 호스트와 포트

- 호스트주소 : 하나의 컴퓨터에 할당된 고유의 이름

- 호스트주소는 인터넷 상에서 IP주소나 도메인명으로 나타난다.

- 하나의 호스트는 여러개의 포트를 가질 수 있다. 

- 예를 들어, IP만 알고 있다고 해서 오라클에 접근할 수 없다. 포트 번호도 함께 알아야 다른 컴퓨터의 DB 서비스에 접근할 수 있다.

- 이때 포트가 바로 컴퓨터에서 어떤 서비스에 접근할지 구분하는 구분자 역할을 하게 된다. 

- 약속된 포트 번호들이 있다. (WEB - 8080, ORA - 1521) 밴더사들의 포트는 1000번대에 몰려있기 때문에, 개발자는 10000번대의 포트번호를 사용하는 것이 좋다. 

- 서버 어플리케이션은 클라이언트의 요청을 위해 대기할 때 미리 정해진 포트를 감시한다.

- 호스트는 전화번호에, 포트는 내선번호에 비유할 수 있다.

#### 서버와 클라이언트

- 예를 들어, 자료를 다운받을 때 자료를 가지고 있는 컴퓨터가 서버이고 자료를 다운받는 컴퓨터가 클라이언트이다. 
