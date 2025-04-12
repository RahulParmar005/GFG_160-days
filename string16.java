// Given two strings s1 and s2 consisting of lowercase characters. The task is to check whether two given strings are an anagram of each other or not. An anagram of a string is another string that contains the same characters, only the order of characters can be different. For example, "act" and "tac" are an anagram of each other. Strings s1 and s2 can only contain lowercase alphabets.

// Note: You can assume both the strings s1 & s2 are non-empty.


class Solution {
    // Function is to check whether two strings are anagram of each other or not.
    public static boolean areAnagrams(String s1, String s2) {

        // Your code here
        // if length are diffrent then return false
        if(s1.length() != s2.length()) return false;
        
        // create a frequency array of both strings
        int[] frequency = new int[26];
        
        // increase the frequency for characters in string s1 and decrease for s2
        for(int i=0; i<s1.length(); i++){
            frequency[s1.charAt(i) - 'a']++;
            frequency[s2.charAt(i) - 'a']--;
        }
        for(int count : frequency){
            if(count != 0){
                return false;
            }
        }
        
        return true;
        
        // time complexity O(n);
        // space coomplexity O(1);
        
    }
}