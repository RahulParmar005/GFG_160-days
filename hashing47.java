// Given an array arr[] of non-negative integers. Find the length of the longest sub-sequence such that elements in the subsequence are consecutive integers, the consecutive numbers can be in any order.

import java.util.*;;

class Solution {

    // Function to return length of longest subsequence of consecutive integers.
    public int longestConsecutive(int[] arr) {
        // code here
        HashSet<Integer> set = new HashSet<>();
        int res = 0;
        
        for(int val : arr){
            set.add(val);
        }
        
        for(int val : arr){
            if(set.contains(val) && !set.contains(val - 1)){
                int count = 0;
                int cur = val;
                
                while(set.contains(cur)){
                    set.remove(cur);
                    count++;
                    cur++;
                }
                res = Math.max(res, count);
            }
        }
        return res;
    }
}