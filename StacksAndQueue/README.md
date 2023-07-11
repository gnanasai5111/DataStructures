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

### Check if empty

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

## Implementation of stacks using Arrays,ArrayList and LinkedList
### Arrays

```
import java.util.*;
class Main {
    static class  Stack<G>{
        private G[] a;
        int index;
        int size;
        public Stack(int size){
        a=(G[]) new Object[size];
        index=0;
        this.size=size;
        }
        public void push(G val){
            if(size()==size){
                System.out.println("Stack is full");
                return ;
            }
            a[index]=val;
            index++;
        }
        public G pop(){
            if(size()==0){
                System.out.println("Stack is empty");
                return null;
            }
            G val=a[index-1];
            a[index-1]=null;
            index--;
            return val;
        }
        public void print(){
            G[] res=(G[]) new Object[index];
            for(int i=0;i<index;i++){
                res[i]=a[i];
            }
            
            System.out.println(Arrays.toString(res));
        }
        public int size(){
            return index;
        }
        public boolean isEmpty(){
            return size()==0;
        }
    }
    public static void main(String[] args) {
        Stack<Integer> s=new Stack<>(2);
        s.push(10);
        s.push(20);
        s.push(30);
        s.print();
        s.pop();
        s.push(40);
        s.print();
        System.out.println(s.isEmpty());
    }
}

```
