// Given a Binary Tree, find its Boundary Traversal. The traversal should be in the following order: 

// Left Boundary: This includes all the nodes on the path from the root to the leftmost leaf node. You must prefer the left child over the right child when traversing. Do not include leaf nodes in this section.

// Leaf Nodes: All leaf nodes, in left-to-right order, that are not part of the left or right boundary.

// Reverse Right Boundary: This includes all the nodes on the path from the rightmost leaf node to the root, traversed in reverse order. You must prefer the right child over the left child when traversing. Do not include the root in this section if it was already included in the left boundary.

// Note: If the root doesn't have a left subtree or right subtree, then the root itself is the left or right boundary. 
import java.util.*;


class Solution {
    
    static boolean isLeaf(Node node){
        return node.left == null && node.right == null;
    }
    
    static void collectBoundaryLeft(Node root, ArrayList<Integer> res){
        if(root == null || isLeaf(root)) return;
        
        res.add(root.data);
        if(root.left != null){
            collectBoundaryLeft(root.left, res);
        } else if(root.right != null){
            collectBoundaryLeft(root.right, res);
        }
    }
    
    static void collectLeaves(Node root, ArrayList<Integer> res){
        if(root == null) return;
        
        if(isLeaf(root)){
            res.add(root.data);
            return;
        }
        
        collectLeaves(root.left, res);
        collectLeaves(root.right, res);
    }
    
    static void collectBoundaryRight(Node root, ArrayList<Integer> res){
        if(root == null || isLeaf(root)) return;
        
        if(root.right != null){
            collectBoundaryRight(root.right, res);
        } else if(root.left != null){
            collectBoundaryRight(root.left, res);
        }
        res.add(root.data);
    }
    
    ArrayList<Integer> boundaryTraversal(Node node) {
        // code here
        ArrayList<Integer> res = new ArrayList<>();
        
        if(node == null) return res;
        
        if(!isLeaf(node)) res.add(node.data);
        
        collectBoundaryLeft(node.left, res);
        
        collectLeaves(node, res);
        
        collectBoundaryRight(node.right, res);
        
        return res;
    }
}