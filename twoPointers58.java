// Given a string s, find the length of the longest substring with all distinct characters. 4



class Solution {
    public int longestUniqueSubstr(String s) {
        // code here
       if(s.length() == 0 || s.length() == 1){
           return s.length();
       }
       
       int res = 0;
       boolean[] check = new boolean[26];
       
       int left = 0, right = 0;
       
       while(right < s.length()){
           
           while(check[s.charAt(right) - 'a'] == true){
               check[s.charAt(left) - 'a'] = false;
               left++;
           }
           
           check[s.charAt(right) - 'a'] = true;
           
           res = Math.max(res, right - left + 1);
           right++;
       }
       return res;
    }
}