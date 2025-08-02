// Given a string s, return the length of the longest palindromic subsequence.

// A subsequence is a sequence that can be derived from the given sequence by deleting some or no elements without changing the order of the remaining elements.

// A palindromic sequence is a sequence that reads the same forward and backward.


// User function Template for Java

class Solution {
    public int longestPalinSubseq(String s) {
        // code here
        int n = s.length();
        int[] curr = new int[n];
        int[] prev = new int[n];
        
        for(int i = n - 1; i >= 0; --i) {
            curr[i] = 1;
            
            for(int j = i + 1; j < n; ++j) {
                if(s.charAt(i) == s.charAt(j)) {
                    curr[j] = prev[j - 1] + 2;
                } else {
                    curr[j] = Math.max(prev[j], curr[j - 1]);
                }
            }
            
            prev = curr.clone();
        }
        
        return curr[n - 1];
    }
}