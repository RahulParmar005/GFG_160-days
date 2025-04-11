// Given two binary strings s1 and s2 consisting of only 0s and 1s. Find the resultant string after adding the two Binary Strings.
// Note: The input strings may contain leading zeros but the output string should not have any leading zeros.

class Solution {
    public String addBinary(String s1, String s2) {
        // code here
        s1 = s1.replaceFirst("^0+(?!$)", "");
        s2 = s2.replaceFirst("^0+(?!$)", "");
        
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        int i = s1.length() - 1, j = s2.length() - 1;
        
        while(i >= 0 || j >= 0 || carry > 0) {
            int bit1 = (i >=0) ? s1.charAt(i) - '0' : 0;
            int bit2 = (j >=0) ? s2.charAt(j) - '0' : 0;
            
            int sum = bit1 + bit2 + carry;
            sb.append(sum % 2);
            carry = sum / 2;
            
            i--;
            j--;
        }
        
        return sb.reverse().toString();
        
    }
}