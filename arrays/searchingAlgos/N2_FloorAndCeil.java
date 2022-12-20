package searchingAlgos;

public class N2_FloorAndCeil {
    //given a sorted array find the floor and ceil of a target element
    
    public static void main(String[] args) {
        int[] arr = {-1,0,0,3,4,6,8,9};
        int target = 6;
        int[] res = floorAndCeil(arr, target);
        System.out.println("floor: "+arr[res[0]]+", ceil: "+arr[res[1]]);
        System.out.println(arr[ceil(arr, target)]);
    }

    static int[] floorAndCeil(int[] arr, int target){
        int start = 0;
        int end = arr.length-1;
        while(start<=end){
            int mid = start+(end-start)/2;
            if(arr[mid]>target){
                end = mid-1;
            }else if(arr[mid]<target){
                start = mid+1;
            }else{
                start = mid;
                end = mid;
                break;
            }
        }
        return new int[]{end,start};
    }

    static int ceil(int[] arr,int target){
        int start = 0;
        int end = arr.length-1;
        while(start<=end){
            int mid = start+(end-start)/2;
            if(arr[mid]>target){
                end = mid-1;
            }else if(arr[mid]<target){
                start = mid+1;
            }else{
                return mid;
            }
        }
        return start;
    }


}


