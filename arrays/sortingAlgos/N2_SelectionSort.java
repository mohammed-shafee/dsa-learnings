package sortingAlgos;

import java.util.Arrays;

public class N2_SelectionSort {

	public static void main(String[] args) {
		int[] arr = {2,12,-9,3,-6,4,2,9,3,-11,12};
		selectionSortAsc(arr);
		System.out.println(Arrays.toString(arr));

	}
	/*
	 * -in this algo we select a element(based on some critera) and put it on the correct index
	 * -here we chose the maximum element of the unsorted part of the array and swap its position
	 * with the end position in the array, hence with every iteration sorting the array from the end
	 * 
	 */
	
	static void selectionSortAsc(int[] arr) {
		int temp = 0;
		for(int i=arr.length-1;i>0;i--) {
			//finding the index of max value in the  sub-array (0 to i)
			int curMaxIndexaxIndex = maxElementIndex(arr,0,i);
			//swapping the max element with the pointer element or the end of the current sub-array
			temp = arr[curMaxIndexaxIndex];
			arr[curMaxIndexaxIndex] = arr[i];
			arr[i] = temp;
		}
	}
	/*
	 * returns the 1st appearance of  index of the maximum element in the array in the given range
	 */
	static int maxElementIndex(int[] arr, int s, int e) {
		int resIndex = -1;
		int max = Integer.MIN_VALUE;
		for(int i=s;i<e+1;i++) {
			if(max<arr[i]) {
				resIndex = i;
				max = arr[i];
			}
		}
		return resIndex;
	}

}
