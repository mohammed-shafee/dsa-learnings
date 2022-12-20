package sortingAlgos;

import java.util.Arrays;

public class N1_BubbleSort {

	public static void main(String[] args) {
		int[] arr = {2,12,-9,3,-6,4,2,9,3,-11,12};
		bubbleSortAsc(arr);
		System.out.println(Arrays.toString(arr));
	}
	
	/*
	 *-In this sorting algo we compare adjacent elements and swap if the left is greater than right
	 *and move to next element and is done till the pointer reaches second last element.
	 *-at the end of each pass largest element in the unsorted array comes to the right i.e the right side of the array is sorted
	 */
	static void bubbleSortAsc(int[] arr) {
		int temp =0;
		for(int i =arr.length-1;i>0;i--) {
			for(int j=0;j<arr.length-1;j++) {
				if(arr[j]>arr[j+1]) {
					temp =arr[j];
					arr[j]= arr[j+1];
					arr[j+1]= temp;
				}
			}
		}
	}

}
