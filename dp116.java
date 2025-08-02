// Given two strings s1 and s2. Return the minimum number of operations required to convert s1 to s2.
// The possible operations are permitted:

// Insert a character at any position of the string.
// Remove any character from the string.
// Replace any character from the string with any other character.



class Solution {
    public int editDistance(String s1, String s2) {
        // Code here
        int n = s1.length();
        int m = s2.length();
        
        int [] prev = new int[m + 1];
        int [] curr = new int[m + 1];
        
        for(int j = 0; j <= m; j++) {
            prev[j] = j;
        }
        
        for(int i = 1; i <= n; i++) {
            curr[0] = i;
            for(int j = 1; j <= m; j++) {
                if(s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    curr[j] = prev[j - 1];
                } else {
                    curr[j] = 1 + Math.min(Math.min(curr[j - 1], prev[j]), prev[j - 1]);
                }
            }
            prev = curr.clone();
        }
        return prev[m];
    }
}