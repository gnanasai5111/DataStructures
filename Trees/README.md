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
- Breadth First Search Traversal(BFS)

### DFS

- In a DFS, we prioritize depth by traversing as far down the tree as possible in one direction (until reaching a leaf node)
  before considering the other direction.
- You can think of the paths of a binary tree as branches growing from the root.
-  DFS chooses a branch and goes as far down as possible. Once it fully explores the branch, it backtracks until it finds another unexplored branch

```
  PreOrder(Root -left -Right)
  PostOder(Left - Right - Root)
  InOrder(Left - Root - Right)
```
