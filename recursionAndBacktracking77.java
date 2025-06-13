// The n-queens puzzle is the problem of placing n queens on a (n × n) chessboard such that no two queens can attack each other. Note that two queens attack each other if they are placed on the same row, the same column, or the same diagonal.

// Given an integer n, find all distinct solutions to the n-queens puzzle.
// You can return your answer in any order but each solution should represent a distinct board configuration of the queen placements, where the solutions are represented as permutations of [1, 2, 3, ..., n]. In this representation, the number in the ith position denotes the row in which the queen is placed in the ith column.
// For eg. below figure represents a chessboard [3 1 4 2].



class Solution {
    
    static void nQueenUtil(int j, int n, ArrayList<Integer> board, boolean[] rows, boolean[] diag1, boolean[] diag2, ArrayList<ArrayList<Integer>> res) {
        if(j == n){
            ArrayList<Integer> solution = new ArrayList<>();
            for(int r : board){
                solution.add(r+1);
            }
            
            res.add(solution);
            return;
        }
        for(int i = 0; i < n; i++){
            
            if(!rows[i] && !diag1[i + j] && !diag2[i - j + n]) {
                rows[i] = diag1[i + j] = diag2[i - j + n] = true;
                board.add(i);
                
                nQueenUtil(j+1, n, board, rows, diag1, diag2, res);
                
                board.remove(board.size()-1);
                rows[i] = diag1[i + j] = diag2[i - j + n] = false;
            }
        }
    }
    
    public ArrayList<ArrayList<Integer>> nQueen(int n) {
        // code here
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        ArrayList<Integer> board = new ArrayList<>();
        
        boolean[] rows = new boolean[n];
        
        boolean[] diag1 = new boolean[2 * n - 1];
        boolean[] diag2 = new boolean[2 * n];
        
        nQueenUtil(0, n, board, rows, diag1, diag2, res);
        return res;
    }
}