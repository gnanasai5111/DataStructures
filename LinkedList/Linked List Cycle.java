Given head, the head of a linked list, determine if the linked list has a cycle in it.
There is a cycle in a linked list if there is some node in the list that can be reached again by continuously following the
next pointer. Internally, pos is used to denote the index of the node that tail's next pointer is connected to. 
Note that pos is not passed as a parameter.
Return true if there is a cycle in the linked list. Otherwise, return false.
  
Example 1:

Input: head = [3,2,0,-4], pos = 1
Output: true
Explanation: There is a cycle in the linked list, where the tail connects to the 1st node (0-indexed).
  
First approach(Hashset)
  
public class Solution {
    public boolean hasCycle(ListNode head) {
        ListNode node=head;
        HashSet<ListNode> set=new HashSet<>();
        while(node!=null){
            if(set.contains(node)){
                return true;
            }
            set.add(node);
            node=node.next;
        }
        return false;      
    }
}

1. Add the nodes to the set if the node is already visited return true.
  
Time complexity - o(N)
Space complexity - o(N)
  
Second approach(Fast and slow Pointer)
  
public class Solution {
    public boolean hasCycle(ListNode head) {
        ListNode slow=head;
        ListNode fast=head;
        while(fast!=null && fast.next!=null){       
            slow=slow.next;
            fast=fast.next.next;
            if(fast==slow){
                return true;
            }
        }
        return false;      
    }
}

1. Move the fast pointer as twice as fast as slow pointer.If they both collide return true.
  
Time complexity - o(N)
Space complexity - o(1)
