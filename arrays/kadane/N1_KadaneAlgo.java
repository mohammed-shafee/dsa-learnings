package kadane;

public class N1_KadaneAlgo {
	//https://leetcode.com/problems/maximum-subarray/
	public static void main(String[] args) {
		int[] arr = {-9,34,7,8,23,-90};
		long ans = maxSubarraySum(arr);
		System.out.println(ans);

	}
	
	/**
	 * This method returns the maximum sub-array sum
	 * sub-array can be made by removing some elements from the start or/and end of the given array
	 * note:here sum of an empty(sub) array is taken 0
	 * @param arr
	 * @param n
	 * @return
	 */
	
	static long maxSubarraySum(int[] arr) {
		long cursum = 0;
        long maxsum = 0;
        /*
         * here empty array sum = 0 and hence we are starting maxsum with 0;
         * in this case, if all elements are negative, then by default the maxsubarraysum is empty array i.e 0;
         * if empty array is not considered as subarray, then we have to start maxsum = Integer.MIN_VALUE
         * in this case, if all elements are negative, then the maxsubarraysum would simply be the largest num
         */
        for(int i =0;i<arr.length;i++){
            cursum = cursum + arr[i];
            maxsum = Math.max(cursum,maxsum);
            if(cursum<0){
                cursum = 0;
                //if the cursum < 0 we don't want to carry it forward and hence we make a fresh start i.e cursum =0
            }
        }
        return maxsum;
	} 

}
