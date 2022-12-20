package mixedProblems;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MaxProductCount {
    public static void main(String[] args) {
        int[] arr = {2, 6, 3, 4, 1, 12 };
        // long[] ans = maxProductCount(arr, arr.length);
        // System.out.println(Arrays.toString(ans));

    }
    public static long[] maxProductCount(int arr[], int n) {
        // Write your code here.
        Map<Long,Integer> obs = new HashMap<>();
        // finding the quadrapules
        for(int i=0;i<arr.length-3;i++){
            for(int j=i+1;j<arr.length-2;j++){
                for(int k =j+1;k<arr.length-1;k++){
                    for(int l =k+1;l<arr.length;l++){
                        if(arr[i]*arr[j]==arr[k]*arr[l]){
                            if(obs.containsKey(arr[i]*arr[j])){
                                obs.replace((long) (arr[i]*arr[j]), obs.get(arr[i]*arr[j]), obs.get(arr[i]*arr[j])+1);
                            }else{
                                obs.put((long) (arr[i]*arr[j]), 1);
                            }
                        }
                    }
                }
            }
        }
        //findinig the max count
        if(obs.size()==0){
            return new long[2];
        }
        int maxcount = Integer.MIN_VALUE;
        long cmin = Integer.MAX_VALUE;
        for(Map.Entry<Long,Integer> entry: obs.entrySet()){
            if(entry.getValue()>maxcount){
                maxcount = entry.getValue();
                cmin = entry.getKey();
            }else if(entry.getValue()==maxcount){
                cmin = Math.min(cmin,entry.getKey());
            }
        }
        return new long[] {cmin,maxcount};

    }
}
