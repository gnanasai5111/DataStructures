Given the root of a binary tree, return its maximum depth.

A binary tree's maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.

https://assets.leetcode.com/uploads/2020/11/26/tmp-tree.jpg

Input: root = [3,9,20,null,null,15,7]
Output: 3

First approach (Recursion)

class Solution {
    int count=0;
    int max=0;
    public void traverse(TreeNode node){
        if(node==null){
            if(count>max){
                max=count;
            }
            return;
        }
        count++;
        traverse(node.left);
        traverse(node.right);
        count--;
    }
    public int maxDepth(TreeNode root) {
        traverse(root);
        return max;
        
    }
}

1. Increment the count on whenver you visit a node, and when you backtrack subtract the count beacuse are coming back from that node.

Time complexity - o(N)
Space complexity - o(N)

Second approach (Optimised Recursion)

class Solution {
    public int maxDepth(TreeNode root) {
       if(root==null){
           return 0;
       }
       int left=maxDepth(root.left);
       int right=maxDepth(root.right);
       return Math.max(left,right)+1;
        
    }
}

1. At each node, check the left subtree height and the right subtree height and find the max of it plus add 1.

Time complexity - o(N)
Space complexity - o(N)

3. Third approach(Iterative approach)

class Solution {
    class Pair{
        TreeNode node;
        int val;
        public Pair(TreeNode node,int val){
            this.val=val;
            this.node=node;
        }
    }
    public int maxDepth(TreeNode root) {
       if(root==null){
           return 0;
       }
       Stack<Pair> s=new Stack<>();
       s.push(new Pair(root,1));
       int max=0;
       while(!s.isEmpty()){
           Pair element=s.pop();
           TreeNode node=element.node;
           int val=element.val;
           max=Math.max(val,max);
           if(node.left!=null){
               s.push(new Pair(node.left,val+1));
           }
           if(node.right!=null){
               s.push(new Pair(node.right,val+1));
           }
       }
       return max;
        
    }
    
}

1. Use a stack and push the root element also add one as a length.
2. Next check if the root has left and right child and push them into stack and add +1 to the length from thr root.
3. Pop the elements from the stack and find the max.

Time complexity - o(N)
Space complexity - o(N)

    
