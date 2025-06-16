// Given a binary tree, find its height.

// The height of a tree is defined as the number of edges on the longest path from the root to a leaf node. A leaf node is a node that does not have any children.



class Solution {
    // Function to find the height of a binary tree.
    int height(Node node) {
        // code here
        if(node == null) return 0;
        
        Queue<Node> q = new LinkedList<>();
        q.add(node);
        int height = 0;
        
        while(!q.isEmpty()){
            int len = q.size();
            
            for(int i = 0; i < len; i++){
                Node curr = q.poll();
                
                if(curr.left != null) q.add(curr.left);
                if(curr.right != null) q.add(curr.right);
            }
            height++;
        }
        return height - 1;
    }
}