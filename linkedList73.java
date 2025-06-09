// Given the head of a linked list that may contain a loop.  A loop means that the last node of the linked list is connected back to a node in the same list. The task is to remove the loop from the linked list (if it exists).

// Custom Input format:

// A head of a singly linked list and a pos (1-based index) which denotes the position of the node to which the last node points to. If pos = 0, it means the last node points to null, indicating there is no loop.

// The generated output will be true if there is no loop in list and other nodes in the list remain unchanged, otherwise, false.



class Solution {
    // Function to remove a loop in the linked list.
    public static void removeLoop(Node head) {
        // code here
        if(head == null || head.next == null) return ;
        
        Node slow = head, fast = head;
        
        slow = slow.next;
        fast = fast.next.next;
        
        while(fast != null && fast.next != null){
            if(slow == fast){
                break;
            }
            
            slow = slow.next;
            fast = fast.next.next;
        }
        
        if(slow == fast){
            slow = head;
            
            if(slow != fast){
                while(slow.next != fast.next){
                    slow = slow.next;
                    fast = fast.next;
                }
                
                fast.next = null;
            } else {
                while(fast.next != slow){
                    fast = fast.next;
                }
                
                fast.next = null;
            }
        }
    }
}