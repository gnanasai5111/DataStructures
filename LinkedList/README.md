### Linked List
- A linked list is a linear data structure, in which the elements are not stored at contiguous memory locations. The elements in a linked list are linked using pointers.
- In simple words, a linked list consists of nodes where each node contains a data field and a reference(link) to the next node in the list.


![image](https://github.com/gnanasai5111/DataStructures/assets/56872239/1e4b5e45-9030-4da4-b9c7-ededa43dd736)



## Advantages
- Arrays have fixes sizes and even dynamic arrays have to be resized.
-  The main advantage of a linked list is that you can add and remove elements at any position in O(1). The caveat is that you need to have a reference to a node at the position in which you want to perform the addition/removal, otherwise the operation is O(n), because you will need to iterate starting from the head until you get to the desired position. However, this is still much better than a normal (dynamic) array, which requires O(n) for adding and removing from an arbitrary position.

## Drawbacks
- Random access is not allowed
- More overhead then arrays because every element needs to have extra storage for the pointers.
