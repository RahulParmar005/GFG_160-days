// A new alien language uses the English alphabet, but the order of letters is unknown. You are given a list of words[] from the alien language’s dictionary, where the words are claimed to be sorted lexicographically according to the language’s rules.

// Your task is to determine the correct order of letters in this alien language based on the given words. If the order is valid, return a string containing the unique letters in lexicographically increasing order as per the new language's rules. If there are multiple valid orders, return any one of them.

// However, if the given arrangement of words is inconsistent with any possible letter ordering, return an empty string ("").

// A string a is lexicographically smaller than a string b if, at the first position where they differ, the character in a appears earlier in the alien language than the corresponding character in b. If all characters in the shorter word match the beginning of the longer word, the shorter word is considered smaller.

// Note: Your implementation will be tested using a driver code. It will print true if your returned order correctly follows the alien language’s lexicographic rules; otherwise, it will print false.

class Solution {
    public String findOrder(String[] words) {
        // code here
        int[][] graph = new int[26][26];
        int[] exist = new int[26];
        int[] vis = new int[26];
        int[] rec = new int[26];
        StringBuilder ans = new StringBuilder();
        
        for(String word : words) {
            for(char ch : word.toCharArray()) {
                exist[ch - 'a'] = 1;
            }
        }
        
        for(int i = 0; i + 1 < words.length; i++) {
            String a = words[i], b = words[i + 1];
            int n = a.length(), m = b.length(), ind = 0;
            
            while(ind < n && ind < m && a.charAt(ind) == b.charAt(ind)) {
                ind++;
            }
            
            if(ind < a.length() && ind == b.length()) return "";
            
            if(ind < a.length() && ind < b.length()) {
                graph[a.charAt(ind) - 'a'][b.charAt(ind) - 'a'] = 1;
            }
        }
        
        for(int i = 0; i < 26; i++) {
            if(exist[i] == 1 && vis[i] == 0) {
                if(!dfs(i, graph, vis, rec, ans)){
                    return "";
                }
            }
        }
        
        return ans.reverse().toString();
    }
    
    static boolean dfs(int u, int[][] graph, int[] vis, int[] rec, StringBuilder ans) {
        vis[u] = rec[u] = 1;
        
        for(int v = 0; v < 26; v++) {
            if(graph[u][v] == 1) {
                if(vis[v] == 0) {
                    if(!dfs(v, graph, vis, rec, ans)) return false;
                } else if(rec[v] == 1) {
                    return false;
                }
            }
        }
        
        ans.append((char) ('a' + u));
        rec[u] = 0;
        return true;
    }
}