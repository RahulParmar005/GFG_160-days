// Given the root of a binary tree. Check whether it is a BST or not.
// Note: We are considering that BSTs can not contain duplicate Nodes.
// A BST is defined as follows:

// The left subtree of a node contains only nodes with keys less than the node's key.
// The right subtree of a node contains only nodes with keys greater than the node's key.
// Both the left and right subtrees must also be binary search trees.


class Solution {
    
    static boolean inorder(Node root, int pre[]){
        if(root == null) return true;
        
        if(!inorder(root.left, pre)) return false;
        
        if(root.data <= pre[0]) return false;
        
        pre[0] = root.data;
        
        return inorder(root.right, pre);
    }
    
    // Function to check whether a Binary Tree is BST or not.
    boolean isBST(Node root) {
        // code here.
        int pre[] = {Integer.MIN_VALUE};
        
        return inorder(root, pre);
    }
}