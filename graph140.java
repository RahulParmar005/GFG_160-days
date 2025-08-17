// Given a matrix mat[][] of dimension n * m where each cell in the matrix can have values 0, 1 or 2 which has the following meaning:
// 0 : Empty cell
// 1 : Cell have fresh oranges
// 2 : Cell have rotten oranges

// We have to determine what is the earliest time after which all the oranges are rotten. A rotten orange at index (i, j) can rot other fresh orange at indexes (i-1, j), (i+1, j), (i, j-1), (i, j+1) (up, down, left and right) in a unit time.

// Note: Your task is to return the minimum time to rot all the fresh oranges. If not possible returns -1.


class Solution {
    public int orangesRotting(int[][] mat) {
        // Code here
        int n = mat.length;
        int m = mat[0].length;
        
        int[][] directions = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        
        Queue<int[]> q = new LinkedList<>();
        
        
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(mat[i][j] == 2) {
                    q.add(new int[] {i, j});
                }
            }
        }
        
        int elapsedTime = 0;
        
        while(!q.isEmpty()) {
            elapsedTime++;
            int len = q.size();
            while(len-- > 0) {
                int[] cur = q.poll();
                int i = cur[0];
                int j = cur[1];
                
                for(int[] dir : directions) {
                    int x = i + dir[0];
                    int y = j + dir[1];
                    
                    if(isSafe(x, y, n, m) && (mat[x][y] == 1)) {
                        mat[x][y] = 2;
                        q.add(new int[] {x, y});
                    }
                }
            }
        }
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(mat[i][j] == 1) return -1;
            }
        }
        
        return Math.max(0, elapsedTime - 1);
    }
    
    
    static boolean isSafe(int i, int j, int n, int m) {
        return (i >= 0 && i < n && j >= 0 && j < m);
    }
    
}