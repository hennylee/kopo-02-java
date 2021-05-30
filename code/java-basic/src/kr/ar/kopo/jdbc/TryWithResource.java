package kr.ar.kopo.jdbc;

/**
 * 1.7버전의 try ~ catch ~ resource 문을 사용해보기
 * @author HP
 *
 */


class Test implements AutoCloseable {

	// AutoCloseable을 상속받으면 try ~ catch가 끝나면 자동으로 무조건 close() 메소드가 호출된다. 
	@Override
	public void close() throws Exception {
		System.out.println("close()...");
	}
	
}

public class TryWithResource {
	public static void main(String[] args) {
		
		try (
				Test t = new Test();
		) {
			
		} catch (Exception e) {
			
		}
		
	}
}
