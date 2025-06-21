// Given a Binary Tree, your task is to return its In-Order Traversal.

// An inorder traversal first visits the left child (including its entire subtree), then visits the node, and finally visits the right child (including its entire subtree).

// Follow Up: Try solving this with O(1) auxiliary space.



class Solution {
    // Function to return a list containing the inorder traversal of the tree.
    ArrayList<Integer> inOrder(Node root) {
        // Code
        ArrayList<Integer> res = new ArrayList<>();
        Node curr = root;
        
        while(curr != null){
            if(curr.left == null){
                res.add(curr.data);
                curr = curr.right;
            } else {
                Node prev = curr.left;
                while(prev.right != null && prev.right != curr){
                    prev = prev.right;
                }
                
                if(prev.right == null){
                    prev.right = curr;
                    curr = curr.left;
                } else {
                    prev.right = null;
                    res.add(curr.data);
                    curr = curr.right;
                }
            }
        }
        return res;
    }
}