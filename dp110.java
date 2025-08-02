// Given an array arr[] of non-negative integers, the task is to find the length of the Longest Strictly Increasing Subsequence (LIS).

// A subsequence is strictly increasing if each element in the subsequence is strictly less than the next element.

class Solution {
    static int lis(int arr[]) {
        // code here
        int n = arr.length;
        ArrayList<Integer> res = new ArrayList<>();
        
        res.add(arr[0]);
        
        for(int i = 1; i < n; i++) {
            if(arr[i] > res.get(res.size() - 1)) {
                res.add(arr[i]);
            } else {
                int low = Collections.binarySearch(res, arr[i]);
                
                if(low < 0) {
                    low = -(low + 1);
                }
                res.set(low, arr[i]);
            }
        }
        
        return res.size();
    }
}