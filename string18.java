// Given two strings, one is a text string txt and the other is a pattern string pat. The task is to print the indexes of all the occurrences of the pattern string in the text string. Use 0-based indexing while returning the indices. 
// Note: Return an empty list in case of no occurrences of pattern.

class Solution {

    ArrayList<Integer> search(String pat, String txt) {
        // your code here
        int n = txt.length();
        int m = pat.length();
        
        int lps[] = new int[m];
        ArrayList<Integer> res = new ArrayList<>();
        
        constructLps(pat, lps);
        
        int i = 0;
        int j = 0;
        while(i < n){
            if(txt.charAt(i) == pat.charAt(j)){
                i++;
                j++;
                
                if(j == m){
                    res.add(i-j);
                    j = lps[j-1];
                }
            }else{
                if(j != 0){
                    j = lps[j-1];
                }else { i++; }
            }
        }
        return res;
    }
    
    static void constructLps(String pat, int lps[]){
        int len = 0;
        lps[0] = 0;
        
        int i = 1;
        while(i < pat.length()){
            if(pat.charAt(i) == pat.charAt(len)){
                len++;
                lps[i] = len;
                i++;
            }else{
                if(len != 0){
                    len = lps[len-1];
                }else{
                    lps[i] = 0;
                    i++;
                }
            }
        }
        
    }
}