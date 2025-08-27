// Given an undirected graph with V vertices numbered from 0 to V-1 and E edges, represented by 2d array edges[][], where edges[i]=[u,v] represents the edge between the vertices u and v. Determine whether a specific edge between two vertices (c, d) is a bridge.

// Note:

// An edge is called a bridge if removing it increases the number of connected components of the graph.
// if there’s only one path between c and d (which is the edge itself), then that edge is a bridge.


class Solution {
    public boolean isBridge(int V, int[][] edges, int c, int d) {
        // code here
        List<Integer>[] adj = constructAdj(V, edges, c, d);
        boolean[] vis = new boolean[V];
        dfs(adj, c, vis);
        
        return !vis[d];
    }
    
    public static List<Integer>[] constructAdj(int V, int[][] edges, int c, int d){
        List<Integer>[] adj = new ArrayList[V];
        
        for(int i = 0; i < V; i++) {
            adj[i] = new ArrayList<>();
        }
        
        for(int[] edge : edges) {
            int a = edge[0], b = edge[1];
            if((a == c && b == d) || (a == d && b == c)) {
                continue;
            }
            adj[a].add(b);
            adj[b].add(a);
        }
        
        return adj;
    }
    
    static void dfs(List<Integer>[] adj, int c, boolean[] vis) {
        vis[c] = true;
        for(int neighbor : adj[c]) {
            if(!vis[neighbor]) {
                dfs(adj, neighbor, vis);
            }
        }
    }
}


