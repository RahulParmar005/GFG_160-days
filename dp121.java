// You are given an array coins[], where each element represents a coin of a different denomination, and a target value sum. You have an unlimited supply of each coin type {coins1, coins2, ..., coinsm}.

// Your task is to determine the minimum number of coins needed to obtain the target sum. If it is not possible to form the sum using the given coins, return -1.



class Solution {

    public int minCoins(int coins[], int sum) {
        // code here
        int dp[] = new int[sum + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        
        dp[0] = 0;
        
        for(int i = coins.length - 1; i >= 0; i--) {
            for(int j = 1; j <= sum; j++) {
                int take = Integer.MAX_VALUE, nonTake = Integer.MAX_VALUE;
                
                if(j - coins[i] >= 0 && coins[i] > 0) {
                    take = dp[j - coins[i]];
                    
                    if(take != Integer.MAX_VALUE) take++;
                }
                
                if(i + 1 < coins.length) nonTake = dp[j];
                
                dp[j] = Math.min(take, nonTake);
            }
        }
        
        return dp[sum] != Integer.MAX_VALUE ? dp[sum] : -1;
    }
}