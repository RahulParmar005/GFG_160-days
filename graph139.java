// Given a connected undirected graph containing V vertices, represented by a 2-d adjacency list adj[][], where each adj[i] represents the list of vertices connected to vertex i. Perform a Breadth First Search (BFS) traversal starting from vertex 0, visiting vertices from left to right according to the given adjacency list, and return a list containing the BFS traversal of the graph.

// Note: Do traverse in the same order as they are in the given adjacency list.


class Solution {
    // Function to return Breadth First Search Traversal of given graph.
    public ArrayList<Integer> bfs(ArrayList<ArrayList<Integer>> adj) {
        // code here
        int V = adj.size();
        ArrayList<Integer> res = new ArrayList<>();
        boolean[] vis = new boolean[V];
        
        for(int s = 0; s < V; s++) {
            if(!vis[s]) {
                BSFRec(adj, vis, s, res);
            }
        }
        
        return res;
    }
    
    public ArrayList<Integer> BSFRec(ArrayList<ArrayList<Integer>> adj, boolean[] vis, int s, ArrayList<Integer> res) {
        
        Queue<Integer> q = new LinkedList<>();
        q.add(s);
        vis[s] = true;
        
        while(!q.isEmpty()) {
            int curr = q.poll();
            res.add(curr);
            
            for(int x : adj.get(curr)) {
                if(!vis[x]) {
                    vis[x] = true;
                    q.add(x);
                }
            }
        }
        
        return res;
    }
}