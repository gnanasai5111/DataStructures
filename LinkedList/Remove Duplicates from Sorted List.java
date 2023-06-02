Given the head of a sorted linked list, delete all duplicates such that each element appears only once. 
Return the linked list sorted as well.
  
Example 1:  
Input: head = [1,1,2]
Output: [1,2]

class Solution {
    public ListNode deleteDuplicates(ListNode head) {
      HashSet<Integer> set=new HashSet<>();
      ListNode node=head;
      ListNode prev=head;
      while(node!=null){     
        if(set.contains(node.val)){  
          prev.next=node.next;
          node.next=null;
          node=prev;
          node=node.next;      
        }
        else{
          set.add(node.val);
          prev=node;
          node=node.next;
        }
      }
      return head;        
    }
}

1. Add elements to hashset.
2. If the element is already in hashset,point the prev element to currrent next address and point current to null.
3. And also make prev as current.
  
Time complexity - o(N)
Space complexity - o(N)
  
Second approach(Brute force)
  
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
      ListNode node=head;
      ListNode prev=head;
      int c=0;
      int p=-101;
      while(node!=null){    
        c=node.val; 
        if(p==c){  
          prev.next=node.next;
          node.next=null;
          node=prev;
          c=node.val;
          node=node.next;      
        }
        else{
          prev=node;
          p=node.val;
          node=node.next;
        }
      }
      return head;        
    }
}

(or)

class Solution {
    public ListNode deleteDuplicates(ListNode head) {
      ListNode node=head;
      while(node!=null && node.next!=null){    
        if(node.val==node.next.val){  
         node.next=node.next.next;        
        }
        else{
         node=node.next;
        }
      }
      return head;        
    }
}

1. Compare the current node value with prev node value, If they  are equal point the prev node to current next
and point current to null.
2 .Make prev as current and reeat for all elements

Time complexity - o(N)
Space complexity - o(1)
