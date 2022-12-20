package sortingAlgos;

import java.util.Arrays;

public class N4_CyclicSort {

	public static void main(String[] args) {
		int[] arr = {1,3,5,6,8,7,9,2,4};
		cyclicSortAsc(arr);
		System.out.println(Arrays.toString(arr));
	}
	/*
	 * -This algo is used when the elements in the array are in range(1:N){to be more precise the array is basically a number set from 1 to N}
	 * -This algo's technique can be used to sort of the array if they form some form of progression series like AM, GM or HM.
	 */
	static void cyclicSortAsc(int[] arr) {
		//all elements lie in range(1:N)
		//idea is arr[i] should actual be at index arr[i-1] or index i = arr[i]-1
		int temp =0;
//		for(int i=0;i<arr.length;i++) {
//			if(arr[i]!=arr[arr[i]-1]){//checking the idea as a condition
//				temp = arr[arr[i]-1];//storing the element at index = arr[i]-1 in a temp variable
//				arr[arr[i]-1] = arr[i];
//				arr[i] = temp;
//			}
//		}
		int i =0;
		while(i<arr.length) {
			if(arr[i]!=arr[arr[i]-1]){//checking the idea as a condition
				temp = arr[arr[i]-1];//storing the element at index = arr[i]-1 in a temp variable
				arr[arr[i]-1] = arr[i];
				arr[i] = temp;
			}else {
				i++;
			}
		}
		
	}

}
