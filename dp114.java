// Longest Palindrome in a String
// Difficulty: MediumAccuracy: 23.2%Submissions: 337K+Points: 4
// Given a string s, your task is to find the longest palindromic substring within s.

// A substring is a contiguous sequence of characters within a string, defined as s[i...j] where 0 ≤ i ≤ j < len(s).

// A palindrome is a string that reads the same forward and backward. More formally, s is a palindrome if reverse(s) == s.

// Note: If there are multiple palindromic substrings with the same length, return the first occurrence of the longest palindromic substring from left to right.




class Solution {
    static String longestPalindrome(String s) {
        // code here
        if(s == null || s.length() == 0) return "";
        
        StringBuilder t = new StringBuilder("^"); 
        for(char ch : s.toCharArray()) {
            t.append("#").append(ch);
        }
        t.append("#$");
        
        int n = t.length();
        int[] p = new int[n];
        
        int center = 0, right = 0;
        for(int i = 1; i < n - 1; i++) {
            int mirror = 2 * center - i;
            
            if(i < right) {
                p[i] = Math.min(right - i, p[mirror]);
            }
            
            while(t.charAt(i + 1 + p[i]) == t.charAt(i - 1 - p[i])) {
                p[i]++;
            }
            
            if(i + p[i] > right) {
                center = i;
                right = i + p[i];
            }
        }
        int maxLen = 0, centerIndex = 0;
        
        for(int i = 1; i < n - 1; i++) {
            if(p[i] > maxLen) {
                maxLen = p[i];
                centerIndex = i;
            }
        }
        
        int start = (centerIndex - maxLen) / 2;
        return s.substring(start, start + maxLen);
    }
}