// Given a Directed Acyclic Graph (DAG) of V (0 to V-1) vertices and E edges represented as a 2D list of edges[][], where each entry edges[i] = [u, v] denotes a directed edge u -> v. Return the topological sort for the given graph.

// Topological sorting for Directed Acyclic Graph (DAG) is a linear ordering of vertices such that for every directed edge u -> v, vertex u comes before v in the ordering.
// Note: As there are multiple Topological orders possible, you may return any of them. If your returned Topological sort is correct then the output will be true else false.


class Solution {
    public static ArrayList<Integer> topoSort(int V, int[][] edges) {
        // code here
        Stack<Integer> stack = new Stack<>();
        boolean[] vis = new boolean[V];
        
        List<Integer>[] adj = constructadj(V, edges);
        for(int i = 0; i < V; i++) {
            if(!vis[i]) {
                TopologicalSort(i, adj, vis, stack);
            }
        }
        
        ArrayList<Integer> res = new ArrayList<>();
        int idx = 0;
        while(!stack.isEmpty()) {
            res.add(stack.pop());
        }
        
        return res;
    }
    
    static List<Integer>[] constructadj(int V, int[][] edges) {
        List<Integer>[] adj = new ArrayList[V];
        
        for(int i = 0; i < V; i++) {
            adj[i] = new ArrayList<>();
        }
        
        for(int[] edge : edges) {
            adj[edge[0]].add(edge[1]);
        }
        
        return adj;
    }
    
    static void TopologicalSort(int v, List<Integer>[] adj, boolean[] vis, Stack<Integer> sta) {
        vis[v] = true;
        for(int i : adj[v]) {
            if(!vis[i]) {
                TopologicalSort(i, adj, vis, sta);
            }
        }
        
        sta.push(v);
    }
}