// Given a string s, count all palindromic sub-strings present in the string. The length of the palindromic sub-string must be greater than or equal to 2.

// Note: A substring is palindromic if it reads the same forwards and backwards.


class Solution {
    public int countPS(String s) {
        // code here
        int n = s.length();
        int res = 0;
        
        boolean[][] dp = new boolean[n][n];
        for(int i = 0; i < n; i++) {
            dp[i][i] = true;
        }
        
        for(int i = 0; i < n - 1; i++) {
            if(s.charAt(i) == s.charAt(i + 1)) {
                dp[i][i + 1] = true;
                res++;
            }
        }
        
        for(int gap = 2; gap < n; gap++) {
            for(int i = 0; i < n - gap; i++) {
                int j = i + gap;
                
                if(s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1]) {
                    dp[i][j] = true;
                    res++;
                }
            }
        }
        
        return res;
    }
}