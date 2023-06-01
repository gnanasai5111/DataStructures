Given the head of a linked list, remove the nth node from the end of the list and return its head.
  
Example 1:
Input: head = [1,2,3,4,5], n = 2
Output: [1,2,3,5]

First approach(Brute force)
  
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
     ListNode node=head;
     int count=0;
     while(node!=null){
         node=node.next;
         count++;
     }
     ListNode temp=head;
     ListNode prev=head;
     for(int i=0;i<=count-n;i++){
         if(i==count-n){
             if(i==0){
                 head=temp.next;
                 return head;
             }
             else if(i==count-1){
                 prev.next=null;
                 return head;
             }
             else{
                 prev.next=temp.next;
                 temp.next=null;
                 return head;
             }
         }
         prev=temp;
         temp=temp.next;
         
     }
      return head;   
    }
}

1. Find the length of the list.
2. Traverse the list till the node to be removed.There are 3 cases when a node is removed
   a) If First element has to removed,make head as second element 
   b) If Last element has to be removed,point the last second element to null.
   c) If any other element has to be removed , point the prev element to current element next and point current element to null.
  
Time complexity - o(N)
Space complexity - o(1)
