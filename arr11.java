// Given an array arr[] that contains positive and negative integers (may contain 0 as well). Find the maximum product that we can get in a subarray of arr[].

// Note: It is guaranteed that the output fits in a 32-bit integer.

class Solution {
    // Function to find maximum product subarray
    int maxProduct(int[] arr) {
        // code here
        
        // time complexity = O(n);
        // space complexity = O(1);
        
        int currMin = arr[0];
        int currMax = arr[0];
        int maxProduct = arr[0];
        
        for(int i=1; i<arr.length; i++){
            
            int A =  Math.max(arr[i] * currMin, arr[i] * currMax);
            int B =  Math.min(arr[i] * currMin, arr[i] * currMax);
             
            int temp = Math.max(arr[i], A);
            currMin = Math.min(arr[i], B);
            currMax = temp;
             
            maxProduct = Math.max(maxProduct, currMax);
             
        }
         
        return maxProduct;
         
    }
}