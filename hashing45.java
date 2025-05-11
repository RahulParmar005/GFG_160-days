// Given two integer arrays a[] and b[], you have to find the intersection of the two arrays. Intersection of two arrays is said to be elements that are common in both arrays. The intersection should not have duplicate elements and the result should contain items in any order.

// Note: The driver code will sort the resulting array in increasing order before printing.
import java.util.*;


class Solution {
    public ArrayList<Integer> intersectionWithDuplicates(int[] a, int[] b) {
        // code here
        HashSet<Integer> set = new HashSet<>();
        
        for(int num : a){
            set.add(num);
        }
        
        ArrayList<Integer> ans = new ArrayList<>();
        
        for(int nums : b){
            if(set.contains(nums)){
                ans.add(nums);
                set.remove(nums);
            }
        }
        
        return ans;
    }
}