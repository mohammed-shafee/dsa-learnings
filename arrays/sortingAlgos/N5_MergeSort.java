package sortingAlgos;


import java.util.Arrays;

public class N5_MergeSort {

	public static void main(String[] args) {
		int[] arr = {1,3,5,4,2,8,3};
		int[] res = mergeSortAsc(arr);
		System.out.println(Arrays.toString(res));
		inPlaceMergeSortAsc(arr,0,arr.length);
		System.out.println(Arrays.toString(arr));
	}
	
	/*
	 *-divide and conquer technique
	 *-divide the array into 2 parts, then sort the each parts and then merge them
	 *-you sort each part by calling the same function to each part(basically recursion)  
	 */
	
	public static int[] mergeSortAsc(int[]arr) {
		if(arr.length==1) {
			return arr;
		}
		int mid = arr.length/2;
		int[] left = mergeSortAsc(subArray(arr,0,mid));
		int[] right = mergeSortAsc(subArray(arr,mid,arr.length));
		return mergeTwoLists(left,right);	
	}
	
	private static int[] subArray(int[]arr, int s, int e) {
		int[] subArr = new int[e-s];
		for(int i=s;i<e;i++) {
			subArr[i-s] = arr[i];
		}
		return subArr;
	}
	
	static int[] mergeTwoLists(int[] list,int[] list2){
		int[] arr =new int[list.length+list2.length];
		int i=0,j=0,k=0;
		while(i<list.length && j<list2.length){
			if(list[i]<list2[j]) {
				arr[k]=list[i];
				i++;
				k++;
			}else {
				arr[k]=list2[j];
				j++;
				k++;
			}
		}
		//its possible that some elements might have not been added
		//either only one of the below while loops will happen or none of them 
		while(i<list.length) {
			arr[k]=list[i];
			i++;
			k++;
		}
		while(j<list2.length) {
			arr[k]=list2[j];
			j++;
			k++;
		}
		
		return arr;
	}
	/*
	 * this method sorts the original array by changing the values of each index position accordingly
	 */
	public static void inPlaceMergeSortAsc(int[]arr,int s, int e) {
		if(e-s==1) {
			return;
		}
		int mid = s + (e-s)/2;
		inPlaceMergeSortAsc(arr,s,mid);
		inPlaceMergeSortAsc(arr,mid,e);
		mergeInPlace(arr,s,mid,e);
	}

	static void mergeInPlace(int[] arr, int start, int mid, int end) {
		//create a temporary array for storing sorted part of the array from start to end
		int[] mix = new int[end-start];
		
		int i = start;
		int j = mid;
		int k =0;
		
		while(i<mid && j<end) {
			if(arr[i]<arr[j]) {
				mix[k] = arr[i];
				i++;
			}else {
				mix[k] = arr[j];
				j++;
			}
			k++;
		}
		
		while(i<mid) {
			mix[k]= arr[i];
			i++;
			k++;
		}
		
		while(j<end) {
			mix[k]= arr[j];
			j++;
			k++;
		}
		//now replace the original values with the sorted array values
		for(int l =0;l<mix.length;l++) {
			arr[start+l] = mix[l];
		}
		
	}
	

}
