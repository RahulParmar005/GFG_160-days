// You are given an array of integer arr[] where each number represents a vote to a candidate. Return the candidates that have votes greater than one-third of the total votes, If there's not a majority vote, return an empty array. 

// Note: The answer should be returned in an increasing format.

import java.util.*;

public class arr6 {
    
}


class Solution {
    // Function to find the majority elements in the array
    public List<Integer> findMajority(int[] nums) {
        // Your code goes here.
        List<Integer> ll = new ArrayList<>();
        Arrays.sort(nums);
        int s = nums.length;
        int same = 1;
        int count = s/3;
        for(int i =1;i<s;i++){
            // System.out.println("same ="+same);
            if(nums[i-1]!=nums[i]){
                if(same>count){
                    ll.add(nums[i-1]);
                 }
                 same =1;
            }else{
                same++;
                // System.out.println("same number ="+nums[i]+same+"times");
            }
        }
        if(same>count){
            ll.add(nums[s-1]);
        }
        return ll;
    }
}
