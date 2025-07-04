// Given a string s, composed of different combinations of '(' , ')', '{', '}', '[', ']', verify the validity of the arrangement.
// An input string is valid if:

//          1. Open brackets must be closed by the same type of brackets.
//          2. Open brackets must be closed in the correct order.


class Solution {
    static boolean isBalanced(String s) {
        // code here
        Stack<Character> st = new Stack<>();
        
        for(int i = 0; i < s.length(); i++){
            
            if(s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '[') {
                st.push(s.charAt(i));
            } else {
                
                if(!st.empty() && ((st.peek() == '(' && s.charAt(i) == ')') || (st.peek() == '{' && s.charAt(i) == '}') || (st.peek() == '[' && s.charAt(i) == ']') )){
                    st.pop();
                } else {
                    return false;
                }
            }
        }
        
        return st.empty();
    }
}