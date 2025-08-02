// In daily share trading, a trader buys shares and sells them on the same day. If the trader is allowed to make at most 2 transactions in a day, find out the maximum profit that a share trader could have made.

// You are given an array prices[] representing stock prices throughout the day. Note that the second transaction can only start after the first one is complete (buy->sell->buy->sell).



class Solution {
    public static int maxProfit(int[] prices) {
        // code here
        int n = prices.length;
        if(n == 0) return 0;
        
        int[][] curr = new int[3][2];
        int[][] next = new int[3][2];
        
        for(int i = n - 1; i >= 0; i--) {
            for(int j = 1; j <= 2; j++) {
                curr[j][1] = Math.max(-prices[i] + next[j][0], next[j][1]);
                curr[j][0] = Math.max(prices[i] + next[j - 1][1], next[j][0]);
            }
            next = curr.clone();
        }
        
        return curr[2][1];
    }
}
