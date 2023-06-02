Given the head of a singly linked list, reverse the list, and return the reversed list.
  
Example 1:
Input: head = [1,2,3,4,5]
Output: [5,4,3,2,1]

First approach(Iterative approach)

class Solution {
    public ListNode reverseList(ListNode head) {
      ListNode curr=head;
      ListNode prev=null;
      ListNode next=null;
      while(curr!=null){
        next=curr.next;
        curr.next=prev;
        prev=curr;
        curr=next;
      }
      return prev;
    
  }
}

1. Take three nodes curr,prev,next
2. Initially get the next node address and point current node to prev node.
3. Make current as prev node.
4. Make next as current and repeat.
  
Time complexity - o(N)
Space complexity - o(1)
  
Second approach(Recursion)
  
class Solution {
    public ListNode reverseList(ListNode head) {
      if(head==null || head.next==null){
        return head;
      }
      ListNode newHead=reverseList(head.next);
      head.next.next=head;
      head.next=null;
      return newHead;  
  }
}
1.The idea is to reach the last node of the linked list using recursion then start reversing the linked list.
2. Divide the list in two parts – first node and rest of the linked list.
3. Call reverse for the rest of the linked list.
4. Link the rest linked list to first.
5. Fix head pointer to NULL
  
Time complexity - o(N)
Space complexity - o(N)
