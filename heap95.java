// Given an array arr[] of positive integers and an integer k, Your task is to return k largest elements in decreasing order. 


class Solution {
    public ArrayList<Integer> kLargest(int[] arr, int k) {
        // Your code here
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for(int i = 0; i < k; i++){
            minHeap.add(arr[i]);
        }
        
        for(int i = k; i < arr.length; i++){
            if(arr[i] > minHeap.peek()){
                minHeap.poll();
                minHeap.add(arr[i]);
            }
        }
        
        ArrayList<Integer> res = new ArrayList<>();
        while(!minHeap.isEmpty()){
            res.add(minHeap.poll());
        }
        
        Collections.reverse(res);
        return res;
    }
}