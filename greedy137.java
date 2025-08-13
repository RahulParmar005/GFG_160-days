// Given a string s of lowercase English alphabets, your task is to return the maximum number of substrings formed, after possible partitions (probably zero) of s such that no two substrings have a common character.



class Solution {
    public int maxPartitions(String s) {
        // code here
        int[] lastOcu = new int[26];
        Arrays.fill(lastOcu, -1);
        
        for(int i = 0; i < s.length(); i++) {
            lastOcu[s.charAt(i) - 'a'] = i;
        }
        
        int ans = 0;
        int a = -1;
        
        for(int i = 0; i < s.length(); i++) {
            a = Math.max(lastOcu[s.charAt(i) - 'a'], a);
            
            if(i == a) {
                ans++;
            }
        }
        
        return ans;
    }
}