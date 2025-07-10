// Given an array arr[ ] of integers, the task is to find the next greater element for each element of the array in order of their appearance in the array. Next greater element of an element in the array is the nearest element on the right which is greater than the current element.
// If there does not exist next greater of current element, then next greater element for current element is -1. For example, next greater of the last element is always -1.


class Solution {
    public ArrayList<Integer> nextLargerElement(int[] arr) {
        // code here
        int n =arr.length;
        ArrayList<Integer> res = new ArrayList<>();
        Stack<Integer> check = new Stack<>();
        
        for(int i = 0; i < n; i++){
            res.add(-1);
        }
        
        for(int i = n - 1; i >= 0; i--){
            
            while(!check.isEmpty() && check.peek() <= arr[i]){
                check.pop();
            }
            if(!check.isEmpty()){
                res.set(i, check.peek());
            }
            check.push(arr[i]);
        }
        return res;
        
    }
}