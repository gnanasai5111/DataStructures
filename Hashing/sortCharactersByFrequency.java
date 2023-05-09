First approach(Arrays and sorting)
 
 class Solution {
    public String frequencySort(String s) {
        char ch[]=s.toCharArray();
        Arrays.sort(ch);
        ArrayList<String> res=new ArrayList<>();
        String out="";
        String appendChar=""+ch[0];
        for(int i=1;i<ch.length;i++){
            if(ch[i]!=ch[i-1]){
                res.add(appendChar);
                appendChar=""+ch[i];
            }
            else{
                appendChar+=ch[i];
            }        
        }
         res.add(appendChar);
        Collections.sort(res,(a,b)->b.length()-a.length());
        for(int i=0;i<res.size();i++){
           for(int j=0;j<res.get(i).length();j++){
               out=out+res.get(i).charAt(j);
           }
        }

        return out;      
    }
}

1. Sort the array.Make the same elements as string and add to arrayList.
2. Sort the  list based on length of string.
3. Append it to the output by traversing through list.
 
Time complexity - o(NlogN)
Space complexity - o(N)

Second approach(Hashing and sorting)
 
class Solution {
    public String frequencySort(String s) {
        HashMap<Character,Integer> map=new HashMap<>();
        String out="";
        for(int i=0;i<s.length();i++){
            map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)+1);
        }
        List<Character> res=new ArrayList<>();
        for(Character i:map.keySet()){
            res.add(i);
        }
        Collections.sort(res,(a,b)->map.get(b)-map.get(a));
        for(int i=0;i<res.size();i++){
            int count=map.get(res.get(i));
            while(count>0){
                out=out+res.get(i);
                count--;
            }
        }

        return out;      
    }
}

1. Store the frequencies of elements in hashmap.
2. Put the elements to list based on frequencies of elements by sorting.And append it to string .

Time complexity - o(NlogN)
Space complexity  o(N) 

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
