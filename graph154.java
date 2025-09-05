// Given an undirected, weighted graph with V vertices numbered from 0 to V-1 and E edges, represented by a 2d array edges[][], where edges[i] = [u, v, w] represents the edge between the nodes u and v having w edge weight.
// Your task is to find the minimum weight cycle in this graph.


class Solution {
    public int findMinCycle(int V, int[][] edges) {
        // code here
        ArrayList<ArrayList<int[]>> adj = constructAdj(V, edges);
        int minCycle = Integer.MAX_VALUE;
        
        for(int[] edge : edges) {
            int u = edge[0], v = edge[1], wt = edge[2];
            int dist = shortestPath(V, adj, u, v);
            
            if(dist != Integer.MAX_VALUE) {
                minCycle = Math.min(minCycle, dist + wt);
            }
        }
        
        return minCycle == Integer.MAX_VALUE ? -1 : minCycle;
    }
    
    public static int shortestPath(int V, ArrayList<ArrayList<int[]>> adj, int src, int dest) {
        int dist[] = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        dist[src] = 0;
        pq.offer(new int[]{0, src});
        
        while(!pq.isEmpty()) {
            int[] curr = pq.poll();
            int d = curr[0];
            int u = curr[1];
            
            if(d > dist[u]) continue;
            
            for(int[] neighbor : adj.get(u)) {
                int v = neighbor[0];
                int w = neighbor[1];
                
                if((u == src && v == dest) || (u == dest && v == src)) continue;
                
                if(dist[v] > dist[u] + w) {
                    dist[v] = dist[u] + w;
                    pq.offer(new int[]{dist[v], v});
                }
            }
        }
        
        return dist[dest];
    }
    
    public static ArrayList<ArrayList<int[]>> constructAdj(int V, int[][] edges) {
        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();
        
        for(int i = 0; i < V; i++) adj.add(new ArrayList<>());
        
        for(int[] edge : edges) {
            int u = edge[0], v = edge[1], wt = edge[2];
            
            adj.get(u).add(new int[]{v, wt});
            adj.get(v).add(new int[]{u, wt});
        }
        
        return adj;
    }
};