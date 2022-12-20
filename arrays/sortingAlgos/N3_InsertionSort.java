package sortingAlgos;

import java.util.Arrays;

public class N3_InsertionSort {

	public static void main(String[] args) {
		int[] arr = {2,12,-9,3,-6,4,2,9,3,-11,12};
		insertionSortAsc(arr);
		System.out.println(Arrays.toString(arr));
	}
	/*
	 * -for every index put that index element at the correct index on LHS
	 * -for every pass the array is sorted from the LHS of the array.
	 */
	static void insertionSortAsc(int[] arr) {
		int temp =0;
		for(int i = 1;i<arr.length;i++) {
			for(int j = i;j>0;j--) {
				//if the element on the LHS of the j pointer is larger then swap and proceed
				//else break as the LHS of the array is already sorted in ascending order
				if(arr[j]<arr[j-1]) {
					temp = arr[j];
					arr[j] = arr[j-1];
					arr[j-1] = temp;
				}else {
					break;
				}
			}
		}
	}

}
