Given the head of a singly linked list, return the middle node of the linked list.
If there are two middle nodes, return the second middle node. 
  
Example 1:

Input: head = [1,2,3,4,5]
Output: [3,4,5]
Explanation: The middle node of the list is node 3.
  
First approach(Brute force)
  
class Solution {
    public ListNode middleNode(ListNode head) {
       ListNode node=head;
       int count=0;
       while(node!=null){
           node=node.next;
           count++;
       }
       for(int i=0;i<count/2;i++){
           head=head.next;
       }
       return head;       
    }
}

1. Traverse the linked list and get the length.
2. Traverse the list again and when the pointer reaches half the length of the list return the node.
  
Time complexity - o(N)
Space complexity - o(1)
  
Second approach(Fast and slow Pointer)
  
class Solution {
    public ListNode middleNode(ListNode head) {
       ListNode slow=head;
       ListNode fast=head;
       while(fast!=null && fast.next!=null){
          slow=slow.next;
          fast=fast.next.next;
       }
       return slow;
         
    }
}

1. Move the fast pointer twice as fast as other so when the fast reaches end of the list slow would be at half stage.
  
Time complexity - o(N)
Space complexity - o(1)
