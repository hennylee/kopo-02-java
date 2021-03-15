package kr.ac.kopo.day05.homework;

import java.util.Arrays;

/*
	
	2 ~ 100사이의 소수를 출력하는데 교수자가 설명한 규칙으로 코드를 작성할 것!
	
	2 ~ 100까지 저장되어있는 배열방을 만들기!
	
	0번지에 있는 숫자(2)가 소수라면 소수의 배수는 소수일 수 없음
	그럼 1번지부터 마지막까지 돌면서 2의 배수(0번지에 있는 수)를 0으로 만들기
	
	1번지에 있는 숫자(3)은 1과 자기 자신밖에 없는데 2의 배수가 아님! 그럼 즉 3은 소수임
	3이 소수라고 판단되면 3의 배수들의 방을 다 0으로 바꿔줘야 함
	
	2번지에 있는 숫자(4)는 2의 배수니까 PASS
	
	3번지에 있는 숫자(5)는 소수니까 5의 배수들은 다 0으로 바꾸기
	
	
	
	index	0	1	2	3	4	......	98
	
	num 	2	3	4	5	6	....... 100
	
	
	for문을 돌릴 때 상수 대신 length를 쓰는 편이 유지보수에 좋다. 
	
	
	각 index의 값이 소수인지 확인할 필요 없다
	왜냐하면 index의 값이 0으로 바뀌지 않았다면 소수라는 뜻이기 때문이다. 
	맨처음 2는 index값이 없나,,,?
 */
public class HomeworkMain04 {

	public static void main(String[] args) {
		
		int[] arr = new int[99];
		
		Arrays.fill(arr, 1);
		
		// 배열에 숫자 채워넣기
		for(int i = 0; i < arr.length; i++) {
			arr[i] = i+2;
		}
		//System.out.println(Arrays.toString(arr));
		
		for(int i = 0; i < arr.length; i++ ) {
			if(arr[i] != 0) {
				for(int j = i+1; j < arr.length; j++) {
					if(arr[j] % arr[i] == 0) {
						arr[j] = 0;
					}
				}
			}
		}
		
		//System.out.println(Arrays.toString(arr));
		
		for(int num: arr) {
			if(num != 0) {
				System.out.print(num +"  ");
			}
		}
		
	}

}
