// Given an array of points where each point is represented as points[i] = [xi, yi] on the X-Y plane and an integer k, return the k closest points to the origin (0, 0).

// The distance between two points on the X-Y plane is the Euclidean distance, defined as: 

// sqrt( (x2 - x1)2 + (y2 - y1)2 )

// Note: You can return the k closest points in any order, driver code will sort them before printing.


class Solution {
    
    static int distance(int[] point){
        return point[0] * point[0] + point[1] * point[1];
    }
    
    public int[][] kClosest(int[][] points, int k) {
        // Your code here
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> Integer.compare(distance(b), distance(a)));
        
        for(int[] point : points){
            maxHeap.add(point);
            if(maxHeap.size() > k){
                maxHeap.poll();
            }
        }
        
        int[][] res = new int[k][2];;
        for(int i = 0; i < k; i++){
            res[i] = maxHeap.poll();
        }
        
        return res;
    }
}