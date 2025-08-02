// Given an array of positive integers arr[] and a value sum, determine if there is a subset of arr[] with sum equal to given sum. 


class Solution {

    static Boolean isSubsetSum(int arr[], int sum) {
        // code here
        int n = arr.length;
        boolean[] prev = new boolean[sum + 1];
        boolean[] curr = new boolean[sum + 1];
        
        prev[0] = true;
        for(int i = 1; i <= n; i++) {
            for(int j = 0; j <= sum; j++) {
                if(j < arr[i - 1]) {
                    curr[j] = prev[j];
                } else {
                    curr[j] = prev[j] || prev[j - arr[i - 1]];
                }
                    
            }
            
            System.arraycopy(curr, 0, prev, 0, sum + 1);
        }
        
        return prev[sum];
    }
}