// pYou are given an array arr[] of non-negative numbers. Each number tells you the maximum number of steps you can jump forward from that position.

// For example:

// If arr[i] = 3, you can jump to index i + 1, i + 2, or i + 3 from position i.
// If arr[i] = 0, you cannot jump forward from that position.
// Your task is to find the minimum number of jumps needed to move from the first position in the array to the last position.

// Note:  Return -1 if you can't reach the end of the array.
class Solution {
    static int minJumps(int[] arr) {
        // code here
        int n = arr.length;
        
        if(arr[0] == 0) return -1;
        
        int maxReach = 0;
        int currReach = 0;
        int jump = 0;
        
        for(int i = 0; i < n; i++) {
            maxReach = Math.max(maxReach, i + arr[i]);
            if(maxReach >= n - 1) {
                return jump + 1;
            } 
            
            if(i == currReach) {
                if(i == maxReach) {
                    return -1;
                } else {
                    jump++;
                    currReach = maxReach;
                }
            }
        }
        
        return -1;
    }
}