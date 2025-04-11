// Given a string s, the objective is to convert it into integer format without utilizing any built-in functions. Refer the below steps to know about atoi() function.

// Cases for atoi() conversion:

// Skip any leading whitespaces.
// Check for a sign (‘+’ or ‘-‘), default to positive if no sign is present.
// Read the integer by ignoring leading zeros until a non-digit character is encountered or end of the string is reached. If no digits are present, return 0.
// If the integer is greater than 231 – 1, then return 231 – 1 and if the integer is smaller than -231, then return -231.

class Solution {
    public int myAtoi(String s) {
        // Your code here
        int sign = 1, res = 0, i = 0;
        
        while(i < s.length() && s.charAt(i) == ' '){
            i++;
        }
        
        if(i<s.length() && (s.charAt(i) == '-' || s.charAt(i) == '+')){
            if(s.charAt(i++) == '-'){
                sign = -1;
            }
        }
        
        while(i < s.length() && s.charAt(i) >= '0' && s.charAt(i) <= '9'){
            
            if(res > Integer.MAX_VALUE / 10 || (res == Integer.MAX_VALUE / 10 && s.charAt(i) - 0 > 7)) {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            
            res = 10 * res + (s.charAt(i++) - '0');
        }
        
        return res * sign ;
        
    }
}