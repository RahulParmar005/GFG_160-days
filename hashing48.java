// Given an array of strings, return all groups of strings that are anagrams. The strings in each group must be arranged in the order of their appearance in the original array. Refer to the sample case for clarification.


import java.util.*;
class Solution {
    public ArrayList<ArrayList<String>> anagrams(String[] arr) {
        // code here
        ArrayList<ArrayList<String>> res = new ArrayList<>();
        HashMap<String, Integer> map = new HashMap<>();
        
        for(int i=0; i<arr.length; i++){
            String key = getHash(arr[i]);
            
            if(!map.containsKey(key)){
                map.put(key, res.size());
                res.add(new ArrayList<>());
            }
            
            res.get(map.get(key)).add(arr[i]);
        }
        return res;
    }
    
    static final int MAX_CHAR = 26;
    
    static String getHash(String s){
        StringBuilder hash = new StringBuilder();
        int freq[] = new int[MAX_CHAR];
        
        for(char ch : s.toCharArray()){
            freq[ch - 'a']++;
        }
        for(int i=0; i<MAX_CHAR; i++){
            hash.append(freq[i]);
            hash.append("$");
        }
        
        return hash.toString();
    }
}
