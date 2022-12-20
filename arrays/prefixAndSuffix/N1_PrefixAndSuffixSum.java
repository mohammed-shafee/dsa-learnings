package prefixAndSuffix;

import java.util.Arrays;

public class N1_PrefixAndSuffixSum {
    // https://www.geeksforgeeks.org/prefix-sum-array-implementation-applications-competitive-programming/
    public static void main(String[] args) {
        int[] arr = {3,1,-3,2,8,-6,9};
        int[] prefixArray = prefixSumArray(arr);
        int[] suffixArray = suffixSumArray(arr);
        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(prefixArray));
        System.out.println(Arrays.toString(suffixArray));
    }

    private static int[] suffixSumArray(int[] arr) {
        int[] suffix = new int[arr.length];
        suffix[arr.length-1] = arr[arr.length-1];
        for(int i=arr.length-2;i>=0;i--){
            suffix[i] = arr[i]+suffix[i+1];
        }
        return suffix;
    }

    private static int[] prefixSumArray(int[] arr) {
        int[] prefix = new int[arr.length];
        prefix[0] = arr[0];
        for(int i=1;i<arr.length;i++){
            prefix[i] = arr[i]+prefix[i-1];
        }
        return prefix;
    }

}
