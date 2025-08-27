// Given a 2D array houses[][], consisting of n 2D coordinates {x, y} where each coordinate represents the location of each house, the task is to find the minimum cost to connect all the houses of the city.

// The cost of connecting two houses is the Manhattan Distance between the two points (xi, yi) and (xj, yj) i.e., |xi – xj| + |yi – yj|, where |p| denotes the absolute value of p.


class DSU {
    private int[] parent;
    private int[] rank;
    
    public DSU(int n) {
        parent = new int[n];
        rank = new int[n];
        Arrays.fill(parent, -1);
        Arrays.fill(rank, 1);
    }
    
    public int find(int i) {
        if(parent[i] == -1) {
            return i;
        }
        return parent[i] = find(parent[i]);
    }
    
    public void unite(int x, int y) {
        int s1 = find(x);
        int s2 = find(y);
        
        if(s1 != s2) {
            if(rank[s1] < rank[s2]) {
                parent[s1] = s2;
            } else if(rank[s1] > rank[s2]) {
                parent[s2] = s1;
            } else {
                parent[s2] = s1;
                rank[s1] += 1;
            }
        }
    }
}

class Graph {
    private List<int[]> edgelist;
    private int V;
    
    public Graph(int V) {
        this.V = V;
        edgelist = new ArrayList<>();
    }
    
    public void addEdge(int x, int y, int w) {
        edgelist.add(new int[]{w, x, y});
    }
    
    public int krushkalsMST() {
        edgelist.sort(Comparator.comparingInt(a -> a[0]));
        
        DSU s = new DSU(V);
        int ans = 0;
        int count = 0;
        
        for(int[] edge : edgelist) {
            int w = edge[0];
            int x = edge[1];
            int y = edge[2];
            
            if(s.find(x) != s.find(y)) {
                s.unite(x, y);
                ans += w;
                count++;
            }
            
            if(count == V - 1) break;
        }
        
        return ans;
    }
}

class Solution {

    public int minCost(int[][] houses) {
        // code here
        int n = houses.length;
        Graph g = new Graph(n);
        
        for(int i = 0; i < n; i++) {
            for(int j = i + 1; j < n; j++) {
                int cost = Math.abs(houses[i][0] - houses[j][0]) + Math.abs(houses[i][1] - houses[j][1]);
                g.addEdge(i, j, cost);
            }
        }
        
        return g.krushkalsMST();
    }
}
