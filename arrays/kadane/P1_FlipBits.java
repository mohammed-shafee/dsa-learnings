package kadane;

public class P1_FlipBits {

	public static void main(String[] args) {
		//https://www.geeksforgeeks.org/maximize-number-0s-flipping-subarray/
		int[] arr = {1, 0, 1, 0, 1, 0, 1, 0};
		//return maximum 1 count after flipping the sub-array
		int ans = flipBits(arr);
		System.out.println(ans);
	}
	
	/**
	 * This method returns maximum 1s count of given binary array after flipping the sub-array once.
	 * logic:
	 * -lets say the count of 1s in the og array be a1 and of 0s be a0
	 * -lets assume we found the sub-array to be flipped which has 1s count as c1 and 0s count as c0
	 * -now we perform the flip operation on the sub-array. now the count of 1s in the new array would be :
	 * -a1 + (c0 - c1) {we added c0 1s to the new array and subtracting c1 ones as they are now 0}
	 * -we have to maximize c0-c1 value for a given sub-array, which can be achieved by kadane's algo by assigning the value of 0 as 1 and value of 1 as -1
	 * 
	 * @param arr
	 * @return
	 */
	static int flipBits(int[] arr) {
		int countCur1 = 0;
		int curSum = 0;
		int maxSum = 0;
		int tempvar = 0;
		for(int i=0;i<arr.length;i++) {
			if(arr[i]==1) countCur1++;//counting the no of 1s in the current array
			tempvar = arr[i]==1?-1:1;
			curSum+=tempvar;
			maxSum = Math.max(curSum,maxSum);
			if(curSum<0) curSum=0;
		}
		return countCur1+maxSum;
	}

}
