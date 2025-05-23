// Given an array arr[] containing only non-negative integers, your task is to find a continuous subarray (a contiguous sequence of elements) whose sum equals a specified value target. You need to return the 1-based indices of the leftmost and rightmost elements of this subarray. You need to find the first subarray whose sum is equal to the target.

// Note: If no such array is possible then, return [-1].
import java.util.*;




class Solution {
    static ArrayList<Integer> subarraySum(int[] arr, int target) {
        // code here
        int start = 0, end = 0;
        ArrayList<Integer> res = new ArrayList<>();
        int currSum = 0;
        
        for(int i = 0; i < arr.length; i++){
            currSum += arr[i];
            
            if(currSum >= target){
                end = i;
                
                while(currSum > target && start < end){
                    currSum -= arr[start];
                    start++;
                }
                
                if(currSum == target){
                    res.add(start + 1);
                    res.add(end + 1);
                    return res;
                }
            }
        }
        res.add(-1);
        return res;
    }
}