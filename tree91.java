// Given a Binary Search Tree(BST) and a target. Check whether there's a pair of Nodes in the BST with value summing up to the target. 


class Solution {
    
    public static void inorderTraversel(Node root, ArrayList<Integer> inorder){
        if(root == null) return;
        
        inorderTraversel(root.left, inorder);
        inorder.add(root.data);
        inorderTraversel(root.right, inorder);
    }
    
    boolean findTarget(Node root, int target) {
        // Write your code here
        ArrayList<Integer> inorder = new ArrayList<>();
        inorderTraversel(root, inorder);
        
        int left = 0, right = inorder.size() - 1;
        
        while(left < right){
            int currSum = inorder.get(left) + inorder.get(right);
            
            if(currSum == target){
                return true;
            } else if(currSum < target){
                left++;
            } else {
                right--;
            }
        }
        return false;
    }
}