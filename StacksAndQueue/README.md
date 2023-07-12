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

### ArrayList

```
import java.util.*;
class StackClass {
    static class Stack{
        ArrayList<Integer> list=new ArrayList<>();
        public boolean isEmpty(){
            return list.size()==0;
        }
        public  void push(int data){
            list.add(data);
        }
        public int pop(){
            if(isEmpty()){
                return -1;
            }
            int top=list.get(list.size()-1);
            list.remove(list.size()-1)
           return ;
        }
        public int peek(){
            if(isEmpty()){
                return -1;
            }
            return list.get(list.size()-1);
            
        }
    }
    public static void main(String[] args) {
        Stack s=new Stack();
        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);
        while(!s.isEmpty()){
            System.out.println(s.peek());
            s.pop();
        }
    }
}
```

### Linkedlist

```
// Online Java Compiler
// Use this editor to write, compile and run your Java code online
import java.util.*;
class StackClass {
     static class Node<G>{
         G data;
         Node next;
         Node(G data){
             this.data=data;
             next=null;
         }
     }
     static class Stack<G>{
         Node<G> head;
         public void push(G data){
             Node<G> newNode=new Node(data);
             if(head==null){
               head=newNode;
             }
             else{
                newNode.next=head;
                head=newNode;
             }
         }
         public G pop(){
             if(isEmpty()){
                return null;
             }
             G val=head.data;
             head=head.next;
             return val;
         }
         public boolean isEmpty(){
             return head==null;
         }
         public G peek(){
             if(isEmpty()){
                return null;
             }
             return head.data;
         }
     }
    public static void main(String[] args) {
        Stack<String> s=new Stack<>();
        s.push("india");
        s.push("UK");
        s.push("canada");
        while(!s.isEmpty()){
            System.out.println(s.pop());
        }
        s.push("Australia");
        System.out.println(s.peek());
    }
}
```
## Queue

- It is an ordered list of objects, where insertion of elements occurs at the end of the list(rear), and removal of elements occur 
  at the beginning of the list(front).
- It follows First in first out structure(FIFO)


**Operation 

```

Enque - add
Dequeue - remove
Front - peek 
```

***Implementation

Arrays,arraylist and linkedlist


```
class QueueCode {
    public static class Queue{
        int a[];
        int size;
        int rear=-1;
        public Queue(int size){
            a=new int[size];
            this.size=size;
        }
        public boolean isEmpty(){
            return rear==-1;
        }
        public void add(int data){
            if(rear==size-1){
                System.out.println("Full Queue");
                return ;
            }
            rear++;
            a[rear]=data;
        }
         public int remove(){
            if(rear==-1){
                System.out.println("Empty Queue");
                return -1 ;
            }
            int top=a[0];
            for(int i=0;i<rear;i++){
                a[i]=a[i+1];
            }
            rear--;
            return top;
        }
          public int peek(){
            if(rear==-1){
                System.out.println("Empty Queue");
                return -1;
            }
           return a[0];
        }
    }
    public static void main(String[] args) {
      Queue q=new Queue(5);
      q.add(10);
      q.add(20);
      q.add(30);
      q.remove();
      while(!q.isEmpty()){
          System.out.println(q.peek());
          q.remove();
          
      }
    }
}
```

*** Circular queue

A circular queue is the extended version of a regular queue where the last element is connected to the first element.
Thus forming a circle-like structure.


```
class QueueCode {
    public static class CQueue{
        int a[];
        int size;
        int rear=-1;
        int front=-1;
        public CQueue(int size){
            a=new int[size];
            this.size=size;
        }
        public boolean isEmpty(){
            return rear==-1 && front==-1;
        }
        public boolean isFull(){
            return (rear+1)%size==front;
        }
        public void add(int data){
            if(isFull()){
                System.out.println("Full Queue");
                return ;
            }
            if(front==-1){
                front=0;
            }
            rear=(rear+1)%size;
            a[rear]=data;
        }
         public int remove(){
            if(isEmpty()){
                System.out.println("Empty Queue");
                return -1 ;
            }
            int top=a[front];
            // single elemnt condition
            if(rear==front){
                rear=-1;
                front=-1;
            }
            else{
                front=(front +1)%size;
            }
            return top;
        }
          public int peek(){
            if(isEmpty()){
                System.out.println("Empty Queue");
                return -1;
            }
           return a[front];
        }
    }
    public static void main(String[] args) {
      CQueue q=new CQueue(6);
      q.add(10);
      q.add(20);
      q.add(30);
      q.add(40);
      q.add(50);
      q.remove();
      q.add(6);
      q.remove();
      while(!q.isEmpty()){
          System.out.println(q.peek());
          q.remove();
          
      }
    }
}
```


##LinkedList

```
class QueueCode {
    public static class Node{
        int data;
        Node next;
        public Node(int data){
            this.data=data;
            next=null;
            
        }
    }
    public static class Queue{
         Node head=null;
         Node tail=null;
        public boolean isEmpty(){
            return head==null && tail==null;
        }
      
        public void add(int data){
            Node node=new Node(data);
            if(tail==null){
              tail=node;
              head=node;
              return ;
            }
            else{
              tail.next=node;
              tail=node;   
            }
           
          
        }
         public int remove(){
              if(isEmpty()){
                System.out.println("Empty Queue");
                return -1;
            }
           int front=head.data;
           if(head==tail){
               tail=null;
           }
           head=head.next;
           return head.data;
        }
          public int peek(){
            if(isEmpty()){
                System.out.println("Empty Queue");
                return -1;
            }
           return head.data;
        }
    }
    public static void main(String[] args) {
      Queue q=new Queue();
      q.add(10);
      q.add(20);
      q.add(30);
      q.add(40);
      q.add(50);
      q.remove();
      q.add(6);
      q.remove();
      while(!q.isEmpty()){
          System.out.println(q.peek());
          q.remove();
          
      }
    }
}
```


### Queue using two stacks

```
class QueueCode {
    public static class Queue{
         Stack<Integer> s1=new Stack<>();
         Stack<Integer> s2=new Stack<>();
         
         public  boolean isEmpty(){
             return s1.size()==0;
         }
         public void add(int data){
             while(!s1.isEmpty()){
                 s2.push(s1.pop());
             }
             s1.push(data);
             while(!s2.isEmpty()){
                 s1.push(s2.pop());
             }
         }
         public int remove(){
             if(s1.isEmpty()){
                 System.out.println("Empty Queue");
                 return -1;
             }
             int res=s1.pop();
             return res;
         }
          public int peek(){
             if(s1.isEmpty()){
                 System.out.println("Empty Queue");
                 return -1;
             }
             int res=s1.peek();
             return res;
         }
        }
    
    public static void main(String[] args) {
      Queue q=new Queue();
      q.add(10);
      q.add(20);
      q.add(30);
      q.add(40);
      q.add(50);
      q.remove();
      q.add(6);
      q.remove();
      while(!q.isEmpty()){
          System.out.println(q.peek());
          q.remove();
          
      }
    }
}
```

### Monotonic stack

- Its simply a stack where the elements are always in the sorted order.
- Monotonic decreasing means that the stack will always be sorted in descending order.
- Monotonic Increasing means that the stack will always be sorted in increasing order.
