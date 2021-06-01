package programmers;

import java.util.Arrays;

public class 조합만들기 {
	/*
	 * int[] arr : 원래 배열 
	 * 
	 * boolean[] visited : 방문했던지 확인
	 * 
	 * int start : 시작점
	 *  
	 * int num : 뽑을 조합 갯수
	 */
	
	static void combination(int[] arr, boolean[] visited, int start) {
		
		for (int i = start; i < arr.length; i++) {
			visited[i] = true;
			combination(arr, visited, i + 1);
			visited[i] = false;
		}
		
		
	}
	
	
	public static void main(String[] args) {
		int[] arr = {1, 2, 3, 4, 5};
		boolean[] visited = new boolean[arr.length];
		
		System.out.println(Arrays.toString(visited));
		
		combination(arr, visited, 0);
	}
}
