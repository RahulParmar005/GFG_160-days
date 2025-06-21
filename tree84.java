// Given two arrays representing the inorder and preorder traversals of a binary tree, construct the tree and return the root node of the constructed tree.

// Note: The output is written in postorder traversal.
import java.util.*;


class Solution {
    public static Node buildTree(int inorder[], int preorder[]) {
        // code here
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < inorder.length; i++){
            map.put(inorder[i], i);
        }
        int preIndex[] = {0};
        return buildTreeRec(map, preorder, preIndex, 0, inorder.length - 1);
    }
    
    static Node buildTreeRec(Map<Integer, Integer> map, int preorder[], int preIndex[], int left, int right){
        if(left > right) return null;
        
        int rootVal = preorder[preIndex[0]];
        preIndex[0]++;
        
        Node root = new Node(rootVal);
        int index = map.get(rootVal);
        
        root.left = buildTreeRec(map, preorder, preIndex, left, index - 1);
        root.right = buildTreeRec(map, preorder, preIndex, index + 1, right);
        
        return root;
    }
}