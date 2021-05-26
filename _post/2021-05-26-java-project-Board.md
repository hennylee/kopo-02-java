

## 1. 패키지 구성

```
흐름 : `UI`가 `Service` 호출 ➡️ `Service`가 `DAO` 호출
```

#### 1. UI : 콘솔창
- 키보드로 입력받기

- 결과 출력하기

#### 2. VO : 한 개 또는 그 이상의 속성들을 묶어서 특정 값을 나타내는 객체

- 게시물 속성 객체

#### 3. DAO : 데이터를 관리

- 게시판의 게시물을 수정, 삭제, 조회, 생성

#### 4. Service : 비즈니스 로직 처리
- 오늘 날짜로 ID가 HONG인 애가 무슨 물품을 주문했는지 알아오려면?
- CustomerDAO 가서는 내가 원하는 회원정보 알아오고, ProductDAO 에서는 10, 11, 12 번 물품에 대한 정보 알아와야 한다.
- 이렇게 여러개의 DAO에서 정보를 알아와서 처리하는 기능을 담당하는 것이 Service이다.


## 2. 콘솔창으로 CRUD 기능 구현해보기

- 게시물은 RAM에만 저장되기 때문에, 서버가 종료되면 게시물 데이터는 사라진다. 

### 2.1. UI : 콘솔창

#### IBoardUI : 인터페이스

```java
package kr.ac.kopo.ui;

public interface IBoardUI {
	
	/**
	 *  메뉴를 실행하는 메소드
	 * @throws Exception
	 */
	public void execute() throws Exception;
	
}
```

#### BaseUI : 추상클래스

```java
package kr.ac.kopo.ui;
/**
 * 매번 Scanner 쓰는 것 귀찮으니까 만들어둔 클래스이다.
 * @author HP
 *
 */

import java.util.Scanner;

import kr.ac.kopo.service.BoardService;
import kr.ac.kopo.service.BoardServiceFactory;

/*
	[abstract class]
	
	IBoardUI 인터페이스를 상속받으면 인터페이스 내의 메소드를 구현해야 하지만, 
	BaseUI 내에서는 해당 메소드를 구현할 필요가 없다. 
	그래서 추상클래스로 만들어줌으로써, 상속받은 인터페이스의 메소드를 구현하지 않아도 되게 만들어줘야 한다. 
 */


public abstract class BaseUI implements IBoardUI{
	
	private Scanner sc = new Scanner(System.in);
	protected BoardService service; // BaseUI를 상속받는 모든 UI클래스가 Service객체를 필요로 하게 때문에 멤버변수로 갖는다. 
	
	public BaseUI() {
		sc = new Scanner(System.in);
		
		/*
		 *  service가 계속 new키워드로 생성되면 list를 기억할 수 없기 때문에 한번만 생성해주는 메소드를 만들어서 실행한다. 
		 */
		service = BoardServiceFactory.getInstance(); 
	}
	
	
	protected String scanStr(String msg) { // 같은 패키지 아니어도 상속받은 클래스 내에서만 쓰고 싶다면? => protected
		System.out.print(msg);
		String str = sc.nextLine();
		return str;
	}
	
	protected int scanInt(String msg) {
		int num = Integer.parseInt(scanStr(msg));// scanStr(String msg)으로 입력받은 것을 정수로 파싱
		return num;
	}
}
```

#### BoardUI : 전체 메뉴

```java
package kr.ac.kopo.ui;
/**
 * 기능에 대한 집합인 기능클래스이다. 
 * 실행하기 위해 Execute 메소드가 필요하다.
 * @author HP
 *
 */
public class BoardUI extends BaseUI{

	@Override
	public void execute() throws Exception {
		while(true) {
				try {
				
				/*
				모든 메뉴는 IBoardUI 인터페이스에 있는 execute() 메소드를 실행한다. 
				모든 메뉴는 IBoardUI인터페이스를 상속받고 있기 때문에 묵시적 형변환을 사용해서 execute()를 한번만 실행하도록 할 수 있다. 
				 */
				IBoardUI ui = null;
				
				int type = menu();
				
				switch (type) {
				case 1:
					ui = new SearchAllUI();
					break;
				case 2:
					ui = new SearchOneUI();
					break;
				case 3:
					ui = new AddUI();
					break;
				case 4:
					ui = new UpdateUI();
					break;
				case 5:
					ui = new DeleteUI();
					break;
				case 0:
					ui = new ExitUI();
					break;
				}
				if(ui != null) {
					/*
					ui는 묵시적 형변환으로 각 메뉴의 UI 클래스를 받는다. 
					 */
					ui.execute();
				}else {
					System.out.println("잘못 입력하였습니다.");
				}
			
			} catch (Exception e) {
				System.out.println("BoardUI Catch...");
				e.printStackTrace();
			}
		}
	}
	
	private int menu() {
		System.out.println("-------------------------------");
		System.out.println("\t게시판 관리 프로그램");
		System.out.println("-------------------------------");
		System.out.println("\t1. 전체 게시글 조회");
		System.out.println("\t2. 글번호 조회");
		System.out.println("\t3. 새글 등록");
		System.out.println("\t4. 게시글 수정");
		System.out.println("\t5. 게시글 삭제");
		System.out.println("\t0. 종료");
		System.out.println("-------------------------------");
		int type = scanInt("메뉴 중 원하는 항목을 선택하세요 : ");
		
		return type;
	}

}
```

#### AddUI

```java
package kr.ac.kopo.ui;

import kr.ac.kopo.vo.BoardVO;

public class AddUI extends BaseUI{

	@Override
	public void execute() throws Exception {
		String title = scanStr("등록할 제목을 입력하세요 : ");
		String writer = scanStr("등록할 글쓴이를 입력하세요 : ");
		
		BoardVO newBoard = new BoardVO();
		newBoard.setTitle(title);
		newBoard.setWriter(writer);
		
		service.새글등록서비스(newBoard);
		
		System.out.println("게시글 등록을 완료하였습니다.");
		
	}

}
```


#### DeleteUI.java

```java
```

#### ExitUI.java

```java
package kr.ac.kopo.ui;

public class ExitUI extends BaseUI{

	@Override
	public void execute() throws Exception {
		
		System.out.println("=======================================");
		System.out.println("\n\t게시판 관리프로그램을 종료합니다.\n");
		System.out.println("=======================================");
		System.exit(0);
	}
}
```

#### SearchAllUI.java

```java
package kr.ac.kopo.ui;

import java.util.List;

import kr.ac.kopo.vo.BoardVO;

public class SearchAllUI extends BaseUI {

	@Override
	public void execute() throws Exception {
		
		List<BoardVO> list = service.전체게시글조회서비스();
		
		System.out.println("----------------------------------------");
		System.out.println("\t전체 게시글 조회");
		System.out.println("----------------------------------------");
		System.out.println("번호\t글쓴이\t등록일\t제목");
		System.out.println("----------------------------------------");
		
		// 게시글 목록 출력
		if(list.size() == 0 || list.isEmpty()) {
			System.out.println("조회할 게시물이 없습니다.");
		} else {
			for(BoardVO vo : list) {
				System.out.println(vo.getNo() + "\t" + vo.getWriter() + "\t"
						   			+ vo.getRegDate() + "\t" + vo.getTitle());
			}
		}
		
		System.out.println("----------------------------------------");
	}
}
```

#### SearchOneUI.java

```java
```

#### UpdateUI.java

```java
```

### 2.2. VO : 한 개 또는 그 이상의 속성들을 묶어서 특정 값을 나타내는 객체

#### BoardVO.java

```java
package kr.ac.kopo.vo;

public class BoardVO {
	private int no;
	private String title;
	private String writer;
	private String regDate;
	
	public BoardVO() {
		
	}
	public BoardVO(int no, String title, String writer, String regDate) {
		super();
		this.no = no;
		this.title = title;
		this.writer = writer;
		this.regDate = regDate;
	}
	
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getRegDate() {
		return regDate;
	}
	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}
	
	@Override
	public String toString() {
		return "BoardVO [no=" + no + ", title=" + title + ", writer=" + writer + ", regDate=" + regDate + "]";
	}
}
```

### 2.3. DAO : 데이터를 관리

#### BoardDAO.java

```java
package kr.ac.kopo.dao;
import java.util.ArrayList;
import java.util.List;

/**
 * 게시판들을 관리하는 것이 목적이다.
 * @author HP
 *
 */
import kr.ac.kopo.vo.BoardVO;

/**
 * 램에서 게시물 관리하는 DAO
 * @author HP
 *
 */
public class BoardDAO {
	private List<BoardVO> list;
	
	public BoardDAO() {
		list = new ArrayList<>();
	}
	
	/**
	 * 전체 게시글 조회
	 * @return
	 * @throws Exception
	 */
	public List<BoardVO> 전체게시글조회() throws Exception {
		System.out.println();
		return list;
	}
	
	/**
	 * 글번호로 게시글 조회
	 * @param no
	 * @return
	 * @throws Exception
	 */
	public BoardVO 글번호조회(int no) throws Exception {
		for(BoardVO board : list) {
			if(board.getNo() == no) {
				return board;
			}
		}
		// 게시물이 없는 경우 처리
		return null;
	}
	
	/**
	 * 새글 등록
	 * @param newBoard
	 */
	public void 새글등록(BoardVO newBoard) {
		list.add(newBoard);
		System.out.println("dao : " + newBoard);
	}
	
	/**
	 * 게시글 수정
	 * @param board : 제목과 글번호만 수정하면 되지만, 
	 * 만약 수정할 항목이 늘어날 경우에 대비해서 유연하게 코드를 짜기 위해 매개변수를 BoardVO로 잡은 것이다.
	 */
	public void 게시글수정(BoardVO board) { 
		for(BoardVO vo : list) {
			if(vo.getNo() == board.getNo()) {
				vo.setTitle(board.getTitle());
				return;
			}
		}
	}
	
	/**
	 * 게시물 삭제
	 * @param no
	 */
	public void 게시글삭제(int no) {
		for(BoardVO vo : list) {
			if(vo.getNo() == no) {
				list.remove(vo);
				return;
			}
		}
	}
}
```

### 2.4. Service : 비즈니스 로직 처리

#### BoardSequence.java

```java
package kr.ac.kopo.service;

public class BoardSequence {
	private static int no = 1;
	
	/*
	여러명이 동시에 글을 작성할 때, 번호 증가가 이루어지는 동안 다른 사람의 글번호가 증가하지 않도록 하기 위해 동기화 블록을 설정해준다.
	 */
	public static synchronized int getNo() {
		return BoardSequence.no++;
	}
}
```


#### BoardService.java

```java
package kr.ac.kopo.service;

import java.util.List;

import kr.ac.kopo.dao.BoardDAODB;
import kr.ac.kopo.vo.BoardVO;

public class BoardService {
	
	/*
	서비스는 dao들을 조합하여 실행하여야 하기 때문에, 멤버변수로 dao의 각 객체들을 가지게 만든 것이다.
	 */
	private BoardDAO dao;
	//private BoardDAODB dao;
	
	public BoardService() {
		dao = new BoardDAO();
		//dao = new BoardDAODB();
	}
	
	public void 새글등록서비스(BoardVO newbBoard) throws Exception{
		
		/*
		// 등록할 게시물 번호 추출
		newbBoard.setNo(BoardSequence.getNo());
		
		// 등록 날짜 추출 (현재시간)
		String pattern = "yyyy-MM-dd hh:mm:ss";
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		newbBoard.setRegDate(sdf.format(new Date()));
		*/
		
		dao.새글등록(newbBoard);
	}
	
	public List<BoardVO> 전체게시글조회서비스() throws Exception{
		List<BoardVO> list = dao.전체게시글조회();
		return list;
	}
}
```


#### BoardServiceFactory.java

```java
package kr.ac.kopo.service;

public class BoardServiceFactory {
	private static final BoardService service = new BoardService(); // 맨처음엔 null 값을 갖는다.
	
	public static BoardService getInstance() {
		/*
		if(service == null) {
			service = new BoardService();
		}
		*/
		return service;
	}
}
```




## 3. Oracle DB로 CRUD 기능 구현해보기

### 3.0 Orcale : 테이블 생성

```sql
-- 게시판(자바콘솔)
CREATE TABLE tbl_board(
    no number(5) primary key,
    title varchar2(100) not null,
    writer varchar2(100) not null,
    reg_date date default sysdate
);

-- 게시판 일련번호 생성
create sequence seq_tbl_board_no;
```

### 3.1. UI : 콘솔창

#### IBoardUI : 인터페이스

```java
package kr.ac.kopo.ui;

public interface IBoardUI {
	
	/**
	 *  메뉴를 실행하는 메소드
	 * @throws Exception
	 */
	public void execute() throws Exception;
	
}
```

#### BaseUI : 추상클래스

```java
package kr.ac.kopo.ui;
/**
 * 매번 Scanner 쓰는 것 귀찮으니까 만들어둔 클래스이다.
 * @author HP
 *
 */

import java.util.Scanner;

import kr.ac.kopo.service.BoardService;
import kr.ac.kopo.service.BoardServiceFactory;

/*
	[abstract class]
	
	IBoardUI 인터페이스를 상속받으면 인터페이스 내의 메소드를 구현해야 하지만, 
	BaseUI 내에서는 해당 메소드를 구현할 필요가 없다. 
	그래서 추상클래스로 만들어줌으로써, 상속받은 인터페이스의 메소드를 구현하지 않아도 되게 만들어줘야 한다. 
 */


public abstract class BaseUI implements IBoardUI{
	
	private Scanner sc = new Scanner(System.in);
	protected BoardService service; // BaseUI를 상속받는 모든 UI클래스가 Service객체를 필요로 하게 때문에 멤버변수로 갖는다. 
	
	public BaseUI() {
		sc = new Scanner(System.in);
		
		/*
		 *  service가 계속 new키워드로 생성되면 list를 기억할 수 없기 때문에 한번만 생성해주는 메소드를 만들어서 실행한다. 
		 */
		service = BoardServiceFactory.getInstance(); 
	}
	
	
	protected String scanStr(String msg) { // 같은 패키지 아니어도 상속받은 클래스 내에서만 쓰고 싶다면? => protected
		System.out.print(msg);
		String str = sc.nextLine();
		return str;
	}
	
	protected int scanInt(String msg) {
		int num = Integer.parseInt(scanStr(msg));// scanStr(String msg)으로 입력받은 것을 정수로 파싱
		return num;
	}
}
```

#### BoardUI : 전체 메뉴

```java
package kr.ac.kopo.ui;
/**
 * 기능에 대한 집합인 기능클래스이다. 
 * 실행하기 위해 Execute 메소드가 필요하다.
 * @author HP
 *
 */
public class BoardUI extends BaseUI{

	@Override
	public void execute() throws Exception {
		while(true) {
				try {
				
				/*
				모든 메뉴는 IBoardUI 인터페이스에 있는 execute() 메소드를 실행한다. 
				모든 메뉴는 IBoardUI인터페이스를 상속받고 있기 때문에 묵시적 형변환을 사용해서 execute()를 한번만 실행하도록 할 수 있다. 
				 */
				IBoardUI ui = null;
				
				int type = menu();
				
				switch (type) {
				case 1:
					ui = new SearchAllUI();
					break;
				case 2:
					ui = new SearchOneUI();
					break;
				case 3:
					ui = new AddUI();
					break;
				case 4:
					ui = new UpdateUI();
					break;
				case 5:
					ui = new DeleteUI();
					break;
				case 0:
					ui = new ExitUI();
					break;
				}
				if(ui != null) {
					/*
					ui는 묵시적 형변환으로 각 메뉴의 UI 클래스를 받는다. 
					 */
					ui.execute();
				}else {
					System.out.println("잘못 입력하였습니다.");
				}
			
			} catch (Exception e) {
				System.out.println("BoardUI Catch...");
				e.printStackTrace();
			}
		}
	}
	
	private int menu() {
		System.out.println("-------------------------------");
		System.out.println("\t게시판 관리 프로그램");
		System.out.println("-------------------------------");
		System.out.println("\t1. 전체 게시글 조회");
		System.out.println("\t2. 글번호 조회");
		System.out.println("\t3. 새글 등록");
		System.out.println("\t4. 게시글 수정");
		System.out.println("\t5. 게시글 삭제");
		System.out.println("\t0. 종료");
		System.out.println("-------------------------------");
		int type = scanInt("메뉴 중 원하는 항목을 선택하세요 : ");
		
		return type;
	}

}
```

#### AddUI

```java
package kr.ac.kopo.ui;

import kr.ac.kopo.vo.BoardVO;

public class AddUI extends BaseUI{

	@Override
	public void execute() throws Exception {
		String title = scanStr("등록할 제목을 입력하세요 : ");
		String writer = scanStr("등록할 글쓴이를 입력하세요 : ");
		
		BoardVO newBoard = new BoardVO();
		newBoard.setTitle(title);
		newBoard.setWriter(writer);
		
		service.새글등록서비스(newBoard);
		
		System.out.println("게시글 등록을 완료하였습니다.");
		
	}

}
```


#### DeleteUI.java

```java
```

#### ExitUI.java

```java
package kr.ac.kopo.ui;

public class ExitUI extends BaseUI{

	@Override
	public void execute() throws Exception {
		
		System.out.println("=======================================");
		System.out.println("\n\t게시판 관리프로그램을 종료합니다.\n");
		System.out.println("=======================================");
		System.exit(0);
	}
}
```

#### SearchAllUI.java

```java
package kr.ac.kopo.ui;

import java.util.List;

import kr.ac.kopo.vo.BoardVO;

public class SearchAllUI extends BaseUI {

	@Override
	public void execute() throws Exception {
		
		List<BoardVO> list = service.전체게시글조회서비스();
		
		System.out.println("----------------------------------------");
		System.out.println("\t전체 게시글 조회");
		System.out.println("----------------------------------------");
		System.out.println("번호\t글쓴이\t등록일\t제목");
		System.out.println("----------------------------------------");
		
		// 게시글 목록 출력
		if(list.size() == 0 || list.isEmpty()) {
			System.out.println("조회할 게시물이 없습니다.");
		} else {
			for(BoardVO vo : list) {
				System.out.println(vo.getNo() + "\t" + vo.getWriter() + "\t"
						   			+ vo.getRegDate() + "\t" + vo.getTitle());
			}
		}
		
		System.out.println("----------------------------------------");
	}
}
```

#### SearchOneUI.java

```java
```

#### UpdateUI.java

```java
```

### 2.2. VO : 한 개 또는 그 이상의 속성들을 묶어서 특정 값을 나타내는 객체

#### BoardVO.java

```java
package kr.ac.kopo.vo;

public class BoardVO {
	private int no;
	private String title;
	private String writer;
	private String regDate;
	
	public BoardVO() {
		
	}
	public BoardVO(int no, String title, String writer, String regDate) {
		super();
		this.no = no;
		this.title = title;
		this.writer = writer;
		this.regDate = regDate;
	}
	
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getRegDate() {
		return regDate;
	}
	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}
	
	@Override
	public String toString() {
		return "BoardVO [no=" + no + ", title=" + title + ", writer=" + writer + ", regDate=" + regDate + "]";
	}
}
```

### 3.3. DAO : 데이터를 관리

#### BoardDAODB.java

```java
package kr.ac.kopo.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import kr.ac.kopo.util.ConnectionFactory;
import kr.ac.kopo.util.JDBCClose;
/**
 * 
 * 
 * DB로 게시물을 관리하는 DAO
 * @author HP
 *
 */
import kr.ac.kopo.vo.BoardVO;

public class BoardDAODB {
	
	/**
	 * 전체 게시글 조회
	 * @return
	 * @throws Exception
	 */
	public List<BoardVO> 전체게시글조회() throws Exception {
		
		List<BoardVO> list = new ArrayList<BoardVO>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = new ConnectionFactory().getConnection();
			
			StringBuilder sql = new StringBuilder();
			sql.append("select no, title, writer, to_char(reg_date, 'yyyy-mm-dd') as reg_date ");
			sql.append(" from tbl_board  ");
			
			pstmt = conn.prepareStatement(sql.toString());
			
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				int no = rs.getInt("no");
				String title = rs.getString("title");
				String writer = rs.getString("writer");
				String regDate = rs.getString("reg_date");
				
				BoardVO vo = new BoardVO(no, title, writer, regDate);
				list.add(vo);
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCClose.close(conn, pstmt);
		}
		
		return list;
	}
	
	/**
	 * 글번호로 게시글 조회
	 * @param no
	 * @return
	 * @throws Exception
	 */
	public BoardVO 글번호조회(int no) throws Exception {
		return null;
	}
	
	/**
	 * 새글 등록
	 * @param newBoard
	 */
	public void 새글등록(BoardVO newBoard) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = new ConnectionFactory().getConnection();
			
			StringBuilder sql = new StringBuilder();
			sql.append("insert into tbl_board(no, title, writer) ");
			sql.append("values(seq_tbl_board_no.nextval, ?, ?) ");
			
			pstmt = conn.prepareStatement(sql.toString());
			
			pstmt.setString(1, newBoard.getTitle());
			pstmt.setString(2, newBoard.getWriter());
			
			pstmt.executeUpdate();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCClose.close(conn, pstmt);
		}
	}
	
	/**
	 * 게시글 수정
	 * @param board : 제목과 글번호만 수정하면 되지만, 
	 * 만약 수정할 항목이 늘어날 경우에 대비해서 유연하게 코드를 짜기 위해 매개변수를 BoardVO로 잡은 것이다.
	 */
	public void 게시글수정(BoardVO board) { 
	}
	
	/**
	 * 게시물 삭제
	 * @param no
	 */
	public void 게시글삭제(int no) {
	}
}
```

### 3.4. Service : 비즈니스 로직 처리

#### BoardService.java

```java
package kr.ac.kopo.service;

import java.util.List;

import kr.ac.kopo.dao.BoardDAODB;
import kr.ac.kopo.vo.BoardVO;

public class BoardService {
	
	/*
	서비스는 dao들을 조합하여 실행하여야 하기 때문에, 멤버변수로 dao의 각 객체들을 가지게 만든 것이다.
	 */
	//private BoardDAO dao;
	private BoardDAODB dao;
	
	public BoardService() {
		//dao = new BoardDAO();
		dao = new BoardDAODB();
	}
	
	public void 새글등록서비스(BoardVO newbBoard) throws Exception{
		
		/*
		// 등록할 게시물 번호 추출
		newbBoard.setNo(BoardSequence.getNo());
		
		// 등록 날짜 추출 (현재시간)
		String pattern = "yyyy-MM-dd hh:mm:ss";
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		newbBoard.setRegDate(sdf.format(new Date()));
		*/
		
		dao.새글등록(newbBoard);
	}
	
	public List<BoardVO> 전체게시글조회서비스() throws Exception{
		List<BoardVO> list = dao.전체게시글조회();
		return list;
	}
}
```


#### BoardServiceFactory.java

```java
package kr.ac.kopo.service;

public class BoardServiceFactory {
	private static final BoardService service = new BoardService(); // 맨처음엔 null 값을 갖는다.
	
	public static BoardService getInstance() {
		/*
		if(service == null) {
			service = new BoardService();
		}
		*/
		return service;
	}
}
```


