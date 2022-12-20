package searchingAlgos;

import java.util.ArrayList;

public class P2_PossibleToMakeTriangle {
    //https://leetcode.com/problems/valid-triangle-number/
    public static void main(String[] args) {
        int[] nums = {4,2,3,4};
        
        System.out.println(triangleNumber(nums));
    }

    public static boolean possibleToMakeTriangle(ArrayList<Integer> arr){
		// Write your code here.
        int[] nums = new int[arr.size()];
        for(int i=0;i<nums.length;i++){
            nums[i]= arr.get(i);
        }
        //brute force
        for(int i=0;i<nums.length-2;i++){
            for(int j= i+1;j<nums.length-1;j++){
                for(int k=j+1;k<nums.length;k++){
                    if(isTriangle(nums[i], nums[j], nums[k])){
                        return true;
                    }
                }
            }
        }
        return false;
	}

    public static int triangleNumber(int[] nums) {
        //https://leetcode.com/problems/valid-triangle-number/
        //solve for the optimized solution later
        return 0;
    }

    static boolean isTriangle(int a, int b, int c){
        //checks whether the triplet forms a triangle using inequality theorm
        return ((a+b)>c) && ((b+c)>a) && ((a+c)>b);
    }
}
