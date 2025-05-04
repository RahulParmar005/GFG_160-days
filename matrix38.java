// Given a 2D integer matrix mat[][] of size n x m, where every row and column is sorted in increasing order and a number x, the task is to find whether element x is present in the matrix.

class Solution {
    public static boolean matSearch(int mat[][], int x) {
        // your code here
        int n = mat.length, m = mat[0].length;
        int i = 0, j = m - 1;
        
        while(i<n && j>=0){
            if(x > mat[i][j]){
                i++;
            } else if(x < mat[i][j]){
                j--;
            } else {
                return true;
            }
        }
        return false;
    }
}
    