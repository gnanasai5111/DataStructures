First approach(Brute force)
  
class Solution {
    public int minimumCardPickup(int[] cards) {
        int min=Integer.MAX_VALUE;
        for(int i=0;i<cards.length;i++){
           for(int j=i+1;j<cards.length;j++){
               if(cards[i]==cards[j]){
                   min=Math.min(min,j-i+1);
               }

           }
        }
        return min==Integer.MAX_VALUE?-1:min;
        
    }
}

1. Traverse the array and check for similar elements and find length .Repeat this process till you find min length.
  
Time complexity - o(n*n)
Space complexity - o(1)
  
Second approach(Hashing)
  
class Solution {
    public int minimumCardPickup(int[] cards) {
        int min=Integer.MAX_VALUE;
        HashMap<Integer,List<Integer>> map=new HashMap<>();
        for(int i=0;i<cards.length;i++){
            if(!map.containsKey(cards[i])){
                map.put(cards[i],new ArrayList<>());
            }
            map.get(cards[i]).add(i);
        }
        for(Integer i:map.keySet()){
            for(int j=1;j<map.get(i).size();j++){
                min=Math.min(min,map.get(i).get(j)-map.get(i).get(j-1)+1);
            }
        }
        return min==Integer.MAX_VALUE?-1:min;
        
    }
}

1. Add elements to hashmamp,and store the values as arrayList
2. Traverse the hashmap and check in each key so that difference in values of arraylist should be minimum

Time complexity - o(n)
Space complexity - o(n)

Third approach(Hashing)
  
class Solution {
    public int minimumCardPickup(int[] cards) {
        HashMap<Integer,Integer> map=new HashMap<>();
        int min=Integer.MAX_VALUE;
        for(int i=0;i<cards.length;i++){
            if(map.containsKey(cards[i])){
                min=Math.min(min,i-map.get(cards[i])+1);
            }
            map.put(cards[i],i);
        }
        return min==Integer.MAX_VALUE?-1:min;
        
    }
}

1. Add elements to hashmamp,if the element already exists, then subtract the current index with already existing index in hashmap.
2. Repeat this process till you find min length.

Time complexity - o(n)
Space complexity - o(n)
