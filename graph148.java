// Given an undirected, weighted graph with V vertices numbered from 0 to V-1 and E edges, represented by 2d array edges[][], where edges[i]=[u, v, w] represents the edge between the nodes u and v having w edge weight.
// You have to find the shortest distance of all the vertices from the source vertex src, and return an array of integers where the ith element denotes the shortest distance between ith node and source vertex src.

// Note: The Graph is connected and doesn't contain any negative weight edge.



class Solution {
    public int[] dijkstra(int V, int[][] edges, int src) {
        // code here
        ArrayList<ArrayList<ArrayList<Integer>>> adj = constructAdj(edges, V);
        
        PriorityQueue<ArrayList<Integer>> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.get(0)));
        
        int dist[] = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        
        dist[src] = 0;
        ArrayList<Integer> start = new ArrayList<>();
        
        start.add(0);
        start.add(src);
        pq.offer(start);
        
        while(!pq.isEmpty()) {
            ArrayList<Integer> curr = pq.poll();
            int d = curr.get(0);
            int u = curr.get(1);
            
            for(ArrayList<Integer> neighbor : adj.get(u)) {
                int v = neighbor.get(0);
                int weight = neighbor.get(1);
                
                if(dist[v] > dist[u] + weight) {
                    dist[v] = dist[u] + weight;
                    
                    ArrayList<Integer> temp = new ArrayList<>();
                    temp.add(dist[v]);
                    temp.add(v);
                    pq.offer(temp);
                }
            }
        }
        
        return dist;
    }
    
    static ArrayList<ArrayList<ArrayList<Integer>>> constructAdj(int[][] edges, int V) {
        ArrayList<ArrayList<ArrayList<Integer>>> adj = new ArrayList<>();
        
        for(int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        
        for(int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int wt = edge[2];
            
            ArrayList<Integer> e1 = new ArrayList<>();
            e1.add(v);
            e1.add(wt);
            adj.get(u).add(e1);
            
            ArrayList<Integer> e2 = new ArrayList<>();
            e2.add(v);
            e2.add(wt);
            adj.get(u).add(e2);
        }
        
        return adj;
    }
    
    
}