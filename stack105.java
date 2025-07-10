// Given q queries, You task is to implement the following four functions for a stack:

// push(x) – Insert an integer x onto the stack.
// pop() – Remove the top element from the stack.
// peek() - Return the top element from the stack. If the stack is empty, return -1.
// getMin() – Retrieve the minimum element from the stack in O(1) time. If the stack is empty, return -1.
// Each query can be one of the following:

// 1 x : Push x onto the stack.
// 2 : Pop the top element from the stack.
// 3: Return the top element from the stack. If the stack is empty, return -1.
// 4: Return the minimum element from the stack.


class Solution {
    private Stack<Integer> s;
    private int minEle;
    
    public Solution() {
        s = new Stack<>();
        minEle = -1;
    }

    // Add an element to the top of Stack
    public void push(int x) {
        // code here
        if(s.isEmpty()) {
            minEle = x;
            s.push(x);
        } else if(x < minEle) {
            s.push(2 * x - minEle);
            minEle = x;
        } else {
            s.push(x);
        }
    }

    // Remove the top element from the Stack
    public void pop() {
        // code here
        if(s.isEmpty()) {
            return;
        }
        int top = s.pop();
        
        if(top < minEle) {
            minEle = 2 * minEle - top;
        }
    }

    // Returns top element of the Stack
        
    public int peek() {
        // code here
        if(s.isEmpty()) {
            return -1;
        }
        int top = s.peek();
        
        return (minEle > top) ? minEle : top;
    }

        
    // Finds minimum element of Stack
    public int getMin() {
        // code here
        if(s.isEmpty()) {
            return -1;
        }
        
        return minEle;
    }
}