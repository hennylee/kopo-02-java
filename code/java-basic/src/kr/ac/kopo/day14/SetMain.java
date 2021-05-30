package kr.ac.kopo.day14;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class SetMain {

	public static void main(String[] args) {
		
//		Set<String> set = new HashSet<>();
		Set<String> set = new TreeSet<>();
		
		set.add("one");
		set.add("two");
		set.add("three");
		set.add("four");
		set.add("five");
		
		// add의 반환형은 boolean형으로 add 성공 or 실패 여부를 반환한다.
		// 중복 데이터는 add되지 않는다.
		boolean bool = set.add("five");
		System.out.println("\"five\"의 데이터 삽입 여부 :" + (bool? "성공" : "실패"));
		
		/*
		 * Set의 전체 데이터 출력하는 방식
		 * 
		 * set은 사전 순으로 출력된다.(a - z)
		 * 
		 * 1. 1.5버전의 for문(forEach)는 사용할 수 있다. : 출력만 가능
		 * 2. iterator() 메소드 이용 : 출력만 가능
		 * 3. toArray() 메소드 이용 : 배열로 변환해서 
		 */
		
		System.out.println("< 1.5버전의 for문 이용 출력 >");
		for(String s : set) {
			System.out.println(s); 		// 순서 없이 중복값은 제거하고 출력된다. 
		}

		System.out.println("< Iterator() 이용 출력 >");
		Iterator<String> ite = set.iterator();
		
		while(ite.hasNext()) {
			System.out.println(ite.next());
		}
		
		System.out.println("< toArray() 이용 출력 >");
		Object[] arr = set.toArray();
		System.out.println(Arrays.toString(arr));
	}

}
