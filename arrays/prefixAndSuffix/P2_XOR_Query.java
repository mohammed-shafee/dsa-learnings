package prefixAndSuffix;

import java.util.ArrayList;
import java.util.Arrays;

public class P2_XOR_Query {
    //https://www.geeksforgeeks.org/xor-queries-on-a-given-set/ (further reading for hard level)
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> queries = new ArrayList<>();
        queries.add( new ArrayList<>( Arrays.asList(1,5) ));
        queries.add( new ArrayList<>( Arrays.asList(1,3) ));
        queries.add( new ArrayList<>( Arrays.asList(2,3) ));
        queries.add( new ArrayList<>( Arrays.asList(1,0) ));
        queries.add( new ArrayList<>( Arrays.asList(2,6) ));
        System.out.println(queries);
        ArrayList<Integer> list = xorQuery(queries);
        System.out.println(list);

    }

    public static ArrayList<Integer> xorQuery(ArrayList<ArrayList<Integer>> queries) {
        
        //bruite force
        // ArrayList<Integer> res = new ArrayList<>();
        // for(ArrayList<Integer> query: queries){
        //     if(query.get(0)==1){
        //         res.add(query.get(1));
        //     }else if(query.get(0)==2){
        //         for(int i=0;i<res.size();i++){
        //             res.set(i, res.get(i)^query.get(1));
        //         }
        //     }
        // }
        // little faster:
        ArrayList<Integer> res = new ArrayList<>();
        int x0 = 0;
        for(int i=0;i<queries.size();i++){
            if(queries.get(i).get(0)==1){
                res.add(queries.get(i).get(1));
            }else{
                x0= x0^queries.get(i).get(1);
            }
        }
        int j=0;
        for(int i=0;i<queries.size();i++){
            if(queries.get(i).get(0)==1){
                res.set(j, res.get(j)^x0);
                j++;
            }else{
                x0= x0^queries.get(i).get(1);
            }
        }
		
		return res;
	}


}
