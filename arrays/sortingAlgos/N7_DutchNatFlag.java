package sortingAlgos;

import java.util.Arrays;

class N7_DutchNatFlag{
    //this algo is best suited when there are only 3 different(distinct) elements(repeated) in the data set
    public static void main(String[] args) {
        int[] arr = {0, 1, 2, 2, 1, 0};
		twoPassAlgoAsc(arr);
		System.out.println(Arrays.toString(arr));
        arr = new int[] {0, 1, 2, 2, 1, 0};
        threeWayPartitioning(arr);
        System.out.println(Arrays.toString(arr));
    }

    /*
     * -> Maintain three indices low = 0, mid = 0, and high = N-1, where N is the number of elements in the array. 
     *      1. The range from 0 to low denotes the range containing 0s. 
     *      2. The range from low to mid denotes the range containing 1s. 
     *      3. The range from mid to high denotes the range containing any of 0s, 1s, or 2s. 
     *      4. The range from high to N-1 denotes the range containing 2s. 
     * -> The mid pointer denotes the current element, traverses the array while mid<=high i.e we have exhausted the search space for the range which can contain any of 0s, 1s, or 2s. 
     *      1. If A[mid] == 0, swap A[mid] and A[low] and increment low and mid pointers by 1. 
     *      2. If A[mid] == 1, increment the mid pointer by 1. 
     *      3. If A[mid] == 2, swap A[high] and A[mid] and decrement high by 1. 
     * The resulting array will be a sorted array containing 0s, 1s, and 2s.
     */
    static void threeWayPartitioning(int[]arr){
        //initialize pointers low, curr, high
        int low =0,curr=0,high=arr.length-1;
        int temp=0;
        while(curr<=high){
            if(arr[curr]==0){
                temp = arr[curr];
                arr[curr] = arr[low];
                arr[low] = temp;
                curr++;
                low++;
            }
            else if(arr[curr]==1){
                curr++;
            }
            else if(arr[curr]==2){
                temp = arr[curr];
                arr[curr] = arr[high];
                arr[high] = temp;
                // curr++;
                high--;
            }
        }
    }

    /*
     * 1-first traverse through the entire array and count no of 0s, 1s and 2s
     * 2-traverse again through the entire array and overide the current position elements with actual number
     */
    static void twoPassAlgoAsc(int[] arr){
        //step1:
        int count1 = 0, count2 = 0, count0 =0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]==0) count0++;
            else if(arr[i]==1) count1++;
            else if(arr[i]==2) count2++;
        } 

        //step2:
        int j =0;
        while(count0>0){
            arr[j] = 0;
            j++;
            count0--;
        }
        
        while(count1>0){
            arr[j] = 1;
            j++;
            count1--;
        }
        
        while(count2>0){
            arr[j] = 2;
            j++;
            count2--;
        }
    }
}