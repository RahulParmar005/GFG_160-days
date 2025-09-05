// You are given an weighted directed graph, represented by an adjacency matrix, dist[][] of size n x n, where dist[i][j] represents the weight of the edge from node i to node j. If there is no direct edge, dist[i][j] is set to a large value (i.e., 108) to represent infinity.
// The graph may contain negative edge weights, but it does not contain any negative weight cycles.

// Your task is to find the shortest distance between every pair of nodes i and j in the graph.

// Note: Modify the distances for every pair in place.



// User function template for JAVA

class Solution {
    public void floydWarshall(int[][] dist) {
        // Code here
        int V = dist.length;
        
        for(int k = 0; k < V; k++) {
            
            for(int i = 0; i < V; i++) {
                
                for(int j = 0; j < V; j++) {
                    
                    if(dist[i][k] != 100000000 && dist[k][j] != 100000000)
                    dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                }
            }
        }
    }
}