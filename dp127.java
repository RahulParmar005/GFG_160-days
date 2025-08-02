// Stickler the thief wants to loot money from the houses arranged in a line. He cannot loot two consecutive houses and aims to maximize his total loot.
// Given an array, arr[] where arr[i] represents the amount of money in the i-th house.
// Determine the maximum amount he can loot.


class Solution {
    public int findMaxSum(int arr[]) {
        // code here
        int n = arr.length;
        
        if(n == 0) return 0;
        
        if(n == 1) return arr[0];
        
        int secondLast = 0, last = arr[0];
        
        int res = 0;
        for(int i = 1; i < n; i++) {
            res = Math.max(arr[i] + secondLast, last);
            secondLast = last;
            last = res;
        }
        
        return res;
    }
}