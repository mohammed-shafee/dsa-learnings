package arrays.kadane;

import java.util.ArrayList;

public class GFG_rat_in_maze {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 4;
		int[][] m = {
				{1, 0, 0, 0},
		         {1, 1, 0, 1}, 
		         {1, 1, 0, 0},
		         {0, 1, 1, 1}};
		// int[][] m = {{1,0},{1,0}};
		ArrayList<String> ans = findPath(m, n);
		System.out.println(ans);

	}
	
	public static ArrayList<String> findPath(int[][] m, int n) {
        // Your code here
        ArrayList<String> ans = new ArrayList<>();
        boolean[][] visited  = new boolean[m.length][m[0].length];
        if(m[0][0] == 0) return ans;
//        visited[0][0] = true;
        findPaths(m,n,0,0,"",ans,visited);
        return ans;
    }
    
    public static void findPaths(int[][] m, int n, int row, int col, String path,  ArrayList<String> ans, boolean[][] visited){
        if(row == n-1 && col == n-1 || m[n-1][n-1] == 0){
            ans.add(path);
            return;
        }
        if(row<0 || col<0 || row>=n || col>=n || visited[row][col] || m[row][col] == 0){
            return;
        }
        visited[row][col] = true;
        //up:
        findPaths(m,n,row+1,col,path+"D",ans,visited);
        //down
        findPaths(m,n,row-1,col,path+"U",ans,visited);
        //left:
        findPaths(m,n,row,col-1,path+"L",ans,visited);
        //right:
        findPaths(m,n,row,col+1,path+"R",ans,visited);
        visited[row][col] = false;
    }
}