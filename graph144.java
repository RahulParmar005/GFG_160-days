// Given a Directed Graph with V vertices (Numbered from 0 to V-1) and E edges, check whether it contains any cycle or not.
// The graph is represented as a 2D vector edges[][], where each entry edges[i] = [u, v] denotes an edge from verticex u to v.


class Solution {
    public boolean isCyclic(int V, int[][] edges) {
        // code here
        List<Integer>[] adj = constructAdj(V, edges);
        boolean[] vis = new boolean[V];
        boolean[] recSta = new boolean[V];
        
        for(int i = 0; i < V; i++) {
            if(!vis[i] && isCyclicUtil(adj, i, vis, recSta)) return true; 
        }
        return false;
    }
    
    public static List<Integer>[] constructAdj(int V, int[][] edges) {
        List<Integer>[] adj = new ArrayList[V];
        
        for(int i = 0; i < V; i++) {
            adj[i] = new ArrayList<>();
        }
        
        for(int[] edge : edges) {
            adj[edge[0]].add(edge[1]);
        }
        return adj;
    }
    
    public static boolean isCyclicUtil(List<Integer>[] adj, int u, boolean[] vis, boolean[] recSta) {
        
        if(recSta[u]) return true;
        
        if(vis[u]) return false;
        
        vis[u] = true;
        recSta[u] = true;
        
        for(int v : adj[u]) {
            if(isCyclicUtil(adj, v, vis, recSta)) return true;
        }
        
        recSta[u] = false;
        return false;
    }
}