package kadane;

import java.util.ArrayList;


public class P2_MaxSubSumKConcat {
	//https://leetcode.com/problems/k-concatenation-maximum-sum/
	public static void main(String[] args) {
		// Maximum subarray sum after K concatenation
		int[] arr = {10000,10000,10000,10000,10000,10000,10000,10000,10000,10000};
		int k = 100000;
//		int n = arr.length;
//		ArrayList<Integer> list = new ArrayList<>();
//		for(int i =0; i<arr.length;i++) {
//			list.add(arr[i]);
//		}
//		long res = maxSubSumKConcat(list,n,k);
//		System.out.println(res);
		int res2 = kConcatenationMaxSum(arr,k);
		System.out.println(res2);
//		System.out.println(1000000007);
//		System.out.println(Integer.MAX_VALUE);
//		int l = 0;
//		for(int i = 0; i<100000;i++) {
//			l = (l+100000)%1000000007;
//		}
//		System.out.println(l);

	}
	
	public static long maxSubSumKConcat(ArrayList<Integer> arr, int n, int k) {
		//concat the given list k-1 times to itself
		for(int i=1;i<k;i++) {
			arr.addAll(arr.subList(0,n));
		}
		/*above code is equivalent to the below
		 * for(int i =1;i<k;i++){
		 * 		for(int i=0;i<n;i++){
		 * 			arr.add(arr.get(i));
		 * 		}
		 * }
		 */
		//now apply kadane's algo
		//problem requirement: don't consider empty sub-array
		int curSum = 0;
		//int maxSum = Integer.MIN_VALUE;
		int maxSum =0;
		for(int i = 0; i<arr.size();i++) {
			curSum+=arr.get(i);
			maxSum = Math.max(curSum,maxSum);
			if(curSum<0) curSum =0;
		}
		return maxSum;
	}
	
	 public static int kConcatenationMaxSum(int[] arr, int k) {
		 int mod = 1000000007;

		 int curSum = 0;
		 int maxSum = 0;//emply array is considered and its total sum =0;
		 for(int i=0;i<arr.length*k;i++) {
			 curSum=(curSum+arr[i%arr.length])%mod;
			 maxSum = Math.max(curSum,maxSum);
			 if(curSum<0) curSum =0;
		 }
		 return maxSum%mod;
	 }

}
