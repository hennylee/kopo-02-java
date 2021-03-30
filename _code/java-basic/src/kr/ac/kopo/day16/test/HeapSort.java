package kr.ac.kopo.day16.test;

import java.util.Arrays;

public class HeapSort {
	
	private static void heap(int[] data, int number) {
		for(int i = 1; i < number; i++) {
			int child = i;
			
			while(child > 0) {
				int parent = (child-1) / 2;
				
				if(data[child] > data[parent]) {
					int temp = data[parent];
					data[parent] = data[child];
					data[child] = temp;
				}
				
				child = parent;
			}
		}
	}
	
	

	public static void main(String[] args) {
		int[] arr = {1,10,5,8,7,6,4,3,2,9};
		
		heap(arr, arr.length);
		System.out.println(Arrays.toString(arr));
	}

}
