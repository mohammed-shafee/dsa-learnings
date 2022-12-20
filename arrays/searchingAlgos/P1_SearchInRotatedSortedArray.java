package searchingAlgos;
public class P1_SearchInRotatedSortedArray{
    //https://leetcode.com/problems/search-in-rotated-sorted-array/
    public static void main(String[] args) {
        int[] arr = {0};
        int key = 9;
        int res = searchInRotatedSortedArray(arr,key);
        System.out.println(res);
    }
    /*
     * concept is to find the pivot element i.e the maximum element
     * then searching for the target in the required range
     * since the array is rotated sorted they are two sorted parts of the array. 
     * -one from start to pivot and another from pivot to end
     * this array also has a property that start element is greater than end element
     */
    static int searchInRotatedSortedArray(int[]arr, int key){
        //first find the pivot element
        int pivot = findPivot(arr);
        int start = 0;
        int end = arr.length-1;
        if(key==arr[pivot]){
            return pivot;
        }else if(key>=arr[0]){
            //if the key is greater than start then it lies between start and pivot
            end = pivot-1;
        }else{
            //else the key lies between pivot and end
            start = pivot+1;
        }
        //now binary search for the key in the decided range
        while(start<=end){
            int mid = start+(end-start)/2;
            if(arr[mid]==key){
                return mid;
            }else if(key>arr[mid]){
                start = mid+1;        
            }else{
                end = mid-1;
            }
        }
        return -1;
    }
    
    /*
     * we need to find the largest element of the array, also the pivot point
     * idea is that either pivot element is greater than the next element or the previous element 
     */
    static int findPivot(int[] arr){
        int start = 0;
        int end = arr.length-1;

        while(start<=end){
            int mid = start+(end-start)/2;
            if(mid<arr.length-1 && arr[mid]>arr[mid+1]) {
                //it means the current mid is the pivot
                return mid;
            }
            if (mid>0 && arr[mid-1]>arr[mid]){
                //it means the preceding element to mid is the pivot
                return mid-1;
            }
            //if the above statement fails it means the mid is in one of the sorted parts.
            if(arr[mid]>arr[0]){
                //it means mid is in the 1st sorted part
                start = mid+1;
            }else if(arr[mid]<=arr[0]){
                //it means mid is in the 2nd sorted part
                end = mid-1;
            }
        }

        return arr.length-1;
    }
}