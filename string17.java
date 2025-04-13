// Given a string s consisting of lowercase English Letters. Return the first non-repeating character in s.
// If there is no non-repeating character, return '$'.
// Note: When you return '$' driver code will output -1.

class Solution {
    static char nonRepeatingChar(String s) {
        // code here
        // Time Complexity : O(n);
        // Space Complexity : O(1);
        
        int freq[] = new int[26];
        
        for(int count=0; count<s.length(); count++){
            freq[s.charAt(count) - 'a']++;
        }
        
        for(int i=0; i<s.length(); i++){
            if(freq[s.charAt(i) - 'a'] == 1){
                return s.charAt(i);
            }
        }
        return '$';
    }
}
