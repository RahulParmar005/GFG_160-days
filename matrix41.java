// You are given a 2D matrix mat[][] of size n×m. The task is to modify the matrix such that if mat[i][j] is 0, all the elements in the i-th row and j-th column are set to 0 and do it in constant space complexity.


class Solution {
    public void setMatrixZeroes(int[][] mat) {
        int n = mat.length, m = mat[0].length;
        int c0 = 1;
        
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(mat[i][j] == 0){
                    mat[i][0] = 0;
                    if(j == 0)
                        c0 = 0;
                    else
                        mat[0][j] = 0;
                }
            }
        }
        for(int i=1; i<n; i++){
            for(int j=1; j<m; j++){
                if(mat[i][0] == 0 || mat[0][j] == 0){
                    mat[i][j] = 0;
                }
            }
        }
        if(mat[0][0] == 0){
            for(int j=0; j<m; j++){
                mat[0][j] = 0;
            }
        }
        if(c0 == 0){
            for(int i=0; i<n; i++){
                mat[i][0] = 0;
            }
        }
    }
}