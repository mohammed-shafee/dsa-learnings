package prefixAndSuffix;

public class SubarraysCountDivByK {
    // https://www.geeksforgeeks.org/count-sub-arrays-sum-divisible-k/
    // https://leetcode.com/problems/subarray-sums-divisible-by-k/description/
    public static void main(String[] args) {
        int[] arr = {5,0,2,3,1};//{4,5,0,-2,-3,1}{5,0,2,3,1}
        int k = 5;
        int count = naiveSubarrayCount( arr, k);
        System.out.println("count= "+count);
        System.out.println("***********************");
        int count2 = subarrayCount(arr, k);
        System.out.println("count2= "+count2);
    }

    private static int subarrayCount(int[] arr, int k) {
        //its still naive approach
        int count=0;
        int[] left = new int[arr.length];

        left[0]= arr[0];
        for(int i =1;i<arr.length;i++){
            left[i] = left[i-1]+arr[i];
        }

        for(int i =0;i<arr.length;i++){
            if(left[i] % k==0) {
                count++;
                printsubarray(arr, 0, i);
            }
            for(int j=0;j<i;j++){
                if((left[i]-left[j])%k==0){
                    count++;
                    printsubarray(arr, j+1, i);
                } 

            }
        }
        return count;
    }

    private static int naiveSubarrayCount(int[] arr, int k) {
        int count =0; 
        for(int i=0;i<arr.length;i++){
            for(int j=i;j<arr.length;j++){
                int sum=sum(arr, i, j);
                if(sum%k==0){
                    count++;
                     printsubarray(arr, i, j);
                }
            }
        }
        return count;
    }
    
    private static int sum(int[]arr, int s, int e){
        int sum = 0;
        for(int i =s;i<=e;i++){
            sum+=arr[i];
        }
        return sum;
    }

    private static void printsubarray(int[]arr, int s, int e){
        
        for(int i =s;i<=e;i++){
            System.out.print(arr[i]+", ");
        }
        System.out.println();
        
    }


}
