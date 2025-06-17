// Given a binary tree, the diameter (also known as the width) is defined as the number of edges on the longest path between two leaf nodes in the tree. This path may or may not pass through the root. Your task is to find the diameter of the tree.


class Solution {
    int diameter(Node root) {
        // Your code here
        int res[] = new int[1];
        diameterRec(root , res);
        
        return res[0];
    }
    
    static int diameterRec(Node root, int res[]){
        if(root == null) return 0;
        
        int lHeight = diameterRec(root.left, res);
        int rHeight = diameterRec(root.right, res);
        
        res[0] = Math.max(res[0], rHeight + lHeight);
        
        return 1 + Math.max(lHeight, rHeight);
    }
}