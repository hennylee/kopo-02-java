package kr.ac.kopo.day14;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class ListMain {

	public static void main(String[] args) {
		
		List oldList01 = new ArrayList();					// JDK1.5 미만의 방식
		
		List<String> odList02 = new ArrayList<String>();	// 1.5버전의 Generic을 사용한 방식
		
		List<String> list = new ArrayList<>();				// 1.7버전 이후의 Generic
		
		list.add("one");
//		list.add(10);	==> 컴파일 시점의 error!
		list.add("two");
		list.add("three");
		list.add("four");
		
		System.out.println("리스트의 원소 총 갯수 : " + list.size());
		
		System.out.println("==========================================================================");
		
		/*
		 * List의 전체 데이터를 출력하는 방법
		 * 
		 * 1. index를 이용한 get메소드를 활용하기
		 * 2. 1.5버전의 for문을 이용하기 (forEach)
		 * 3. toArray() 메소드 이용하기
		 * 4. iterator를 활용하기
		 */
		
		
		System.out.println("< get() 메소드를 이용한 출력 >");
		
		for(int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));	// 입력된 순서 그대로 출력이 된다
		}
		
		
		
		System.out.println("< 1.5버전의 for문을 이용한 출력 >");
		
		for(String str : list) {
			System.out.println(str);
		}
		
		
		
		System.out.println("< toArray() 메소드를 이용한 출력 >");	 // toArray() : 리스트가 가지고 있는 모든 요소를 고정된 배열에 저장
		
		Object[] objArr = list.toArray();
		System.out.println(objArr); 						 // 배열 주소값 출력
		System.out.println(Arrays.toString(objArr));		 // 값 출력
		
		

		System.out.println("< iterator() 메소드를 이용한 출력 >");  // 순환자 : 접근하도록 만들어진 객체(=enumerate)
		Iterator<String> ite = list.iterator();
		
		while (ite.hasNext()) {
			System.out.println(ite.next());
		}
		
		System.out.println("==========================================================================");
		
		// contains()
		String searchStr = "two";
		
		if(list.contains(searchStr)) {
			System.out.println(searchStr + "은 존재합니다.");
		} else {
			System.out.println(searchStr + "은 존재하지 않습니다.");
		}
		
		// remove()
		boolean bool = list.remove("two");
		System.out.println("remove : " + bool);
		
		while (bool) {
			System.out.println("삭제되었습니다.");
			break;
		}
		
		String removeStr = list.remove(0);
		System.out.println("remove(0) 후 첫번째 문자열 : " + list.get(0));
		
		
		// clear()
		System.out.println("원소 총갯수 : " + list.size());
		list.clear();
		System.out.println("claer 후 원소 총갯수 : " + list.size());
		
		// LinkedList
		List<String> sub = new LinkedList<>();
		sub.add("여름");
		
		list.addAll(sub);
		System.out.println();
		
		
		
	}

}
