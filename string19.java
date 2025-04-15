// Given a string s, the task is to find the minimum characters to be added at the front to make the string palindrome.

// Note: A palindrome string is a sequence of characters that reads the same forward and backward.

class Solution {
    public static int minChar(String s) {
        // Write your code here
        int m  = s.length();
        String rev = new StringBuilder(s).reverse().toString();
        s = s + "$" + rev;
        
        int lps[] = createLps(s);
        
        return (m - lps[lps.length - 1]);
    }
    
    static int[] createLps(String s){
        int m = s.length();
        int lps[] = new int[m];
        
        int n = 0;
        lps[0] = 0;
        int i = 1;
        while(i < m){
            if(s.charAt(i) == s.charAt(n)){
                n++;
                lps[i] = n;
                i++;
            }else {
                if(n != 0){
                    n = lps[n - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }
        return lps;
    }
}