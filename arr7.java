// The cost of stock on each day is given in an array price[]. Each day you may decide to either buy or sell the stock i at price[i], you can even buy and sell the stock on the same day. Find the maximum profit that you can get.

// Note: A stock can only be sold if it has been bought previously and multiple stocks cannot be held on any given day.

public class arr7 {
    
}


class Solution {
    public int maximumProfit(int prices[]) {
        // code here
        int profit = 0;
        
        for(int i=1; i<prices.length; i++){
            if(prices[i] > prices[i-1]){
                profit += prices[i] - prices[i-1];
            }
        }
        return profit;
    }
}