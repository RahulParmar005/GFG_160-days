// Given a BST and an integer k, the task is to find the kth smallest element in the BST. If there is no kth smallest element present then return -1.



class Solution {
    // Return the Kth smallest element in the given BST
    public int kthSmallest(Node root, int k) {
        // Write your code here
        Node curr = root;
        int count = 0;
        
        while(curr != null){
            if(curr.left == null){
                count++;
                if(count == k) return curr.data;
                curr = curr.right;
            } else {
                Node pre = curr.left;
                while(pre.right != null && pre.right != curr){
                    pre = pre.right;
                }
                
                if(pre.right == null){
                    pre.right = curr;
                    curr = curr.left;
                } else {
                    pre.right = null;
                    count++;
                    if(count == k) return curr.data;
                    curr = curr.right;
                }
            }
        }
        
        return -1;
    }
}