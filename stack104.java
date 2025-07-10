// Given an array of integers arr[], the task is to find the maximum of the minimum values for every possible window size in the array, where the window size ranges from 1 to arr.size().

// More formally, for each window size k, determine the smallest element in all windows of size k, and then find the largest value among these minimums where 1<=k<=arr.size().


class Solution {
    public ArrayList<Integer> maxOfMins(int[] arr) {
        // Your code here
        int n = arr.length;
        Stack<Integer> s = new Stack<>();
        ArrayList<Integer> res = new ArrayList<>(Collections.nCopies(n, 0));
        ArrayList<Integer> res2 = new ArrayList<>(Collections.nCopies(n, 0));
        
        for(int i = 0; i < n; i++) {
            while(!s.isEmpty() && arr[s.peek()] >= arr[i]){
                int top = s.pop();
                int windoSize = s.isEmpty() ? i : i - s.peek() - 1;
                res2.set(top, windoSize);
            }
            s.push(i);
        }
        
        while(!s.isEmpty()){
            int top = s.pop();
            int windowSize = s.isEmpty() ? n : n - s.peek() - 1;
            res2.set(top, windowSize);
        }
        
        for(int i = 0; i < n; i++){
            int windowSize = res2.get(i) - 1;
            res.set(windowSize, Math.max(res.get(windowSize), arr[i]));
        }
        
        for(int i = n - 2; i >= 0; i--){
            res.set(i, Math.max(res.get(i), res.get(i + 1)));
        }
        
        return res;
    }
}