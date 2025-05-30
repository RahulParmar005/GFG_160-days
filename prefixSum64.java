// Given an array, arr[] construct a product array, res[] where each element in res[i] is the product of all elements in arr[] except arr[i]. Return this resultant array, res[].
// Note: Each element is res[] lies inside the 32-bit integer range.
import java.util.*;

class Solution {
    public static int[] productExceptSelf(int arr[]) {
        // code here
        int zeros = 0;
        int idx = -1;
        int product = 1;
        
        for(int i = 0; i < arr.length; i++){
            if(arr[i] == 0){
                zeros++;
                idx = i;
            } else {
                product *= arr[i];
            }
        }
        
        int res[] = new int[arr.length];
        Arrays.fill(res, 0);
        
        if(zeros == 0){
            for(int i = 0; i < arr.length; i++){
                res[i] = product / arr[i];
            }
        } else if(zeros == 1){
            res[idx] = product;
        }
        
        return res;
    }
}
