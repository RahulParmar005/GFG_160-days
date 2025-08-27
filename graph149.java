// You are given a 2D grid image[][] of size n*m, where each image[i][j] represents the color of a pixel in the image. Also provided a coordinate(sr, sc) representing the starting pixel (row and column) and a new color value newColor.

// Your task is to perform a flood fill starting from the pixel (sr, sc), changing its color to newColor and the color of all the connected pixels that have the same original color. Two pixels are considered connected if they are adjacent horizontally or vertically (not diagonally) and have the same original color.


class Solution {
    
    public static final int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        // Code here
        if(image[sr][sc] == newColor) return image;
        
        int oldColor = image[sr][sc];
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{sr, sc});
        
        image[sr][sc] = newColor;
        
        while(!q.isEmpty()) {
            int[] front = q.poll();
            int x = front[0], y = front[1];
            
            for(int[] direction : directions) {
                int nx = x + direction[0];
                int ny = y + direction[1];
                
                if(nx >= 0 && nx < image.length && ny >= 0 && ny < image[0].length && image[nx][ny] == oldColor) {
                    image[nx][ny] = newColor;
                    q.offer(new int[]{nx, ny});
                }
            }
        }
        
        return image;
    }
}