package searchingAlgos;

import java.util.Arrays;

public class P3_FindFirstLastPosition {
    //https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
    public static void main(String[] args) {
        int[] nums = {5,7,7,8,8,10};
        int target = 7 ;
        int[] res = searchRange(nums, target);
        System.out.println(Arrays.toString(res));
        
    }

    public static int[] searchRange(int[] nums, int target) {
        int[] res = {-1,-1};
        res[0] = search(nums, target, true);
        if(res[0]!=-1){
            res[1] = search(nums, target, false);
        }
        return res;
    }

    static int search(int[] arr, int target, boolean isFirstIndex){
        int start = 0;
        int end = arr.length-1;
        int ans = -1;
        while(start<=end){
            int mid = start+(end-start)/2;
            if(arr[mid]>target){
                end = mid-1;
            }else if(arr[mid]<target){
                start = mid+1;
            }else{
                ans = mid;
                if(isFirstIndex){
                    end= mid-1;
                }else{
                    start= mid+1;
                }
            }
        }
        return ans;
    }


}
