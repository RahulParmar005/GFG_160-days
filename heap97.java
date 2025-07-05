// Given an array arr[] of n sorted linked lists of different sizes. The task is to merge them in such a way that after merging they will be a single sorted linked list, then return the head of the merged linked list.


class Solution {
    
    static Node mergeTwoNodes(Node head1, Node head2){
        Node dummy  = new Node(-1);
        Node curr = dummy;
        
        while(head1 != null && head2 != null){
            if(head1.data <= head2.data){
                curr.next = head1;
                head1 = head1.next;
            } else {
                curr.next = head2;
                head2 = head2.next;
            }
            curr = curr.next;
        }
        
        if(head1 != null){
            curr.next = head1;
        } else {
            curr.next = head2;
        }
        
        return dummy.next;
    }
    
    // Function to merge K sorted linked list.
    Node mergeKLists(List<Node> arr) {
        // Add your code here.
        Node res = null;
        
        for(Node node : arr){
            res = mergeTwoNodes(res, node);
        }
        
        return res;
    }
}