// You are given an array arr[] which represents houses arranged in a circle, where each house has a certain value. A thief aims to maximize the total stolen value without robbing two adjacent houses.
// Determine the maximum amount the thief can steal.

// Note: Since the houses are in a circle, the first and last houses are also considered adjacent.


class Solution {
    int maxValue(int[] arr) {
        // code here
        int n = arr.length;
        if(n == 0) return 0;
        if(n == 1) return arr[0];
        
        return Math.max(maxValueTab(0 , n - 2, arr), maxValueTab(1, n - 1, arr));
    }
    
    int maxValueTab(int x, int y, int[] arr) {
        int prev1 = 0, prev2 = 0;
        for(int i = x; i <= y; i++) {
            int curr = Math.max(prev1, prev2 + arr[i]);
            prev2 = prev1;
            prev1 = curr;
        }
        
        return prev1;
    }
}
