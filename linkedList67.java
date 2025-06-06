// Given the head of two sorted linked lists consisting of nodes respectively. The task is to merge both lists and return the head of the sorted merged list.

// Note : It does not include the Initialization of the Linked list.

class Solution {
    Node sortedMerge(Node head1, Node head2) {
        // code here
        
        if(head1 == null) return head2;
        if(head2 == null) return head1;
        
        Node dummy = new Node(-1);
        Node tail = dummy;
        
        while(head1 != null && head2 != null){
            if(head1.data < head2.data){
                tail.next = head1;
                head1 = head1.next;
            } else {
                tail.next = head2;
                head2 = head2.next;
            }
            tail = tail.next;
        }
        
        tail.next = (head1 != null) ? head1 : head2;
        
        return dummy.next;
    }
}