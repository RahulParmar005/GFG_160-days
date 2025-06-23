// Given a binary tree and an integer k, determine the number of downward-only paths where the sum of the node values in the path equals k. A path can start and end at any node within the tree but must always move downward (from parent to child).
import java.util.*;


class Solution {
    
    static int countPathSum(Node node, int k, int currSum, HashMap<Integer, Integer> prefSum){
        if(node == null) return 0;
        
        int pathCount = 0;
        currSum += node.data;
        
        if(currSum == k) pathCount++;
        
        pathCount += prefSum.getOrDefault(currSum - k, 0);
        prefSum.put(currSum, prefSum.getOrDefault(currSum, 0) + 1);
        
        pathCount += countPathSum(node.left, k, currSum, prefSum);
        pathCount += countPathSum(node.right, k, currSum, prefSum);
        
        prefSum.put(currSum, prefSum.get(currSum) - 1);
        return pathCount;
    }
    
    public int sumK(Node root, int k) {
        // code here
        HashMap<Integer, Integer> prefSum = new HashMap<>();
        
        return countPathSum(root, k, 0, prefSum);
    }
}   