package kr.ac.kopo.day17.homework;

import java.util.Scanner;

public class HomeworkMain01 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			System.out.print("급여를 입력하시오 : ");
			int max = sc.nextInt();
			PrnEmpSalary pes = new PrnEmpSalary();
			pes.getAvg(max);
			System.out.println();
			
		}
		
	}

}
