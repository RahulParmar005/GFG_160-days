// Given an array arr[] containing only 0s, 1s, and 2s. Sort the array in ascending order.

// You need to solve this problem without utilizing the built-in sort function.

class Solution {
    // Function to sort an array of 0s, 1s, and 2s
    public void sort012(int[] arr) {
        // code here
        int n = arr.length;
        int lo = 0;
        int mi = 0;
        int hi = n - 1;
        
        for(int i=0; i<n; i++){
            
            if(arr[mi] == 0){    // condition for 0s
                swap(arr, mi , lo);
                mi++;
                lo++;
            } else if(arr[mi] == 1){    //condition for 1s
                mi++;
            } else{
                swap(arr, mi, hi);
                hi--;
            }
        }
        
    }
    public void swap(int arr[], int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}