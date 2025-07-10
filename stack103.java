// You are given a histogram represented by an array arr, where each element of the array denotes the height of the bars in the histogram. All bars have the same width of 1 unit.

// Your task is to find the largest rectangular area possible in the given histogram, where the rectangle can be formed using a number of contiguous bars.


class Solution {
    public static int getMaxArea(int arr[]) {
        // your code here
        int n = arr.length;
        Stack<Integer> s = new Stack<>();
        int res = 0, pre, curr;
        
        for(int i = 0; i < n; i++){
            
            while(!s.isEmpty() && arr[s.peek()] >= arr[i]){
                pre = s.pop();
                int width = s.isEmpty() ? i : i - s.peek() - 1;
                
                res = Math.max(res, arr[pre] * width);
            }
            s.push(i);
        }
        
        while(!s.isEmpty()) {
            pre = s.pop();
            curr = arr[pre] * (s.isEmpty() ? n : n - s.peek() - 1);
            res = Math.max(res, curr);
        }
        return res;
    }
}