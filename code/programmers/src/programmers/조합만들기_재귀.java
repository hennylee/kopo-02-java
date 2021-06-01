package programmers;

public class 조합만들기_재귀 {
/*
depth 변수는 현재 인덱스. 0부터 시작한다.


현재 인덱스를 뽑는다면 = true, 뽑지 않는다면 visited[depth] = false로 진행한다.
 

마찬가지로 뽑은 경우와 뽑지 않은 경우 모두 봐야 하고, 그때 이전에 본 값들은 더 이상 고려 대상이 아니기 때문에 depth 은 무조건 1 씩 증가한다.
 

depth == n 이 되면 모든 인덱스를 다 보았으므로(배열의 끝에 도착 -> 조합 만들 수 X) 재귀를 종료한다.
 

또한 r == 0이 되면 뽑을 개수를 다 뽑아 조합이 완성되으니 재귀를 종료한다.
 */
	
	// 2. 재귀를 이용해 구현
	static void comb2(int[] arr, boolean[] visited, int depth, int r) {
		if (r == 0) {
			print(arr, visited);
			return;
		}
		if (depth == arr.length) {
			return;
		} else {
			visited[depth] = true;
			comb2(arr, visited, depth + 1, r - 1);

			visited[depth] = false;
			comb2(arr, visited, depth + 1, r);
		}
	}

	
	// 배열 출력
	static void print(int[] arr, boolean[] visited) {
		for (int i = 0; i < arr.length; i++) {
			if (visited[i] == true)
				System.out.print(arr[i] + " ");
		}
		System.out.println();
	}

	
	// Main
	public static void main(String[] args) {
		int[] arr = { 1, 2, 3 , 4, 5 }; // 조합을 만들 배열
		boolean[] visited = new boolean[arr.length];

		// 2. 재귀를 이용해 구현
		System.out.println("\n---------- 2. 재귀 ----------");

		for (int r = 1; r <= arr.length; r++) {
			System.out.println("\n" + arr.length + "개 중에 " + r + "개 뽑음");
			comb2(arr, visited, 0, r);
		}
	}

}
