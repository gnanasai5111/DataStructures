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
