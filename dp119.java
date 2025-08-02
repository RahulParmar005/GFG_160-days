// Given n items, each with a specific weight and value, and a knapsack with a capacity of W, the task is to put the items in the knapsack such that the sum of weights of the items <= W and the sum of values associated with them is maximized. 

// Note: You can either place an item entirely in the bag or leave it out entirely. Also, each item is available in single quantity.


class Solution {
    static int knapsack(int W, int val[], int wt[]) {
        // code here
        int n = wt.length;
        int dp[][] = new int[n + 1][W + 1];
        
        for(int i = 0; i <= n; i++) {
            for(int j = 0; j <= W; j++) {
                
                if(i == 0 || j == 0) {
                    dp[i][j] = 0;
                } else  {
                    int pick = 0;
                    
                    if(wt[i  - 1] <= j) {
                        pick = val[i - 1] + dp[i - 1][j - wt[i - 1]];
                    }
                    
                    int notPick = dp[i - 1][j];
                    dp[i][j] = Math.max(pick, notPick);
                }
            }
        }
        
        return dp[n][W];
    }
}
