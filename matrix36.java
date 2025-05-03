// You are given a rectangular matrix mat[][] of size n x m, and your task is to return an array while traversing the matrix in spiral form.



class Solution {
    // Function to return a list of integers denoting spiral traversal of matrix.
    public ArrayList<Integer> spirallyTraverse(int mat[][]) {
        // code here
        int m = mat.length;
        int n = mat[0].length;
        
        ArrayList<Integer> res = new ArrayList<>();
        
        int top = 0; int bottom = m - 1, left = 0, right = n - 1;
        
        while(top <= bottom && left <= right){
            for(int i=left; i<=right; i++){
                res.add(mat[top][i]);
            }
            top++;
            for(int i=top; i<=bottom; i++){
                res.add(mat[i][right]);
            }
            right--;
            if(top <= bottom){
                for(int i=right; i>=left; i--){
                    res.add(mat[bottom][i]);
                }
                bottom--;
            }
            if(left <= right){
                for(int i=bottom; i>=top; i--){
                    res.add(mat[i][left]);
                }
                left++;
            }
        }
        return res;
    }
}
