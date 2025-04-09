// You are given an integer array arr[]. Your task is to find the smallest positive number missing from the array.

// Note: Positive number starts from 1. The array can have negative integers too.

import java.util.Arrays;

class Solution {
    // Function to find the smallest positive number missing from the array.
    public int missingNumber(int[] arr) {
        // Your code here
        
        Arrays.sort(arr);
        int res = 1;
        
        for(int i=0; i<arr.length; i++){
            
            if(arr[i] == res){
                res ++;
            }else if(arr[i] > res){
                break;
            }
        }
        return res;
    }
}
