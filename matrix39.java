// Given a row-wise sorted 2D matrix mat[][] of size n x m and an integer x, find whether element x is present in the matrix.
// Note: In a row-wise sorted matrix, each row is sorted in itself, i.e. for any i, j within bounds, mat[i][j] <= mat[i][j+1].



class Solution {
    // Function to search a given number in row-column sorted matrix.
    public boolean searchRowMatrix(int[][] mat, int x) {
        // code here
        for(int i=0; i<mat.length; i++){
            if(BinarySearch(mat[i], x)){
                return true;
            }
        }
        return false;
    }
    
    static boolean BinarySearch(int arr[], int x){
        int low = 0;
        int hi = arr.length-1;
        
        while(low <= hi){
            int mid = low + (hi - low) / 2;
            if(arr[mid] == x){
                return true;
            }
            if(x < arr[mid]){
                hi = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return false;
    }
}
