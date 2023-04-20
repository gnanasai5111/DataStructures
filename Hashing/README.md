# Hash Map and Hash Set

## Hash Map
- Hash Map class implements the Map interface which allows us to store key,value pair.
- Keys are different and values can be same.
- If you try to insert a duplicate key,it will replace the value of that corresponding key.
- HashMaps are unordered maps(not in order).

## Hash Set(unique values)
- The HashSet class implements the Set interface, backed by a hash table which is actually a HashMap instance 
- HashSets are unordered

```
import java.util.*;
public class Hashing{
    public static void main(String args[]){
    //HashMap
    HashMap<String,Integer> map=new HashMap<String,Integer>();
    //Insertion
    map.put("India",120);
    map.put("Australia",40);
    
    // get the element
    map.get("India");  //gets the value
    
    // search
    map.containsKey();  //gives boolean
    
    //Iteration
    for(Map.Entry<String,Integer> m:map.entrySet()){
         System.out.println(m.getKey()+" "+m.getValue());    
 
    }
    map.keySet()  //iterating through keys
    
    //remove
    map.remove(key)  
    
    //HashSet
    HashSet<String> set=new HashSet<String>();
    //Insert
    set.add("ss");
    
    //search
    set.contains("ss"); //returns boolean
    
    //delete
    set.remove("ss");
    
    //Iterator
    Iterator it=set.iterator();
    
    while(it.hasNext()){
    System.out.println(it.next());
    }
    }
    
}
```



### Implementation

- HashMap is array of nodes(Linked list)
- each index in array is called bucket.

- we will send a key as a input to hash function and it returns the bucket index.In that bucket index we will store the key-value pair if it not exists,if it   already exists ,then update the value.

#### Constructors in HashMap is as follows
-> HashMap provides 4 constructors and the access modifier of each is public which are listed as follows:

- HashMap();
- HashMap(int initialCapacity);
- HashMap(int initialCapacity, float loadFactor);
- HashMap(Map map);

**LoadFactor** - It is percent value of capacity,after which capacity has to be increased.This is called Rehashing.Default Load factor in java is 0.75.If the array of buckets gets filled more than 75% then the it has to rehashed(i.e, capacity has to be doubled).

**Threshold** -product of Load Factor and Initial Capacity.

- Default Initial capacity-16.
- Default load factor-0.75.
- Threshold=16*0.75=12.

That is, Rehashing takes place after inserting 12 key-value pairs into the HashMap.

**Rehashing** – It is the process of doubling the capacity of the HashMap after it reaches its Threshold. 



```

// Online Java Compiler
// Use this editor to write, compile and run your Java code online
import java.util.*;
class Hashing {
    
     public static class Pair<K,V>{
            K key;
            V value;
            public Pair(K key,V value){
                this.key=key;
                this.value=value;
                
            }
    }
    private static class HashMap<K,V>{
       
        public class Node{
            K key;
            V value;
            public Node(K key,V value){
                this.key=key;
                this.value=value;
                
            }
        }
        private int N; //no of buckets
        private int n; // no of nodes
        private LinkedList<Node> buckets[]=new LinkedList[4];
        public HashMap(){
            this.N=4;
            for(int i=0;i<4;i++){
                buckets[i]=new LinkedList<>();
            }
        }
        private int hashFunc(K key){
            return Math.abs(key.hashCode())%N;
        }
        
        private int searchInLL(K key,int bi){
            LinkedList<Node> ll=buckets[bi];
            
            for(int i=0;i<ll.size();i++){
                if(ll.get(i).key==key){
                    return i;
                }
                
            }
          
            return -1;
        }
        public void rehash(){
            LinkedList<Node> oldbuckets[]=buckets;
            buckets=new LinkedList[N*2];
            N=N*2;
            for(int i=0;i<oldbuckets.length;i++){
                for(int j=0;j<oldbuckets[i].size();j++){
                    put(oldbuckets[i].get(j).key,oldbuckets[i].get(j).value);
                }
            }
            
            
        }
        public void put(K key,V value){
            int bi=hashFunc(key);
            int ni=searchInLL(key,bi);
            if(ni==-1){
                Node node=new Node(key,value);
                buckets[bi].add(node);
                n++;
            }
            else{
                Node node=buckets[bi].get(ni);
                node.value=value;
            }
            double lamda=(double) n/N;
            if(lamda>2.0){
                rehash();
            }
            
        }
        
        public V get(K key){
            int bi=hashFunc(key);
            int ni=searchInLL(key,bi);
            if(ni==-1){
               return null;
            }
            else{
                Node node=buckets[bi].get(ni);
                return node.value;
            }
            
        }
        
        public V remove(K key){
            int bi=hashFunc(key);
            int ni=searchInLL(key,bi);
            if(ni==-1){
               return null;
            }
            else{
                Node node=buckets[bi].remove(ni);
                n--;
                return node.value;
            }
            
            
        }
         public boolean containsKey(K key){
            int bi=hashFunc(key);
            int ni=searchInLL(key,bi);
            if(ni==-1){
               return false;
            }
            else{
               return true;
            }
            
            
        }
        
        public boolean isEmpty(){
            return n==0;
        }
        public int size(){
            return n;
        }
        
        public ArrayList<K> keySet(){
            ArrayList<K> keys=new ArrayList<>();
            for(int i=0;i<buckets.length;i++){
                for(int j=0;j<buckets[i].size();j++){
                    keys.add(buckets[i].get(j).key);
                }
            }
            return keys;
            
            
        }
        
        public ArrayList<Pair> entrySet(){
            ArrayList<Pair> entries=new ArrayList<>();
             for(int i=0;i<buckets.length;i++){
                for(int j=0;j<buckets[i].size();j++){
                    Pair p=new Pair(buckets[i].get(j).key,buckets[i].get(j).value);
                    entries.add(p);
                }
            }
            return entries;
            
        }
        
    }
    
    public static void main(String[] args) {
        HashMap<String,Integer> map=new HashMap<String,Integer>();
        map.put("India",100);
        map.put("China",99);
        map.put("Usa",20);
        map.put("China",-10000);
        ArrayList<String> keys=map.keySet();
        for(String i:keys){
            System.out.println(i+" "+map.get(i));
        }
        System.out.println(map.containsKey("Indiaaa"));
         System.out.println(map.size());
         System.out.println(map.remove("China"));
           ArrayList<String> keys1=map.keySet();
        for(String i:keys1){
            System.out.println(i+" "+map.get(i));
        }
        
        ArrayList<Pair> entries=map.entrySet();
        for(Pair i:entries){
            System.out.println(i.key+" "+i.value);
        }
       
    }
    
}

```

