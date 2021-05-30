package kr.ac.kopo.day09;

public class StringMain06 {

	public static void main(String[] args) {
		
		// String 형변환 =========================================================================
		int num = 123;
		
		// String strNum = num + ""; ======> 야매 방식
		String strNum = String.valueOf(num);
		
		System.out.println(strNum + 10);
		System.out.println(String.valueOf(false)+true);
		
		// String은 형변환 일어나나...?
		System.out.println("true" + false);
		
		
		
		
		// String은 변환하는 문자열을 처리하기에 시간이 너무 오래 걸린다 =====================================
		System.out.println("=====================        String         ==================");
		long start = System.currentTimeMillis();
		
		String str = "";
		
		for(int i = 0; i < 100000; i++) {
			str += i;
			str = str.concat(String.valueOf(i));
		}
		
		long end = System.currentTimeMillis();
		
		System.out.println("소요 시간  : " + (end - start) / 1000.0 + "초");
		System.out.println(str);
		
		
		
		
		// 변환하는 문자열을 처리할때는 StringBuffer를 사용한다 =====================================
		System.out.println("==================    StringBuffer   ===================");
		start = System.currentTimeMillis();
		
		StringBuffer sb = new StringBuffer();
		for(int i = 0; i < 100000; i++) {
			sb.append(i);
//			sum += i;
		}
		
		end = System.currentTimeMillis();
		
		System.out.println(sb);
		System.out.println("소요 시간  : " + (end - start) / 1000.0 + "초");
	}

}
