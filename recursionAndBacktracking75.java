// Given a string s, which may contain duplicate characters, your task is to generate and return an array of all unique permutations of the string. You can return your answer in any order.

import java.util.*;

class Solution {
    public ArrayList<String> findPermutation(String s) {
        // Code here
        HashSet<String> resultSet = new HashSet<>();
        permutation(s, ", resultSet);
        return new ArrayList<>(resultSet);
    }
    
    public void permutation(String s, String prefix, HashSet<String> resultSet){        
        if(s.isEmpty()){
            resultSet.add(prefix);
            return;
        }
        
        for(int i = 0; i < s.length(); i++){
            permutation(s.substring(0, i) + s.substring(i+1), prefix + s.charAt(i), resultSet);
        }
        
    }
}