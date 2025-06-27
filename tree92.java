// Given the root of a Binary search tree(BST), where exactly two nodes were swapped by mistake. Your task is to fix (or correct) the BST by swapping them back. Do not change the structure of the tree.
// Note: It is guaranteed that the given input will form BST, except for 2 nodes that will be wrong. All changes must be reflected in the original Binary search tree(BST).




class Solution {
    
    static void swap(Node a, Node b){
        int temp = a.data;
        a.data = b.data;
        b.data = temp;
    }
    
    static void correctBST(Node root, Node[] first, Node[] middle, Node[] last, Node[] prev){
        if(root == null) return;
        
        correctBST(root.left, first, middle, last, prev);
        
        if(prev[0] != null && root.data < prev[0].data){
            if(first[0] == null){
                first[0] = prev[0];
                middle[0] = root;
            } else {
                last[0] = root;
            }
        }
        
        prev[0] = root;
        
        correctBST(root.right, first, middle, last, prev);
    }
    
    void correctBST(Node root) {
        // code here.
        Node[] first = {null};
        Node[] middle = {null};
        Node[] last = {null};
        Node[] prev = {null};
        
        correctBST(root, first, middle, last, prev);
        
        if(first[0] != null && last[0] != null){
            swap(first[0], last[0]);
        } else if(first[0] != null && middle[0] != null){
            swap(first[0], middle[0]);
        }
    }
}