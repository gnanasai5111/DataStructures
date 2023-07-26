# Trees 

- A Tree data structure is a collection of objects called as node that are linked together to form a hierarchy.
- It is a non linear data structure because elements are not stored in a sequential manner.
- A tree is a type of graph .Graph is a collection of nodes and there pointers to other nodes.

### Tree Terminology

  -> **Root** - Top most node in the heirarchy is called the root node.
  -> **Parent** - If the node contains any child nodes,then that node is said to be the parent of child node.
  -> **Child** - If the node is descendant of any node,then it is called as child node
  -> **Leaf** - If the node has no children, then it is called leaf node.
  -> **Sibling** - The nodes that have same parent are called sibling nodes.
  -> **Ancestors** - Nodes upwards i.e, towards the root. Root node doesnt have any ancestors.
  -> **Descendants** - Nodes downwards i.e, towarfs the lead. Leaf node doesnt have any descendants.

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
