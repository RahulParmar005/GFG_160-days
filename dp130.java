// Given an array arr[] which represents the dimensions of a sequence of matrices where the ith matrix has the dimensions (arr[i-1] x arr[i]) for i>=1, find the most efficient way to multiply these matrices together. The efficient way is the one that involves the least number of multiplications.


class Solution {
    static int matrixMultiplication(int arr[]) {
        // code here
        int n = arr.length;
        int dp[][] = new int[n][n];
        
        for(int len = 2; len < n; len++) {
            for(int  i = 0; i < n - len; i++) {
                int j = i + len;
                dp[i][j] = Integer.MAX_VALUE;
                
                for(int k = i + 1; k < j; k++) {
                    int cost = dp[i][k] + dp[k][j] + arr[i] * arr[k] * arr[j];
                    if(cost < dp[i][j]) {
                        dp[i][j] = cost;
                    }
                }
            }
        }
        
        return dp[0][n - 1];
    }
}