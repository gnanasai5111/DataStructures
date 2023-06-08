In a linked list of size n, where n is even, the ith node (0-indexed) of the linked list is known as the twin of the (n-1-i)th node, if 0 <= i <= (n / 2) - 1.

For example, if n = 4, then node 0 is the twin of node 3, and node 1 is the twin of node 2. These are the only nodes with twins for n = 4.
The twin sum is defined as the sum of a node and its twin.

Given the head of a linked list with even length, return the maximum twin sum of the linked list.
  
Example 1:
Input: head = [5,4,2,1]
Output: 6
Explanation:
Nodes 0 and 1 are the twins of nodes 3 and 2, respectively. All have twin sum = 6.
There are no other nodes with twins in the linked list.
Thus, the maximum twin sum of the linked list is 6. 

First approach(ArrayList)

class Solution {
    public int pairSum(ListNode head) {
        ListNode node=head;
        ArrayList<Integer> a=new ArrayList<>();
        while(node!=null){
            a.add(node.val);
            node=node.next;
        }       
        int max=0;
        for(int i=0;i<a.size()/2;i++){
            max=Math.max(max,a.get(i)+a.get((a.size()-1-i)));
        }
        return max;
        
    }
}
1. Store the elements in arraylist.
2. Iterate through arraylist and get the max Value.

Time complexity - o(N)
Space complexity - o(N)
  
Second approach(Stack)
  
class Solution {
    public int pairSum(ListNode head) {
        ListNode node=head;
        Stack<Integer> s=new Stack<>();
        while(node!=null){
            s.push(node.val);
            node=node.next;
        }  
        node=head;    
        int max=0;
        int size=s.size();
        int count=0;
        while(count<(size/2)){
            max=Math.max(max,node.val+s.pop());
            node=node.next;
            count++;
        }
        
        return max;
        
    }
}

1. Store the elements in stack.
2. Iterate through half Linkedlist and get the max Value from current node value+popping the last value from stack.
  
Time complexity - o(N)
Space complexity - o(N)
