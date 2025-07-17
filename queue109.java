// Given an array arr[] of integers and an integer k, your task is to find the maximum value for each contiguous subarray of size k. The output should be an array of maximum values corresponding to each contiguous subarray.


class Solution {
    static ArrayList<Integer> maxOfSubarrays(int[] arr, int k) {
        // code here
        int n = arr.length;
        ArrayList<Integer> res = new ArrayList<>();
        Deque<Integer> dq = new ArrayDeque<Integer>();
        
        for(int i = 0; i < k; i++) {
            while(!dq.isEmpty() && arr[i] >= arr[dq.peekLast()]) {
                dq.pollLast();
            }
            dq.addLast(i);
        }
        
        for(int i = k; i < n; ++i) {
            res.add(arr[dq.peekFirst()]);
            
            while(!dq.isEmpty() && dq.peekFirst() <= i -k) {
                dq.pollFirst();
            }
            
            while(!dq.isEmpty() && arr[i] >= arr[dq.peekLast()]) {
                dq.pollLast();
            }
            
            dq.addLast(i);
        }
        
        res.add(arr[dq.peekFirst()]);
        
        return res;
        
    }
}