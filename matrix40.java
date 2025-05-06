// Given a strictly sorted 2D matrix mat[][] of size n x m and a number x. Find whether the number x is present in the matrix or not.
// Note: In a strictly sorted matrix, each row is sorted in strictly increasing order, and the first element of the ith row (i!=0) is greater than the last element of the (i-1)th row.


class Solution {
    // Function to search a given number in row-column sorted matrix.
    public boolean searchMatrix(int[][] mat, int x) {
        // code here
        int n = mat.length;
        int m = mat[0].length;
        
        int low = 0, hi = n * m - 1;
        while(low <= hi){
            int mid = low + (hi - low) / 2;
            
            int row = mid / m;
            int col = mid % m;
            
            if(mat[row][col] == x){
                return true;
            }
            if(mat[row][col] > x){
                hi = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return false;
    }
}
