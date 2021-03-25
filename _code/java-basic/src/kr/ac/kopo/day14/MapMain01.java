package kr.ac.kopo.day14;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;

/*
 * 
 */
public class MapMain01 {

	public static void main(String[] args) {
		
		// ID를 KEY로 PW를 Value로 저장하기 
		Map<String, String> map = new HashMap<>();
		map.put("aaa", "1111");
		map.put("bbb", "2222");
		map.put("ccc", "3333");
		map.put("ddd", "4444");
		
		
		System.out.println("=============================================================================");
		/*
		 * Map의 전체 데이터를 출력하는 방법
		 * 
		 * List, Set과는 다른 방법이 필요하다.
		 * 
		 * 1. entrySet()
		 */
		
		System.out.println("<< 전체 회원 정보 출력 >>");
		
		// entrySet() 메소드 활용하기
//		Set<Map.Entry<String, String>> set = map.entrySet(); ==> Map.Entry를 Entry로 쓰려면 import java.util.map.Entry하면 된다.
		Set<Entry<String, String>> set = map.entrySet();
		
		for(Entry<String, String> entry :set) {
			System.out.println("ID : " + entry.getKey() + ", PW : " + entry.getValue());
		}
		
		System.out.println("-------------------------------------------------------");
		
		// keySet() 메소드 활용하기
		Set<String> keys = map.keySet();
		for(String key: keys) {
			System.out.print("ID : " + key);
			System.out.println(", PW : " + map.get(key));
			
		}
		
		System.out.println("=============================================================================");
		
		
		Scanner sc = new Scanner(System.in);
		System.out.println("<< 패스워드 변경 서비스 입니다 >>");
		System.out.println("ID를 입력하세요 : ");
		String id = sc.nextLine();
		
		if(!map.containsKey(id)) {
			System.out.println("입력하신 ID [" + id + "] 는 존재하지 않습니다.");
			System.out.println("서비스를 종료합니다.");
			System.exit(0);
		}
		System.out.println("현재 패스워드를 입력하세요 : ");
		String password = sc.nextLine();
		
		
		if(!map.get(id).equals(password)) {	// 문자열 비교할때는 equals로 비교해야 한다.
			System.out.println("패스워드가 다릅니다.");
			System.out.println("서비스를 종료합니다.");
			System.exit(0);
		}
		System.out.println("변경할 패스워드를 입력하세요 : ");
		String newPassword = sc.nextLine();
		map.put(id, newPassword);
		
		System.out.println("패스워드가 변경되었습니다.");
		
		
		
	}

}
