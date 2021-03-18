package kr.ac.kopo.day07.homework.solution;

/*

Icecream.java 여기에 전체를 출력하는 코드가 있는 것은 올바르지 않다!
Icecream.java 에는 아이스크림 하나에 대한 변수정보만 있어야 한다. 
이 class에  아래 코드가 있는 것은 옳지 않다. 

	for() {
		ice[i].입력
		ice[i].출력
	}
	
 */

public class Icecream {
	
	// 아이스크림 하나의 멤버변수
	String name;
	int price;
	
	Icecream(){
		
	}
	
	
	Icecream(String n, int p){
		set(n, p);
	}
	
	
	// 입력받은 정보 Icecream객체에 넣는 메소드
	void set(String n, int p) {
		name = n;
		price = p;
	}
	
	String getName() {
		return name;
	}
	
	int getPrice() {
		return price;
	}
	
}
