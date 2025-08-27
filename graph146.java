// You are given an undirected graph with V vertices and E edges. The graph is represented as a 2D array edges[][], where each element edges[i] = [u, v] indicates an undirected edge between vertices u and v.
// Your task is to return all the articulation points (or cut vertices) in the graph.
// An articulation point is a vertex whose removal, along with all its connected edges, increases the number of connected components in the graph.

// Note: The graph may be disconnected, i.e., it may consist of more than one connected component.
// If no such point exists, return {-1}.


class Solution {
    static ArrayList<Integer> articulationPoints(int V, int[][] edges) {
        // code here
        ArrayList<ArrayList<Integer>> adj = constructAdj(V, edges);
        int[] disc = new int[V], low = new int[V], vis = new int[V], isAP = new int[V];
        int[] time = {0};
        
        for(int i = 0; i < V; i++) {
            if(vis[i] == 0) {
                findPoints(adj, i, vis, disc, low, time, -1, isAP);
            }
        }
        
        ArrayList<Integer> res = new ArrayList<>();
        for(int i = 0; i < V; i++) {
            if(isAP[i] == 1) {
                res.add(i);
            }
        }
        
        if(res.isEmpty()) res.add(-1);
        
        return res;
    }
    
    public static ArrayList<ArrayList<Integer>> constructAdj(int V, int[][] edges) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        
        for(int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        return adj;
    }
    
    public static void findPoints(ArrayList<ArrayList<Integer>> adj, int u, int[] vis, int[] disc, int[] low, int[] time, int parent, int[] isAP) {
        vis[u] = 1;
        disc[u] = low[u] = ++time[0];
        int children = 0;
        
        for(int v : adj.get(u)) {
            if(vis[v] == 0) {
                children++;
                findPoints(adj, v, vis, disc, low, time, u, isAP);
                
                low[u] = Math.min(low[u], low[v]);
                
                if(parent != -1 && low[v] >= disc[u]) {
                    isAP[u] = 1;
                }
            } else if(v != parent) {
                low[u] = Math.min(low[u], disc[v]);
            }
        }
        
        if(parent == -1 && children > 1) {
            isAP[u] = 1;
        }
    }
    
    
}