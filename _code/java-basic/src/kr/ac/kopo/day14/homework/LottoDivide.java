package kr.ac.kopo.day14.homework;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class LottoDivide {
	
	Random random = new Random();
	
	// 앞
	List<Integer> front(int num) {
		List<Integer> frontList = new ArrayList<Integer>();
		
		while(frontList.size() < 3) {
			int start = 1;
			int end = num - 1;
			
			num = random.nextInt(end) + start;
			frontList.add(num);
			front(num);
		}
		return frontList;
	}
	
	// 뒤
	List<Integer> end(int num) {
		List<Integer> endList = new ArrayList<Integer>();
		
		while(endList.size() < 3) {
			int start = num + 1;
			int end = 46;
			num = random.nextInt(end - start) + start;
			endList.add(num);
			end(num);
		}
		return endList;
	}
	
	public static void main(String[] args) {
		LottoDivide ld = new LottoDivide();
		
		Random random = new Random();
		int start = 1;
		int end = 46;
		
		
		int num = random.nextInt(end) + start;
		
		List<Integer> list = new ArrayList<Integer>();

		List<Integer> frontList = ld.front(num);
		List<Integer> endList = ld.end(num);
		
		list.addAll(frontList);
		list.addAll(endList);
		
		System.out.println(Arrays.toString(list.toArray()));
		
		
	}

}
