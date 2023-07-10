## Stack

- Stack is a linear data structure that follows LIFO(Last in first out) principle.
- Insertion and deletion of elements are done at the same end,which is from top of the stack.

Stack<Integer> stack = new Stack<>();

### Pushing elements:

```
stack.push(1);
stack.push(2);
stack.push(3);
```

### Popping elements:

```
stack.pop(); // 3
stack.pop(); // 2
```

// Check if empty

```
stack.empty(); // false
```

### Check element at top

```
stack.peek(); // 1
```

### Get size

```
stack.size(); // 1
```
