// Given an array of positive integers arr[] and a non-negative integer x, the task is to find the longest sub-array where the absolute difference between any two elements is not greater than x.
// If multiple such subarrays exist, return the one that starts at the smallest index.


class Solution {
    public ArrayList<Integer> longestSubarray(int[] arr, int x) {
        // code here
        Deque<Integer> maxQueue = new LinkedList<>();
        Deque<Integer> minQueue = new LinkedList<>();
        
        int n = arr.length, start = 0, end = 0;
        int reStart = 0, reEnd = 0;
        
        while(end < n) {
            while(!minQueue.isEmpty() && arr[minQueue.peekLast()] > arr[end]) {
                minQueue.pollLast();
            }
            
            while(!maxQueue.isEmpty() && arr[maxQueue.peekLast()] < arr[end]) {
                maxQueue.pollLast();
            }
            
            minQueue.addLast(end);
            maxQueue.addLast(end);
            
            while(arr[maxQueue.peekFirst()] - arr[minQueue.peekFirst()] > x) {
                if(start == minQueue.peekFirst()) {
                    minQueue.pollFirst();
                }
                if(start == maxQueue.peekFirst()) {
                    maxQueue.pollFirst();
                }
                start += 1;
            }
            
            if(end - start > reEnd - reStart) {
                reStart = start;
                reEnd = end;
            }
            end += 1;
        }
        
        ArrayList<Integer> res = new ArrayList<>();
        for(int i = reStart; i <= reEnd; i++) {
            res.add(arr[i]);
        }
        
        return res;
        
        
    }
}