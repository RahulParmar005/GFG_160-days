// Given a data stream arr[] where integers are read sequentially, the task is to determine the median of the elements encountered so far after each new integer is read.

// There are two cases for median on the basis of data set size.

// 1. If the data set has an odd number then the middle one will be consider as median.
// 2. If the data set has an even number then there is no distinct middle value and the median will be the arithmetic mean of the two middle values.


class Solution {
    public ArrayList<Double> getMedian(int[] arr) {
        // code here
        PriorityQueue<Integer> leftMaxHeap = new PriorityQueue<>((a, b) -> b -a);
        PriorityQueue<Integer> rightMinHeap = new PriorityQueue<>();
        
        ArrayList<Double> res = new ArrayList<>();
        
        for(int i = 0; i < arr.length; i++){
            leftMaxHeap.add(arr[i]);
            
            int temp = leftMaxHeap.poll();
            rightMinHeap.add(temp);
            
            if(rightMinHeap.size() > leftMaxHeap.size()){
                temp = rightMinHeap.poll();
                leftMaxHeap.add(temp);
            }
            
            double median;
            if(leftMaxHeap.size() != rightMinHeap.size()){
                median = leftMaxHeap.peek();
            } else {
                median = (leftMaxHeap.peek() + rightMinHeap.peek()) / 2.0;
            }
            res.add(median);
        }
        return res;
    }
}