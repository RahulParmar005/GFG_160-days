// You are given a two-dimensional mat[][] of size n*m containing English alphabets and a string word. Check if the word exists on the mat. The word can be constructed by using letters from adjacent cells, either horizontally or vertically. The same cell cannot be used more than once.

class Solution {
    static public boolean isWordExist(char[][] mat, String word) {
        // Code here
        int wLen = word.length();
        int n = mat.length;
        int m = mat[0].length;
        
        if(wLen > n * m) return false;
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                
                if(mat[i][j] == word.charAt(0)){
                    if(findMatch(mat, word, i, j, 0)) return true;
                }
            }
        }
        return false;
    }
    
    static boolean findMatch(char mat[][], String word, int x, int y, int wIdx){
        
        int wLen = word.length();
        int n = mat.length;
        int m = mat[0].length;
        
        if(wIdx == wLen) return true;
        
        if(x < 0 || x >= n || y < 0 || y >= m) return false;
        
        if(mat[x][y] == word.charAt(wIdx)){
            
            char temp = mat[x][y];
            mat[x][y] = '#';
            
            boolean res = findMatch(mat, word, x - 1, y, wIdx + 1) || findMatch(mat, word, x + 1, y, wIdx + 1) || findMatch(mat, word, x, y - 1, wIdx + 1) || findMatch(mat, word, x, y + 1, wIdx + 1);
            
            mat[x][y] = temp;
            return res;
        }
        
        return false;
    }
}