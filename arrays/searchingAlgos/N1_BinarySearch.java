package searchingAlgos;

public class N1_BinarySearch {
    
    public static void main(String[] args) {
        int[] arr = {-1,0,0,3,4,6,8,9};
        int target = 0;
        System.out.println(linearSearch(arr, target));
        System.out.println(binarySearchForAscArray(arr, target));
    }
    /*
     * returns the index of the 1st occurence of the target in the given array
     * returns -1 if not found
     * time complexity: O(N)
     */
    static int linearSearch(int[] arr, int target){
        int res = -1;
        for(int i=0;i<arr.length;i++){
            if(arr[i]==target){
                res = i;
                break;
            }
        }
        return res;
    }
    /*
     * works only when the given array is sorted
     * returns the index target in the given array
     * returns -1 if not found
     * time complexity: O(log(N))
     */
    static int binarySearchForAscArray(int[]num, int target){
        int start = 0;
        int end = num.length-1;
        while(start<=end){
            int mid = start+(end-start)/2;
            if(num[mid]==target){
                return mid;
            }else if(num[mid]>target){
                end = mid-1;
            }else{
                start = mid+1;
            }
        }
        return -1;
    }

}
