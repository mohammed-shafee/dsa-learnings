package searchingAlgos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P4_CountSmallerOrEqual {
    public static void main(String[] args) {
        //https://www.codingninjas.com/codestudio/guided-paths/data-structures-algorithms/content/118820/offering/1381881
        int[] a = {2,3,4,8};
        int[] b = {5,4,0,9};
        System.out.println(countSmallerOrEqual(a, b));
    }
    public static List<Integer> countSmallerOrEqual(int[] a, int[] b) {
        // Write your code here!
        List<Integer> res = new ArrayList<>();
        Arrays.sort(b);// sorting the array b in ascending order
        
        for(int i=0;i<a.length;i++){
            //no of elements in b which are smaller or equal to a[i] would be the floor of a[i] in b
            int count = floorIndexWithLastOccurence(b,a[i])+1;
            res.add(count);
        }
        return res;
    }
    static int floorIndexWithLastOccurence(int[] arr, int target){
        int start =0;
        int end =arr.length-1;
        while(start<=end){
            int mid = start+(end-start)/2;
            if(arr[mid]>target){
                end = mid-1;
            }else if(arr[mid]<=target){
                start = mid+1;
            }
        }
        return end;
    }
}
