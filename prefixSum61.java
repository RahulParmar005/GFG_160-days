// Given an array of integers arr[], the task is to find the first equilibrium point in the array.

// The equilibrium point in an array is an index (0-based indexing) such that the sum of all elements before that index is the same as the sum of elements after it. Return -1 if no such point exists. 



class Solution {
    // Function to find equilibrium point in the array.
    public static int findEquilibrium(int arr[]) {
        // code here
        int prefSum = 0, total = 0;
        
        for(int num : arr){
            total += num;
        }
        
        for(int pivot = 0; pivot < arr.length; pivot++){
            int sufSum = total - prefSum - arr[pivot];
            
            if(prefSum == sufSum){
                return pivot;
            }
            
            prefSum += arr[pivot];
        }
        
        return -1;
    }
}
