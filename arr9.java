// Given an array arr[] denoting heights of N towers and a positive integer K.

// For each tower, you must perform exactly one of the following operations exactly once.

// Increase the height of the tower by K
// Decrease the height of the tower by K
// Find out the minimum possible difference between the height of the shortest and tallest towers after you have modified each tower.

// You can find a slight modification of the problem here.
// Note: It is compulsory to increase or decrease the height by K for each tower. After the operation, the resultant array should not contain any negative integers.

import java.util.*;

class Solution {
    int getMinDiff(int[] arr, int k) {
        // code here
        int n = arr.length;
        
        if(n == 1) return 0;
        
        Arrays.sort(arr);                     
        
        int minHi = arr[0];
        int maxHi = arr[n-1];
        int res = maxHi - minHi;
        
        for(int i=1; i<n; i++){
            
            if(arr[i] - k < 0) continue;
                
            minHi = Math.min(arr[0]+k, arr[i]-k);
            maxHi = Math.max(arr[i-1]+k, arr[n-1]-k);
                
            res = Math.min(res, maxHi - minHi);
            
        }
        return res;
    }
}