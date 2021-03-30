package kr.ac.kopo.day14.homework;

import java.util.HashSet;
import java.util.Set;

public class SetMain {

	public static void main(String[] args) {
		Set<Character> set = new HashSet<>();
		
		set.add('A');
		set.add('B');
		set.add('C');
		set.add('D');
		set.add('E');
		set.add('A');
		set.remove('A');

		for(char c: set) {
			System.out.println(c);
		}
		
	}

}
