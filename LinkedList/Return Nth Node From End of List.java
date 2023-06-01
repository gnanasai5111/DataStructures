For example, given the linked list that represents 1 -> 2 -> 3 -> 4 -> 5 and k = 2, 
return the node with value 4, as it is the 2nd node from the end.

First approach(Brute force)
  
1. Find the length of list and loop till last kth node and return 
  
Time complexity - o(n)
Space complexity - o(1)
  
Second approach(Fast and slow pointer)
  
ListNode findNode(ListNode head, int k) {
    ListNode slow = head;
    ListNode fast = head;
    for (int i = 0; i < k; i++) {
        fast = fast.next;
    }

    while (fast != null) {
        slow = slow.next;
        fast = fast.next;
    }
    
    return slow;
}

1. Move the fast pointer K units ahead.
2. Now move both pointers at same speed so when fast reaches end then slow will be at kth poistion.
  
Time complexity - o(n)
Space complexity - o(1)
