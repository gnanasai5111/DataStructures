Given the head of a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.
Return the linked list sorted as well.

Input: head = [1,2,3,3,4,4,5]
Output: [1,2,5]

First Approach(Sentinel Head + Previous element)

class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null || head.next==null){
            return head;
        }
        ListNode dummy=new ListNode(0);
        dummy.next=head;
        ListNode curr=head;
        ListNode prev=dummy;
        while(curr!=null && curr.next!=null){
            if(curr.val==curr.next.val){
                ListNode simEl=curr;
                while(simEl!=null && simEl.next!=null && simEl.val==simEl.next.val){
                    simEl=simEl.next;
                }
                curr=prev;
                prev.next=simEl.next;
                
            }
            else{
               prev=curr;
               curr=curr.next;
              
            }
        }
        return dummy.next;
        
    }
}

1. Take a dummy node and point it to head.And also point prev node to dummy
2. If elements are similar,have a copy of previous element which is not similar and point it to the adress of unsimilar element
3. Lastly return dummy.next node

Time complexity - o(N)
Space complexity - o(1)
