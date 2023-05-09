Third approach(Hashing and Priority Queue)
 
class Solution {
    class Pair{
        char ch;
        int count;
        public Pair(char ch,int count){
            this.ch=ch;;
            this.count=count;
        }
    }
    public String frequencySort(String s) {
        PriorityQueue<Pair> res=new PriorityQueue<>((a,b)->b.count-a.count);
        HashMap<Character,Integer> map=new HashMap<>();
        String out="";
        for(int i=0;i<s.length();i++){
            map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)+1);
        }
        for(Character i:map.keySet()){
            res.add(new Pair(i,map.get(i)));
        }
        while(!res.isEmpty()){
            Pair v=res.remove();
            int val=v.count;
            while(val>0){
                out=out+v.ch;
                val--;
            }
        }
        return out;      
    }
}

1. Store the frequencies of elements in hashmap.
2. Add it the frequencies in priority queue in descending order.Append it to string by removing elements from queue.

Time complexity - o(NlogN)
Space complexity  o(N) 
  
Fourth approach(Hashing and bucket sort)
  
class Solution {
    public String frequencySort(String s) {
        int max=0;
        HashMap<Character,Integer> map=new HashMap<>();
        String out="";
        for(int i=0;i<s.length();i++){
            map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)+1);
            if(max<map.get(s.charAt(i))){
                max=map.get(s.charAt(i));
            }
        }
        List<List<Character>> res=new ArrayList<>();
        for(int i=0;i<=max;i++){
            res.add(new ArrayList<>());
        }
        for(Character i:map.keySet()){
            int freq=map.get(i);
            res.get(freq).add(i);
        }
        for(int i=res.size()-1;i>=1;i--){
            for(int j=0;j<res.get(i).size();j++){
                int val=i;
                while(val>0){
                    out=out+res.get(i).get(j);
                    val--;
                }

            }
        }

        return out;      
    }
}

1. Store the count of characters in hashmap and find the max count.
2. Create a nested array list of size equal to count.
3. Based on frequencies of each character ,add it to the index of nested arraylist .
4. Traverse the arraylist from reverse so the most frequent appeared characters appears first.
  
Time complexity - o(N)
Space complexity  o(N) 
