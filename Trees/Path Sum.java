Given the root of a binary tree and an integer targetSum, return true if the tree has a root-to-leaf path such that adding up all the values along
the path equals targetSum.

A leaf is a node with no children.

Input: root = [5,4,8,11,null,13,4,7,2,null,null,null,1], targetSum = 22
Output: true
Explanation: The root-to-leaf path with the target sum is shown.

First approach(Recursion)

class Solution {
    int sum=0;
    boolean flag=false;
    public void calculateSum(TreeNode node,int targetSum,TreeNode oldNode){
        if(node==null){
           if(sum==targetSum && oldNode.left==null && oldNode.right==null){
               flag=true;
           }
           return;
        }
        sum=sum+node.val;
        calculateSum(node.left,targetSum,node);
        calculateSum(node.right,targetSum,node);
        sum=sum-node.val;
    }
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root==null){
            return false;
        }
        calculateSum(root,targetSum,root);
        return flag;        
    }
}

1. Recursively traverse the nodes,when you go through a node add it to the sum and when you come back from the node,subtract the node value from sum.
2. Keep track of old node,to check whether that node is leaf node or not.

Time complexity - o(N)
Space complexity - o(N)

Second approach(Recursion)

class Solution {
    int sum=0;    
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root==null){
            return false;
        }
        targetSum-=root.val;
        if(root.left==null && root.right==null){
            return targetSum==0;
        }
       
        return hasPathSum(root.left,targetSum) || hasPathSum(root.right,targetSum);
    }
}

1. First check the sum for the entire left sub tree ,if it is true return true else check for entire right sub tree as well

Time complexity - o(N)
Space complexity - o(N)

Third approach(Iterative approach)

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    class Pair {
    TreeNode node;
    int curr;
    Pair(TreeNode node, int curr) {
        this.node = node;
        this.curr = curr;
    }
    }
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root==null){
            return false;
        }
        Stack<Pair> s=new Stack<>();
        s.push(new Pair(root,0));
        while(!s.isEmpty()){
            Pair val=s.pop();
            TreeNode node=val.node;
            int curr=val.curr;
            if(node.left==null && node.right==null){
                if(curr+node.val==targetSum){
                    return true;
                }
            }
            if(node.left!=null){
                s.push(new Pair(node.left,curr+node.val));
            }
            if(node.right!=null){
                s.push(new Pair(node.right,curr+node.val));
            }
        }
        return false;
    }
}

1. Push the root element to stack with sum=0,pop the element and check if it is leaf node or not by checking it has child nodes 
2. check whether the node value sum is equal to the target sum, if yes return true else repeat the process by inserting left and child.

Time complexity - o(N)
Space complexity - o(N)
