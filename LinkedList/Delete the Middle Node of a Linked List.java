You are given the head of a linked list. Delete the middle node, and return the head of the modified linked list.

The middle node of a linked list of size n is the ⌊n / 2⌋th node from the start using 0-based indexing, where ⌊x⌋ denotes the largest integer
less than or equal to x.

For n = 1, 2, 3, 4, and 5, the middle nodes are 0, 1, 1, 2, and 2, respectively.


Input: head = [1,3,4,7,1,2,6]
Output: [1,3,4,1,2,6]
Explanation:
The above figure represents the given linked list. The indices of the nodes are written below.
Since n = 7, node 3 with value 7 is the middle node, which is marked in red.
We return the new list after removing this node.

First approach(2 passes)

class Solution {
    public ListNode deleteMiddle(ListNode head) {
        int middle=0;
        ListNode curr=head;
        while(curr!=null){
            curr=curr.next;
            middle++;
        }
        curr=head;
        middle=middle/2;
        if(middle==0){
            return null;
        }
        int index=0;
        ListNode prev=null;
        while(curr!=null){
            if(index==middle){
                ListNode temp=curr.next;
                prev.next=temp;
                curr=prev;
            }
            prev=curr;
            curr=curr.next;
            index++;
        }
        return head;
        
    }
}

1. Firstly traverse the linkedlist and get the total length.
2. Find the middle index, iterate till the middle index and get the prev node and delete the current node and point it to next node

Time complexity - o(N)
Space complexity - o(1)

Second approach(Fast and slow pointer)

class Solution {
    public ListNode deleteMiddle(ListNode head) {
        if(head.next==null){
            return null;
        }
        ListNode slow=head;
        ListNode fast=head.next.next;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;        }
        slow.next=slow.next.next;

        return head;
    }
}

1. Use two pointer, fast should we as twice as fast as slow.so when fast reaches end slow will exactly be at the middle.
2. We start fast at 2 indexes forward because we need the node before middle node.
3. Point the slow node to slow.next.next.

Time complexity - o(N)
Space complexity - o(1)
