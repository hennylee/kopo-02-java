package kr.ac.kopo.day14.homework;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.Random;
import java.util.Set;

import javax.sql.rowset.JoinRowSet;

public class LottoUtil {

	/**
	 * Set
	 * 중복값 제거하고 랜덤으로 난수 6개 추출하기
	 */
	public void lottoSet() {
		Set<Integer> set = new HashSet<>();
		int num;
		int bound;
		
		Random r = new Random();
		bound = 45;
		
		while(set.size() < 6) {
			num = r.nextInt(bound)+1;
			set.add(num);
		}
		
		System.out.println(Arrays.toString(set.toArray()));
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
		// 1- 45 사이의 수 6개 추출하기
		int[] Nums = new int[45];
		
		for(int i = 0; i < 45; i++) {
			Nums[i] = i+1;
		}
		
		// 랜덤으로 배열 index 추출
		Random r = new Random();
		
		int bound = 45;
		int firstNum = r.nextInt(bound) + 1;
		
		System.out.println(firstNum);
		
		// 해당 배열 index의 숫자를 0으로 바꾸기
		for(int i = 0; i < Nums.length; i++) {
			if(Nums[i] == firstNum)
				Nums[i] = 0;
		}
		
		// 배열 방의 값이 0이 아닌 index들 중에서 하나 추출?
		
	}
	
	
	
	/**
	 * 배열로 풀기
	 */
	public void lottoMap() {
		
	}
	

}
