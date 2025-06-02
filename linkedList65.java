// Given the head of a linked list, the task is to reverse this list and return the reversed head.

// Note : It does not include the Initialization of the Linked list.


class Solution {
    Node reverseList(Node head) {
        // code here
       Node curr = head, prev = null, nxt;
       
       while(curr != null){
           nxt = curr.next;
           
           curr.next = prev;
           
           prev = curr;
           curr = nxt;
       }
       
       return prev;
    }
}