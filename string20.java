// You are given two strings of equal lengths, s1 and s2. The task is to check if s2 is a rotated version of the string s1.

// Note: The characters in the strings are in lowercase.

class Solution {
    // Function to check if two strings are rotations of each other or not.
    public static boolean areRotations(String s1, String s2) {
        // Your code here
        
        if(s1.length() != s2.length()){
            return false;
        }
        String text = s1 + s1;
        
        return KmpSearch(text, s2);
        
    }
    
    public static boolean KmpSearch(String text, String pat){
        int n = text.length();
        int m = pat.length();
        
        int lps[] = generateLps(pat);
        
        int i = 0;
        int j = 0;
        
        while(i < n){
            if(pat.charAt(j) == text.charAt(i)){
                i++;
                j++;
            }
            
            if(j == m){
                return true;
            } else if(i<n && pat.charAt(j) != text.charAt(i)){
                if(j != 0){
                    j = lps[j-1];
                } else {
                    i = i + 1;
                }
            }
        }
        return false;
    }
    
    public static int[] generateLps(String str){
        int n = str.length();
        int lps[] = new int[n];
        lps[0] = 0;
        
        int len = 0;
        
        int i = 1;
        while(i < n){
            if(str.charAt(i) == str.charAt(len)){
                len++;
                lps[i] = len;
                i++;
            }else{
                if(len != 0){
                    len = lps[len - 1];
                }else{
                    lps[i] = 0;
                    i++;
                }
            }
        }
        return lps;
    }
}