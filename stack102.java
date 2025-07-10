// The stock span problem is a financial problem where we have a series of daily price quotes for a stock and we need to calculate the span of stock price for all days. The span arr[i] of the stocks price on a given day i is defined as the maximum number of consecutive days just before the given day, for which the price of the stock on the given day is less than or equal to its price on the current day.


class Solution {
    public ArrayList<Integer> calculateSpan(int[] arr) {
        // write code here
        int n = arr.length;
        Stack<Integer> stack = new Stack<>();
        ArrayList<Integer> res = new ArrayList<>(Collections.nCopies(n, 0));
        
        for(int i = 0; i < n; i++){
            while(!stack.isEmpty() && arr[stack.peek()] <= arr[i]){
                stack.pop();
            }
            
            if(stack.isEmpty()){
                res.set(i, (i + 1));
            } else {
                res.set(i, (i - stack.peek()));
            }
            
            stack.push(i);
        }
        
        return res;
    }
}