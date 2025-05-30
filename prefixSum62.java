// Given an array arr[] containing integers and an integer k, your task is to find the length of the longest subarray where the sum of its elements is equal to the given value k. If there is no subarray with sum equal to k, return 0.\
import java.util.HashMap;



class Solution {
    public int longestSubarray(int[] arr, int k) {
        // code here
        int res = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        int prefSum = 0;
        
        for(int i = 0; i < arr.length; i++){
            prefSum += arr[i];
            
            if(prefSum == k){
                res = i + 1;
            } else if(map.containsKey(prefSum - k)){
                res = Math.max(res, i - map.get(prefSum - k));
            }
            
            if(!map.containsKey(prefSum)){
               map.put(prefSum, i);
            }
        }
        return res;
    }
}
