# Trees 

- A Tree data structure is a collection of objects called as node that are linked together to form a hierarchy.
- It is a non linear data structure because elements are not stored in a sequential manner.
- A tree is a type of graph .Graph is a collection of nodes and there pointers to other nodes.

### Tree Terminology

  - **Root** - Top most node in the heirarchy is called the root node.
  - **Parent** - If the node contains any child nodes,then that node is said to be the parent of child node.
  - **Child** - If the node is descendant of any node,then it is called as child node
  - **Leaf** - If the node has no children, then it is called leaf node.
  - **Sibling** - The nodes that have same parent are called sibling nodes.
  - **Ancestors** - Nodes upwards i.e, towards the root. Root node doesnt have any ancestors.
  - **Descendants** - Nodes downwards i.e, towarfs the lead. Leaf node doesnt have any descendants.

### Depth of the tree

 - The depth of a node is how far it is from the root node. The root has a depth of 0. Every child has a depth of parentDepth+1.


### Code

```

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode (int val) {
        this.val = val;
    }
}

```

### Tree Traversals

- Depth First Search Traversal(DFS)(DFS Traversal can be done in 3 ways - Inorder,Preorder,Postorder)
- Breadth First Search Traversal(BFS)(level wise visiting)

### DFS

- In a DFS, we prioritize depth by traversing as far down the tree as possible in one direction (until reaching a leaf node)
  before considering the other direction.
- You can think of the paths of a binary tree as branches growing from the root.
-  DFS chooses a branch and goes as far down as possible. Once it fully explores the branch, it backtracks until it finds another unexplored branch


![image](https://github.com/gnanasai5111/DataStructures/assets/56872239/8a6f5934-e3d2-42ed-8c30-e7c1f597bdd7)

```
  PreOrder(Root -left -Right) - (0134625)
  PostOder(Left - Right - Root) - (3641520)
  InOrder(Left - Root - Right) - (3146025)
```

### Types of Binary Tree

1. Full Binary Tree - every node has either 0 or 2 children
2. Complete Binary Tree - All levels are completely filled except the last level.The last level has all nodes to as left as possible.
3. Perfect Binary Tree - All leaf nodes are at same level.
4. Balanced Binary Tree - height of the tree should be max of o(logn) where n is number of nodes.
5. Degenerate Binary Tree - A degenerate tree is a binary tree in data structure in which each parent node has only one child node associated with it. Such a tree will behave in the manner of linked list data structure
