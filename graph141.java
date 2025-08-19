// Given an undirected graph with V vertices and E edges, represented as a 2D vector edges[][], where each entry edges[i] = [u, v] denotes an edge between vertices u and v, determine whether the graph contains a cycle or not. The graph can have multiple component.


class Solution {
    public boolean isCycle(int V, int[][] edges) {
        // Code here
        List<Integer>[] adj = constructadj(V, edges);
        
        for(int[] edge : edges) {
            adj[edge[0]].add(edge[1]);
            adj[edge[1]].add(edge[0]);
        }
        
        boolean[] vis = new boolean[V];
        
        for(int u = 0; u < V; u++) {
            if(!vis[u]) {
                if(isCycle(u, adj, vis, -1)) return true;
            }
        }
        return false;
    }
    
    static boolean isCycle(int v, List<Integer>[] adj, boolean[] vis, int parent) {
        vis[v] = true;
        for(int i : adj[v]) {
            if(!vis[i]) {
                if(isCycle(i, adj, vis, v)) return true;
            } else if(i != parent) {
                return true;
            }
        }
        return false;
    }
    
    static List<Integer>[] constructadj(int V, int[][] edges) {
        List<Integer>[] adj = new ArrayList[V];
        for(int i = 0; i < V; i++) {
            adj[i] = new ArrayList<>();
        }
        return adj;
    }
}