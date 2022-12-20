package kadane;

public class P3_MaxSumRectangle {

	public static void main(String[] args) {
		// Maximum Sum Rectangle(hard){please solve later}
		//
		/**
		 * https://www.interviewbit.com/blog/maximum-sum-rectangle/
		 * https://leetcode.com/problems/max-sum-of-rectangle-no-larger-than-k/description/
		 * https://www.geeksforgeeks.org/maximum-sum-rectangle-in-a-2d-matrix-dp-27/
		 */
		int[][] arr = {
				{ 1, 2, -1, -4, -20 },
                { -8, -3, 4, 2, 1 },
                { 3, 8, 10, 1, 3 },
                { -4, -1, 1, 7, -6 }
		};
		
		System.out.println(bruteForceMaxSumRectangle(arr));

	}
	
	public static int bruteForceMaxSumRectangle(int[][] arr)
    {
		int n = arr.length;
		int m = arr[0].length;
		int maxSum =Integer.MIN_VALUE;
		int top = 0,left = 0, bottom = 0, right =0;
		for(int i = 0;i<n;i++) {
			for(int j =0;j<m;j++) {
				for(int k=0;k<n;k++) {
					for(int l=0;l<m;l++) {
						int curSum = sumOfRectangle(arr,i,j,k,l);
						if(curSum>maxSum) {
							maxSum = curSum;
							top = i;
							bottom =k;
							left =j;
							right = l;
						}
					}
				}
			}
		}
		System.out.println("(top, left) = ("+top+","+left+")");
		System.out.println("(bottom, right) = ("+bottom+","+right+")");
        return maxSum;
    }
	
	static int sumOfRectangle(int[][] arr, int r1, int c1, int r2, int c2) {
		int sum =0;
		for(int i = r1;i<=r2;i++) {
			for(int j=c1;j<=c2;j++) {
				sum+=arr[i][j];
			}
		}
		return sum;
	}

}
