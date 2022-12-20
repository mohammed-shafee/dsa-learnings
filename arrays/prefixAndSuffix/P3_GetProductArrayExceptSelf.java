package prefixAndSuffix;

import java.util.Arrays;

public class P3_GetProductArrayExceptSelf {
    public static void main(String[] args) {
        int[] arr = {1,2,0,6};
        System.out.println(Arrays.toString(naiveGetProductArrayExceptSelf(arr)));
        System.out.println(Arrays.toString(getProductArrayExceptSelf(arr)));
    }

    public static int[] getProductArrayExceptSelf(int[] arr) {
        //int mod = 1000000007;
        int[] ans = new int[arr.length];
        int[] left = new int[arr.length];
        int[] right = new int[arr.length];
        
        left[0]=1;
        for(int i=1;i<arr.length;i++){
            left[i] = left[i-1]*arr[i-1]; 
        }
        right[arr.length-1] = 1;
        for(int j = arr.length-2;j>-1;j--){
            right[j] = right[j+1]*arr[j+1];
        }
        for(int k =0;k<arr.length;k++){
            ans[k] = left[k]*right[k];
        }
        return ans;
    }

    public static int[] naiveGetProductArrayExceptSelf(int[] arr) {
    	//Your code goes here
        int mod = 1000000007;
        int prod = 1;
        boolean isZeroPresent = false;
        int zeroCount = 0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]!=0){
                prod = (prod*arr[i])%mod;
            } else{
                isZeroPresent = true;
                zeroCount++;
            }
        }
        int[] res = new int[arr.length];
        for(int i=0;i<arr.length;i++){
            if(arr[i]!=0){
                if(isZeroPresent){
                    res[i] =0;
                }else{
                    res[i] = prod/arr[i];
                }
            }else{
                if(zeroCount==1){
                    res[i] = prod;
                }else{
                    res[i] = 0;
                }
            }
            
        }

        return res;
    }

}
