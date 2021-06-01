package programmers;

public class 조합만들기_백트래킹 {
/*
start 변수는 기준이다.

start를 기준으로 start 보다 작으면 뽑을 후보에서 제외, start  보다 크면 뽑을 후보가 된다.

 

예를 들어 [1, 2, 3] 배열이 있고 start 가 0부터 시작한다.

조합을 뽑는 comb 함수에 들어오면 먼저 i 정점부터 시작하는 for 문에 들어간다.

 

만약 0 인덱스에 있는 값 1을 뽑는다면 visited [i]는 true가 되고, 뽑지 않는다면 visited[i] 는 false가 된다.

즉, 1을 선택한 경우(visited[i] = true)와 선택하지 않은 경우(visited[i] = false) 둘 다 봐야 한다.

 

하지만 더 이상 1은 고려 대상이 아니기 때문에 다음 for 문은 2부터 즉, i + 1부터 시작해주어야 한다.
 */
	
	
	// 1. 백트래킹을 이용해 구현
	static void comb1(int[] arr, boolean[] visited, int start, int r) {
		
		if (r == 0) {
			print(arr, visited);
			return;
		} else {
			for (int i = start; i < arr.length; i++) {
				visited[i] = true;
				comb1(arr, visited, i + 1, r - 1);
				visited[i] = false;
			}
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

	
	public static void main(String[] args) {
		int[] arr = { 1, 2, 3 , 4, 5 }; // 조합을 만들 배열
		boolean[] visited = new boolean[arr.length]; 

		// 1. 백트래킹을 이용해 구현
		System.out.println("-------- 1. 백트래킹 ---------");

		for (int r = 1; r <= arr.length; r++) {
			System.out.println("\n" + arr.length + "개 중에 " + r + "개 뽑음");
			comb1(arr, visited, 0, r);
		}

	}

}
