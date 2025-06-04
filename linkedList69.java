// Given the head of two singly linked lists num1 and num2 representing two non-negative integers. The task is to return the head of the linked list representing the sum of these two numbers.

// For example, num1 represented by the linked list : 1 -> 9 -> 0, similarly num2 represented by the linked list: 2 -> 5. Sum of these two numbers is represented by 2 -> 1 -> 5.

// Note: There can be leading zeros in the input lists, but there should not be any leading zeros in the output list.


// Note : It does not include the Initialization of the Linked list.




class Solution {
    static Node addTwoLists(Node num1, Node num2) {
        // code here
        num1 = trimLeadingZeros(num1);
        num2 = trimLeadingZeros(num2);
        
        int len1 = countNodes(num1);
        int len2 = countNodes(num2);
        
        if(len1 < len2){
            return  addTwoLists(num2, num1);
        }
        
        int carry = 0;
        num1 = reverse(num1);
        num2 = reverse(num2);
        
        Node res = num1;
        
        while(num2 != null || carry != 0){
            num1.data += carry;
            
            if(num2 != null){
                num1.data += num2.data;
                num2 = num2.next;
            }
            
            carry = num1.data / 10;
            num1.data = num1.data % 10;
            
            if(num1.next == null && (num2 != null || carry != 0)){
                num1.next = new Node(0);
            }
            num1 = num1.next;
        }
        
        return reverse(res);
    }
    
    static Node reverse(Node head){
        Node prev = null;
        Node curr = head;
        Node nxt;
        
        while(curr != null){
            nxt = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nxt;
        }
        return prev;
    }
    
    static int countNodes(Node head){
        int len = 0;
        Node curr = head;
        while(curr != null){
            len += 1;
            curr = curr.next;
        }
        return len;
    }
    
    static Node trimLeadingZeros(Node head){
        while(head != null && head.data == 0){
            head = head.next;
        }
        return head;
    }
} 





