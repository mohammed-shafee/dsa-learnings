package sortingAlgos;

import java.util.ArrayList;

class P1_QuickSortUsingDutchNationalFlag{
    public static void main(String[] args) {
        int[] arr = {2,12,-9,3,-6,4,2,9,3,-11,12};
        ArrayList<Integer> list = new ArrayList<>();
        for(int i=0;i<arr.length;i++){
            list.add(arr[i]);
        }
        System.out.println(list);
        quickSortUsingDutchNationalFlag(list);
        System.out.println(list);
    }

    static void quickSortUsingDutchNationalFlag(ArrayList<Integer> arr){
        quicksort(arr, 0, arr.size()-1);
    }

    static void quicksort(ArrayList<Integer> arr, int low, int high){
        if(low>=high) return;
        int start = low,end = high;
        int mid = low+(high-low)/2;
        int pivot  = arr.get(mid);
        while(start<=end){
            while(arr.get(start)<pivot){
                start++;
            }
            while(arr.get(end)>pivot){
                end--;
            }
            if(start<=end){
                int temp = arr.get(end);
                arr.set(end,arr.get(start));
                arr.set(start, temp);
                start++;
                end--;
            }
        }
        quicksort(arr, low, end);
        quicksort(arr, start, high);


    }

    //revisit this section again
    //quick sort using dutch national flag
    //https://www.geeksforgeeks.org/3-way-quicksort-dutch-national-flag/
    public static void swap(int arr[],int i,int j ){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
    public static ArrayList<Integer> quickSortUsingDutchNationalFlag2(ArrayList<Integer> arr) {
        
        int[] a = new int[arr.size()];//convert to array
        for(int i=0;i<a.length;i++){
           a[i] = arr.get(i);
        }
        int low=0,mid=0,high=a.length-1;//temp=0;
        while(mid<=high){
            //similar to dutchNatFlag u send the mid element either to lhs or rhs depending upon the value 
            if(a[mid]<a[low]){
                swap(a,mid,low);continue;}
            else if(a[mid]>a[high]){
                swap(a,mid,high);continue;
            }
            else{
                
                boolean bool=false;
                for(int j=1;j<mid;j++){
                    if(a[mid]<a[j]){
                        swap(a,mid,j);
                        bool = true;
                        break;
                    }
            }
                    if(bool){
                    continue;
                }else{
                    mid++;
                }         
            }
        }
        for(int i1=0;i1<a.length;i1++){
            arr.set(i1,a[i1]);
        }
        return arr;
    }
}