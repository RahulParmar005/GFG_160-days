// A sorted array of distinct elements arr[] is rotated at some unknown point, the task is to find the minimum element in it. 

class Solution {
    public int findMin(int[] arr) {
        // complete the function here
        int lo = 0, hi = arr.length - 1;
        while(lo < hi){
            if(arr[lo] < arr[hi]) return arr[lo];
            
            int mid = lo + (hi - lo) / 2;
            
            if(arr[mid] > arr[hi]){
                lo = mid + 1;
            }else {
                hi = mid;
            }
        }
        return arr[lo];
    }
}