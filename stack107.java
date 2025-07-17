// Given an encoded string s, the task is to decode it. The encoding rule is :

// k[encodedString], where the encodedString inside the square brackets is being repeated exactly k times. Note that k is guaranteed to be a positive integer, and encodedString contains only lowercase english alphabets.
// Note: The test cases are generated so that the length of the output string will never exceed 105 .



class Solution {
    static String decodeString(String s) {
        // code here
        int n = s.length();
        Stack<String> stack = new Stack<>();
        
        for(int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if(ch != ']') {
                stack.push(ch + "");
            } else {
                StringBuilder temp = new StringBuilder();
                
                while(!stack.isEmpty() && !stack.peek().equals("[")) {
                    temp.append(stack.pop());
                }
                temp.reverse();
                stack.pop();
                
                StringBuilder num = new StringBuilder();
                
                while(!stack.isEmpty() && Character.isDigit(stack.peek().charAt(0))) {
                    num.insert(0, stack.pop());
                }
                
                int number = Integer.parseInt(num.toString());
                StringBuilder repeat = new StringBuilder();
                
                for(int j = 0; j < number; j++) {
                    repeat.append(temp);
                }
                
                for(char c : repeat.toString().toCharArray()) {
                    stack.push(c + "");
                }
            }
        }
        
        StringBuilder res = new StringBuilder();
        
        while(!stack.isEmpty()) {
            res.append(stack.pop());
        }
        
        res.reverse();
        return res.toString();
    }
}