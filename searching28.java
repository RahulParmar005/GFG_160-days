pu// Given a sorted array, arr[] and a number target, you need to find the number of occurrences of target in arr[]. 

class Solution {
    int countFreq(int[] arr, int target) {
        // code here
        return upperBound(arr, target) - lowerBound(arr, target);
    }
    
    static int lowerBound(int arr[], int target){
        int res = arr.length;
        int lo = 0, hi = arr.length - 1;
        while(lo <= hi){
            int mid = lo + (hi - lo) / 2;
            if(arr[mid] >= target) {
                res = mid;
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        return res;
    }
    
    static int upperBound(int arr[], int target){
        int res = arr.length;
        int lo = 0, hi = arr.length - 1;
        while(lo <= hi){
            int mid = lo + (hi - lo) / 2;
            if(arr[mid] > target) {
                res = mid;
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        return res;
    }
}
