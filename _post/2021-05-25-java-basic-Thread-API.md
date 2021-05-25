

## 1. 프로세스와 쓰레드

- 일반적으로는 싱글 프로세스 싱글 쓰레드 방식이다. 

- 쓰레드와 프로세스 차이는? 자원공유이다. 

#### 1.1 프로세스
- 프로세스 : 독립적인 자원들을 가지고 작업을 하는 것이다. 

- 멀티 프로세스는 음악 들으면서, 웹사이트 프로그램을 사용할 수 있는 것이다. 즉 여러개의 소프트웨어가 동시에 작동되는 것처럼 보이는 것이다. 

- 동시다발적으로 발생하는 것처럼 보이지만 서로 번갈아서 사용되는 것이다. 

#### 1.2 쓰레드
- 쓰레드 : 하나의 프로세스 안에 하나의 쓰레드를 가지고 있다. 

- 쓰레드는 프로세스가 가지고 있는 자원을 공유하는 것이다. 

- 원래 하나의 프로세스에는 하나의 쓰레드를 가지고 있다. 

- 멀티 쓰레드는 하나의 프로세스 안에 여러 개의 쓰레드를 가지고 있는 것이다. 하나의 프로세스 자원을 같이 공유해서 사용하는 것이다. 

- 멀티 쓰레드는 하나의 프로그램 안에서 여러개의 작업이 동시에 수행되는 것이다. (ex. 테트리스 게임 내에서 음악도 나오고, 영상도 나오는 것이 예이다.)

## 2. Thread 생성 방법

- 생성 방식이 2가지인 이유는 자바가 기본적으로 단일 상속만 지원하기 때문에 다중 상속을 위해 인터페이스 형식으로도 만들게 된 것이다. 

- 모든 쓰레드는 `run()` 메소드 안에 쓰레드가 수행해야할 작업을 정의한다. 그래서 쓰레드 관련 인터페이스 이름이 Runnable인 것이다. 

- 그리고 이 쓰레드를 작동시킬 때에는 `start()`메소드를 통해 JVM에게 쓰레드 수행을 지시하기만 하면 된다. 

- `쓰레드.start()` 메소드가 수행되면, JVM은 자동적으로 멀티 쓰레드 방식으로 쓰레드의 `run()` 메소드를 수행하는 것이다 .

![image](https://user-images.githubusercontent.com/77392444/119443552-c25a2900-bd64-11eb-9348-605250f562b9.png)


#### 2.1 Thread 클래스 상속으로 구현하는 방법 (단일 상속)

```java
package kr.ac.kopo.day17;

// Thread를 상속받으면 AAA, BBB가 Thread라고 인식된다. 
class AAA extends Thread {

	// run() => 쓰레드가 수행할 작업을 정의
	// alt + shift + s + v
	@Override
	public void run() {
		while(true) {
			System.out.println("go!!");
		}
	}
	
}
class BBB extends Thread {
	
	// run() => 쓰레드가 수행할 작업을 정의
	// alt + shift + s + v
	@Override
	public void run() {
		while(true) {
			System.out.println("\tstop!!");
		}
	}	
}

public class ThreadMain01 {
	
	public static void main(String[] args) {
		
		AAA ta = new AAA();
		BBB tb = new BBB();
		
		
		/*
		
		쓰레드가 실제로 작업할 것은 run()이기 때문에 원래는 ta.run(); 이라고 써야 한다.  
		
		ta.run();
		tb.run();
		
		하지만 이렇게 작성하면 쓰레드가 동시에 수행되지 않는다. 
		ta.run()이 수행되고, ta.run()이 완료되면 tb.run()이 수행된다. 
		
		실제로 쓰레드는 동시에 작업되는 것은 아니지만, 동시적으로 시행되는 것처럼 보이게 하려면 어떻게 해야 할까?
		
		JVM자체가 run() 메소드를 수행하게 해야 한다. 
		그래서 개발자는 run()이 아닌 start() 메소드를 실행하지만 하면 된다. 
		
		*/
		
		ta.start();
		tb.start();
	
	}
}
```

#### 2.2 Runnable 인터페이스 상속으로 구현하는 방법 (다중 상속, 복잡)

- runable 인터페이스를 상속받아 구현한 쓰레드는 그 자체로 실행할 수 없고, `Thread(Runnable r)` 생성자를 통해 `start()`해야 한다. 

- 인터페이스를 사용해서 구현되었기 때문에 다중 상속이 가능하다는 장점이 있다. 

```java
package kr.ac.kopo.day17;


/*
 * 쓰레드 구성 2가지 방식
 * 1. Thread 클래스를 상속 받아서 구현
 * 2. runnable 인터페이스를 상속 받아서 구현
 */


// 1-1. 인형 눈 붙이는 작업 => Thread 클래스를 상속 받아서 구현
class ExtendThread extends Thread {

	@Override
	public void run() {
		for(int i = 0; i < 100; i++) {
			System.out.println(i+1 + "번째 인형 눈 붙이기...");
		}
	}
	
}

// 2-1. 인형코 붙이는 작업 => runnable 인터페이스를 상속 받아서 구현
class ImplementThread implements Runnable {

	@Override
	public void run() {
		for(int i = 0; i < 100; i++) {
			System.out.println(i+1+ "번째 인형코 만들기...");
		}
	}
	
}


public class ThreadMain02 {
	public static void main(String[] args) {
		
		// 1-2. Thread 클래스를 상속 받아서 구현한 쓰레드 실행
		ExtendThread et = new ExtendThread();
		et.start();
		
		// 2-2. runnable 인터페이스를 상속 받아서 구현한 쓰레드 실행
		ImplementThread it = new ImplementThread();
		Thread t = new Thread(it);
		t.start();
		
		// 3. 
		for(int i = 0; i< 100; i++) {
			System.out.println(i+1+"번째 감독중...");
		}
		
		/*
		
		<왜 위의 코드 "감독중"은 쓰레드가 모두 종료된 뒤 실행되지 않고, 쓰레드처럼 작동할까?>
		
		우리가 만드는 자바는 기본적으로 1 프로세스, 1 쓰레드이다. 
		
		그 1 쓰레드가 바로 우리가 실행하는 메인이다. 
		
		그래서 전체 코드를 수행하게 되면, 
			1. 메인 쓰레드 (감독중)
			2. ExtendThread (눈 작업)
			3. ImplementThread (코 작업)
		총 3개의 쓰레드가 실행되는 것이다. 
		 
		 */
	}
}
```

## 3. Thread의 상태

![image](https://user-images.githubusercontent.com/77392444/119445540-f1be6500-bd67-11eb-8d8e-20396ee90f82.png)


- `sleep()` : 일정한 시간만큼 block 상태에 빠지게 하는 것이다. 

  - Thread.sleep은 checked exception 이다.
  - Thread에 정의된 sleep 메소드가 throws Exception을 던지고 있는 것이다. 
  - io, 쓰레드, 소켓, 네트워크 등은 모두 checked exception 이다.

- `join()` : 어떤 특정한 쓰레드가 종료하기 전까지는 block 상태에서 빠져나오지 않는 것이다. 

- `wait()`, `sync()` : 동기화와 관련된 메소드

- block 상태에 빠지지 않으면 무조건 Runnable 상태에서 대기한다. 

#### 3.1 sleep() 메소드로 2초 동안 block 시키기

```JAVA
package kr.ac.kopo.day17;

public class SleepMain01 {
	public static void main(String[] args) {
		
		System.out.println("Thread가 2초동안 잠이 들겠습니다.");
		
		try {
			Thread.sleep(2000); // 단위는 밀리세컨드(1000밀리세컨드 = 1초)
		} catch (InterruptedException e) {
			e.printStackTrace();
		} 
		// Thread.sleep은 checked exception 이다. => Thread에 정의된 sleep 메소드가 throws Exception을 던지고 있는 것이다. 
		// io, 쓰레드, 소켓, 네트워크 => checked exception 
		
		System.out.println("Thread가 깨어났습니다.");
	}
}
```

#### 3.2 sleep을 통해 두 쓰레드를 번갈아서 수행시키기

```java
package kr.ac.kopo.day17;

import java.util.Date;

// 1초에 한 번씩 시간을 출력하는 Thread
class TimeThread extends Thread {

	@Override
	public void run() {
		while(true) {
			
			// 1초동안 block
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			} 
			System.out.println("현재시간 : " + new Date().toLocaleString());
		}
	}
	
	
}

public class SleepMain02 {
	public static void main(String[] args) {
		
		// 1초마다 시간을 찍어주는 쓰레드 실행
		TimeThread tt = new TimeThread();
		tt.start();
		
		/*
		while(true) {
			System.out.println("go!!!!!!!");
		}
		
		위의 메소드를 실행하면 go 찍어내고 sleep에 빠진 다음 현재시간을 찍지 못하고 계속 sleep에 빠져 go만 출력하게 된다. 
		
		그래서 둘을 동시에 수행시키려면, go 출력 쓰레드에도 sleep을 적절히 걸어줘야 한다. 
		
		
		*/
		while(true) {
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("go!!!!!!!");
		}
		
	}
}
```

#### 

## 4. 쓰레드의 우선순위

- 쓰레드마다 자신의 우선순위를 가지고 있다. (= Priority)

- 디폴트 우선순위는 1(lowest) ~ 10(highest) 중에서 5이다. 

- 우선순위는 순서의 우선순위를 보장하는 것이 아니고, 확률이 높은 것이다.

- 만약 우선순위 높은 순으로 먼저 수행된다면, 우선 순위가 낮은 쓰레드는 실행될 수 없기 때문이다. 

- `setPriority(int priority)`를 통해 설정하고, `getPriority()`를 통해 알아낸다.

- 쓰레드의 이름은 `setName(String name)`를 통해 설정하고, `getName()`를 통해 반환한다. 
