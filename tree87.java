// Given a binary tree, the task is to find the maximum path sum. The path may start and end at any node in the tree.



class Solution {
    
    static int maxPathSumRes(Node node, int res[]){
        if(node == null) return 0;
        
        int l = Math.max(0, maxPathSumRes(node.left, res));
        int r = Math.max(0, maxPathSumRes(node.right, res));
        
        res[0] = Math.max(res[0], l + r + node.data);
        
        return node.data + Math.max(l ,r);
    }
    
    // Function to return maximum path sum from any node in a tree.
    int findMaxSum(Node node) {
        // your code goes here
        int res[] = {node.data};
        
        maxPathSumRes(node, res);
        
        return res[0];
    }
}