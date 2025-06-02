// Given the head of a singly linked list, your task is to left rotate the linked list k times.

// Note : It does not include the Initialization of the Linked list.



class Solution {
    public Node rotate(Node head, int k) {
        // add code here
        if(k == 0 || head == null){
            return head;
        }
        
        Node curr = head;
        int n = 1;
        while(curr.next != null){
            curr = curr.next;
            n++;
        }
        k %= n;
        
        if(k == 0){
            return head;
        }
        
        curr.next = head;
        curr = head;
        
        for(int i = 1; i < k; i++){
            curr = curr.next;
        }
        head = curr.next;
        curr.next = null;
        
        return head;
    }
}