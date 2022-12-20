package prefixAndSuffix;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P1_SumInRanges {
    //https://www.geeksforgeeks.org/sum-of-elements-in-given-range-from-array-formed-by-infinitely-concatenating-given-array/
    public static void main(String[] args) {
        int[] arr = {1,2,3};
        // System.out.println(8/3);
        System.out.println(Arrays.toString((arr)));
        List<List<Long>> queries = new ArrayList<>();
        // contains the left and right indexes which define the range. they are 1-Indexed(i.e they referenced from 1 and not 0)
        
        queries.add(new ArrayList<>());
        queries.get(0).add(1l);
        queries.get(0).add(9l);
        //queries.add(new ArrayList<>( Arrays.asList(5l,9l)));
        //System.out.println(queries);
        List<Integer> res = sumInRanges(arr, 0, queries, 0);
        System.out.println("res: "+res);
        List<Integer> naiveres = naiveSumInRanges(arr, 0, queries, 0);
        System.out.println("naiveres: "+naiveres);
    }

    public static List<Integer> sumInRanges(int[] arr, int n, List<List<Long>> queries, int q) {
        int mod = 7 + (int) Math.pow(10, 9);
        n = arr.length;
        int[] prefix = new int[n+1];
        prefix[0] = 0;
        for(int i=1;i<prefix.length;i++){
            prefix[i] = (arr[i-1]+prefix[i-1])%mod;
        }

        List<Integer> res = new ArrayList<>();
        for(List<Long> query:queries){
            long l =  query.get(0)-1;
            long r =  query.get(1);
            long rSum = ((r/n)*(prefix[n])+ prefix[(int) (r%n)])%mod;
            long lSum = ((l/n)*(prefix[n])+ prefix[(int) (l%n)])%mod;
            res.add((int)(rSum-lSum));
        }
        return res;

    }

    static List<Integer> naiveSumInRanges(int[] arr, int n, List<List<Long>> queries, int q) {
        int mod = 7 + (int) Math.pow(10, 9);
        n = arr.length;
        List<Integer> res = new ArrayList<>();
        for(List<Long> query:queries){
            int sum = 0;
            long l =  query.get(0)-1;
            long r =  query.get(1)-1;
            for(long i= l;i<=r;i++){
                sum =(sum+arr[(int) (i%n)])%mod;
            }
            res.add(sum);
        }
        return res;
    }

    

    

}
