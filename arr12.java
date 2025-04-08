// Given an array of integers arr[] in a circular fashion. Find the maximum subarray sum that we can get if we assume the array to be circular.

class Solution {

    // a: input array
    // n: size of array
    // Function to find maximum circular subarray sum.
    public int circularSubarraySum(int arr[]) {

        // Your code here
        int totalSum = 0;
        int currMax = 0;
        int currMin = 0;
        int maxSum = arr[0];
        int minSum = arr[0];
        
        for(int i=0; i<arr.length; i++){
            currMax = Math.max(arr[i] + currMax, arr[i]);
            maxSum = Math.max(currMax, maxSum);
            
            currMin = Math.min(arr[i] + currMin, arr[i]);
            minSum = Math.min(currMin, minSum);
            totalSum += arr[i];
            
        }
        
        int circularSum = totalSum - minSum;
        
        if(minSum == totalSum){
                return maxSum;
            }
        
        return Math.max(maxSum, circularSum);
    }
}
