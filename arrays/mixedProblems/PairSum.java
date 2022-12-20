package mixedProblems;

import java.util.ArrayList;
import java.util.Arrays;

public class PairSum {
    //optimized solution: https://www.geeksforgeeks.org/count-pairs-with-given-sum/
    public static void main(String[] args) {
        int[] arr = {4,5,0,-2,-3,1};
        int s = 5;
        int[][] res = pairSum(arr, s);
        for(int i =0;i<res.length;i++){
            System.out.println(Arrays.toString(res[i]));
        }
        
    }

    public static int[][] pairSum(int[] arr, int s) {
        // Write your code here.
        // ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        // Arrays.sort(arr);
        // for(int i =0;i<arr.length;i++){
        //     int start = i+1;
        //     int end = arr.length-1;
        //     int target = s-arr[i];
        //     int ians = -1; 
        //     while(start<=end) {
        //         int mid = start+(end-start)/2;
        //         if(arr[mid]<target){
        //             start = mid+1;
        //         }else if(arr[mid]>target){
        //             end = mid -1;
        //         }else{
        //             ians = mid;

        //         }
        //     }
        // }
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        Arrays.sort(arr);
        for(int i=0;i<arr.length-1;i++){
            for(int j = i+1;j<arr.length;j++){
                if(arr[i]+arr[j]==s){
                    res.add(new ArrayList<>(Arrays.asList(arr[i],arr[j])));
                }else if(arr[i]+arr[j]>s){
                    break;
                }
            }
        }    

        int[][] list = new int[res.size()][2];
        for(int i=0;i<res.size();i++){
            list[i][0] = res.get(i).get(0);
            list[i][1] = res.get(i).get(1);
        }
    

        return list ;
    }

}
