// Given a root of a binary tree with n nodes, the task is to find its level order traversal. Level order traversal of a tree is breadth-first traversal for the tree.


class Solution {
    public ArrayList<ArrayList<Integer>> levelOrder(Node root) {
        // Your code here
        if(root == null) return new ArrayList<>();
        
        Queue<Node> q = new LinkedList<>();
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        
        q.offer(root);
        int currLevel = 0;
        
        while(!q.isEmpty()){
            int len = q.size();
            res.add(new ArrayList<>());
            
            for(int i = 0; i < len; i++){
                Node node = q.poll();
                res.get(currLevel).add(node.data);
                
                if(node.left != null){
                    q.offer(node.left);
                }
                
                if(node.right != null){
                    q.offer(node.right);
                }
            }
            currLevel++;
        }
        
        return res;
    }
}