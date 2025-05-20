// Given an array arr[] and a number target, find a pair of elements (a, b) in arr[], where a<=b whose sum is closest to target.
// Note: Return the pair in sorted order and if there are multiple such pairs return the pair with maximum absolute difference. If no such pair exists return an empty array.
import java.util.*;


class Solution {
    public List<Integer> sumClosest(int[] arr, int target) {
        // code here
        int n = arr.length;
        Arrays.sort(arr);
        List<Integer> res = new ArrayList<>();
        int minDif = Integer.MAX_VALUE;
        
        int left = 0, right = n - 1;
        
        while(left < right){
            int sum = arr[left] + arr[right];
            
            if(Math.abs(target - sum) < minDif){
                minDif = Math.abs(target - sum);
                res = Arrays.asList(arr[left], arr[right]);
            }
            
            if(sum < target){
                left++;
            } else if(sum > target){
                right--;
            } else {
                return res;
            }
        }
        return res;
    }
}