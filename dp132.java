// You are given a string s and a list dictionary[] of words. Your task is to determine whether the string s can be formed by concatenating one or more words from the dictionary[].

// Note: From dictionary[], any word can be taken any number of times and in any order.


class Solution {
    public boolean wordBreak(String s, String[] dictionary) {
        // code here
        int n = s.length();
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;
        
        for(int i = 1; i <= n; i++) {
            for(String w : dictionary) {
                int start = i - w.length();
                if(start >= 0 && dp[start] && s.substring(start, start + w.length()).equals(w)) {
                    dp[i] = true;
                    break;
                }
            }
        }
        
        return dp[n];
    }
}