// Given an array arr[] where no two adjacent elements are same, find the index of a peak element. An element is considered to be a peak if it is greater than its adjacent elements (if they exist). If there are multiple peak elements, return index of any one of them. The output will be "true" if the index returned by your function is correct; otherwise, it will be "false".

// Note: Consider the element before the first element and the element after the last element to be negative infinity.

class Solution {

    public int peakElement(int[] arr) {
        // code here
        // Time Complexity : O(log n);
        // Space Complexity : O(1);
        
        int n = arr.length;
        
        if(n == 1) return 0;
        
        if(arr[0] > arr[1]) return 0;
        
        if(arr[n - 1] > arr[n - 2]) return n-1;
        
        int lo = 1;
        int hi = n-2;
        while(lo <= hi){
            int mid = lo + (hi - lo) / 2;
            
            if(arr[mid] > arr[mid - 1] && arr[mid] > arr[mid + 1]) return mid;
            
            if(arr[mid] < arr[mid + 1]){
                lo = mid + 1;
            }else {
                hi = mid - 1;
            }
        }
        return 0;
    }
}
