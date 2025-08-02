// in the stock market, a person buys a stock and sells it on some future date. You are given an array prices[] representing stock prices on different days and a positive integer k, find out the maximum profit a person can make in at-most k transactions.

// A transaction consists of buying and subsequently selling a stock and new transaction can start only when the previous transaction has been completed.



class Solution {
    static int maxProfit(int prices[], int k) {
        // code here
        int n = prices.length;
        if(n == 0 || k == 0) return 0;
        
        int[][] curr = new int[k + 1][2];
        int[][] next = new int[k + 1][2];
        
        for(int i = n - 1; i >= 0; i--) {
            
            for(int j = 1; j <= k; j++) {
                curr[j][1] = Math.max(-prices[i] + next[j][0], next[j][1]);
                curr[j][0] = Math.max(prices[i] + next[j - 1][1], next[j][0]);
            }
            
            for(int j = 0; j <= k; j++) {
                next[j][0] = curr[j][0];
                next[j][1] = curr[j][1];
            }
        }
        
        return curr[k][1];
    }
}