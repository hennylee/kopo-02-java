package kr.ac.kopo.day14.homework;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

import javax.sql.rowset.JoinRowSet;

public class LottoUtil {
	Random r = new Random();
	
	/**
	 * Set
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
		
		//System.out.println(Arrays.toString(set.toArray()));
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
		
		//System.out.println(Arrays.toString(list.toArray()));
	}
	
	
	
	/**
	 * ArrayList
	 * 1. a 추출
	 * 
	 * 2. [1 ~ (a-1)]에서 b 추출
	 * 
	 *	2-1. [1 ~ (b-1)] 에서 d추출
	 *	2-2. [(b+1) ~ (a-1)] 에서 e추출
	 *
	 * 3. [(a+1) ~ 45]에서 c 추출
	 * 
	 * 	3-1. [(a+1) ~ (c-1)]에서 f추출
	 * 	3-2. [(c+1) ~ 45] 에서 g추출
	 * 
	 */
	
	public void lottoDivide() {
		
		
		
	}
	
	
	
	
	
	
	public void randomLotto() {
		
		
	}
	
	
	
	/**
	 * 배열로 풀기
	 */
	public void lottoMap() {
		
	}
	

}
