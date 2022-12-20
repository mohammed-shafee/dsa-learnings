package sortingAlgos;

import java.util.Arrays;

public class N6_QuickSort {

	public static void main(String[] args) {
		int[] arr = {2,12,-9,3,-6,4,2,9,3,-11,12};
		quickSortAsc(arr,0,arr.length-1);
		System.out.println(Arrays.toString(arr));
	}
	/**
	 * 
	 * @param arr
	 * @param low - start index value of the array
	 * @param high - end index value of the array
	 */
	static void quickSortAsc(int[] arr, int low, int high) {
		if(low>=high) {
			return;
		}
		int start = low;
		int end = high;
		int mid = start + (end-start)/2;
		int pivot = arr[mid];

		//we bring the pivot value to the correct position
		while(start<=end){
			//check how many elements are on the correct side of the array with respect to pivot
			//this is also to put the start and end pointers at the correct position
			while(arr[start]<pivot){
					start++;
			}

			while(arr[end]>pivot){
				end--;
			}
			
			if(start<=end){
			//we swap the values the start and end pointers with each other
				int temp = arr[start];
				arr[start] = arr[end];
				arr[end] = temp;
			//now we want to continue doing the above process till start<=end condition fails 
			//i.e elements are placed on correct side with respect to pivot value
				start++;
				end--; 
			}
		}
		//now quick sort the two parts on the either side of the pivot
		quickSortAsc(arr, low, end);
		quickSortAsc(arr, start, high);
	}

}
