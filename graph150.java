// Given a connected undirected graph represented by adjacency list, adjList[][] with n nodes, having a distinct label from 0 to n-1, where each adj[i] represents the list of vertices connected to vertex i.

// Create a clone of the graph, where each node in the graph contains an integer val and an array (neighbors) of nodes, containing nodes that are adjacent to the current node.

// class Node {
//     val: integer
//     neighbors: List[Node]
// }
// Your task is to complete the function cloneGraph( ) which takes a starting node of the graph as input and returns the copy of the given node as a reference to the cloned graph.

// Note: If you return a correct copy of the given graph, then the driver code will print true; and if an incorrect copy is generated or when you return the original node, the driver code will print false.


// User function Template for Java

/*
    class Node{
        int val;
        ArrayList<Node> neighbors;
        public Node(){
            val = 0;
            neighbors = new ArrayList<>();
        }

        public Node(int val){
            this.val = val;
            neighbors = new ArrayList<>();
        }

        public Node(int val, ArrayList<Node> neighbors){
            this.val = val;
            this.neighbors = neighbors;
        }
    }
*/
class Solution {
    Node cloneGraph(Node node) {
        // code here
        if(node == null) return null;
        Map<Node, Node> mp = new HashMap<>();
        Queue<Node> q = new LinkedList<>();
        
        Node clone = new Node(node.val);
        mp.put(node, clone);
        q.offer(node);
        
        while(!q.isEmpty()){
            Node curr = q.poll();
            for(Node neighbor : curr.neighbors) {
                if(!mp.containsKey(neighbor)) {
                    mp.put(neighbor, new Node(neighbor.val));
                    q.offer(neighbor);
                }
                
                mp.get(curr).neighbors.add(mp.get(neighbor));
            }
        }
        
        return mp.get(node);
    }
}