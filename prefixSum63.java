// Given an array arr of 0s and 1s. Find and return the length of the longest subarray with equal number of 0s and 1s.
import java.util.HashMap;

class Solution {
    public int maxLen(int[] arr) {
        // Your code here
        int prefSum = 0;
        int res = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(int i = 0; i < arr.length; i++){
            
            prefSum += (arr[i] == 0) ? -1 : 1;
            
            if(prefSum == 0){
                res = i + 1;
            }
            
            if(map.containsKey(prefSum)){
                res = Math.max(res, i - map.get(prefSum));
            } else {
                map.put(prefSum, i);
            }
        }
        return res;
    }
}