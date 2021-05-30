package kr.ac.kopo.day14.homework;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import java.util.Set;

public class LottoUtil {
	
	Random r = new Random();
	
	
	/**
	 * hashSet
	 * 중복값 제거하고 랜덤으로 난수 6개 추출하기
	 */
	public void lottoSet() {
		Set<Integer> set = new HashSet<>();
		int num;
		int bound;
		
		
		bound = 45;
		
		while(set.size() < 6) {
			num = r.nextInt(bound)+1;
			set.add(num);
		}
		
		
		System.out.println(Arrays.toString(set.toArray()));
	}
	
	/**
	 * ArrayList
	 * contain하면 계속 난수 추출하고
	 * 아니면 넣기
	 */
	public void lottoArrayList() {
		List<Integer> list = new ArrayList<Integer>();
		
		while(list.size() < 6) {
			
			int num = r.nextInt(45) + 1;
			
			if(list.contains(num)) {
				continue;
			}else {
				list.add(num);
			}
		}
		
		System.out.println(Arrays.toString(list.toArray()));
	}
	
	
	
	/**
	 * hashMap으로 풀기
	 * 
	 */
	public void lottoMap() {
		Map<Integer, Integer> map = new HashMap<>();
		int i = 1;
		
		while(i <= 6) {			
			int num = r.nextInt(46)+1;
			if(map.containsValue(num)) {
				continue;
			} else {
				map.put(i, num);
				i++;
			}
			
		}
		
		
		  Set<Entry<Integer, Integer>> entries = map.entrySet();
		  for(Entry<Integer,Integer> entry: entries) { 
		  		System.out.print(entry.getValue() + " "); 
		  }
		  System.out.println();
		 
		
	}
	
	/**
	 * Array로 풀기
	 * 
	 */
	public void lottoArray() {
		int[] lottoArr = new int[6];
		
		for(int i=0; i < lottoArr.length; i++) {
			lottoArr[i] = r.nextInt(46)+1;
		
			for(int j = 0; j < i; j++) {
				if(lottoArr[j] == lottoArr[i]) {
					i--;
				}
			}
			
		}
		

		// 중복 확인
		boolean check = true;
		
		for(int i = 1; i < lottoArr.length; i++) {
			
			for(int j = 0; j < i; j++) {
				if(lottoArr[i] == lottoArr[j]) check = false;
			}
		}
		
		System.out.println(Arrays.toString(lottoArr) + " " + check);
	}
	

}
