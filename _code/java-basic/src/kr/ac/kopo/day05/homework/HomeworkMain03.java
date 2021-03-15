package kr.ac.kopo.day05.homework;

import java.util.Arrays;

/*
	
	배열을 사용해서 1~100 사이의 소수를 구분 및 출력하는 코드를 작성하기
	
	3. 소수는 1 ~ (판단정수) 사이의 소수로만 나누어 약수가 존재하지 않는다라는 규칙성을 이용하여
		2 ~ 100사이의 소수를 구분 및 출력하는 코드를 작성(배열)
	
	
	어떤 수가 소수인지 확인하려면? 본인 앞의 소수로 나누어 떨어지는지만 확인해보면 된다. 
	그래서 소수만 기억하는 배열을 만든다. 배열의 크기는 넉넉하게 잡는다. 
	
	int loc = 0; ===> 소수가 들어오면 몇 번지에 저장되어 있는지 기억하게 하는 변수 이다. 



	어떤 수가 소수인지 알아보려면 자기 앞에 있는 소수로 나누어보면 된다.
	prime 배열에 소수를 담아라...? 1부터 loop 돌아가면서???
	이 과정을 코드로 구현해 보아라
	
	
	
	
	2
	소수로 나누어 떨어지니? prime 없으니까 no?
	prime = 2
	
	
	
	3
	prime[0]으로 나누어 떨어지니? no
	prime[1] = 3
	
	=> prime = 2, 3
	
	
	4
	prime[0] or prime[1]으로 나누어 떨어지니? yes
	pass
	prime = 2, 3
	
	
	
	5
	prime[0] or prime[1]으로 나누어 떨어지니? no
	prime[2] = 5;
	=> prime = 2,3,5
	
	
	
	6
	prime[0] or prime[1] or prime[2]로 나누어 떨어니지? yes
	pass
	prime = 2, 3, 5
	

 */
public class HomeworkMain03 {

	public static void main(String[] args) {
		

	}

}
