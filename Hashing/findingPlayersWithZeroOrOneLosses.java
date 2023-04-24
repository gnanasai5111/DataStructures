First approach(Brute force)
  
class Solution {
    public List<List<Integer>> findWinners(int[][] matches) {
        List<List<Integer>> res=new ArrayList<>();   
        HashSet<Integer> set1=new HashSet<>();
        HashSet<Integer> set2=new HashSet<>();
        for(int i=0;i<matches.length;i++){
            int notLost=matches[i][0];
            int oneLost=matches[i][1];
            int count=0;
            int count1=0;
            for(int j=0;j<matches.length;j++){
                if(notLost==matches[j][1]){
                    count++;
                }
                if(oneLost==matches[j][1]){
                    count1++;
                }     
            }
            System.out.println(i+" "+count+" "+count1);
            if(count==0){
               set1.add(notLost);             
            }
            if(count1==1){
                set2.add(oneLost);
            }
        }
         ArrayList<Integer> inner1=new ArrayList<>(set1);
         ArrayList<Integer> inner2=new ArrayList<>(set2);
        Collections.sort(inner1);
        Collections.sort(inner2);
        res.add(inner1);
        res.add(inner2);
        return res;
    }
}

1.Traverse the array and check for the notlost matches and onelost matches and add them to arraylist and sort them.use hashset to avoid duplicates

Time complexity - o(n*n)
Space complexity - o(n)
  
 Second approach(Hashing)
  
 class Solution {
    public List<List<Integer>> findWinners(int[][] matches) {
        List<List<Integer>> res=new ArrayList<>();   
         HashMap<Integer,Integer> h1=new HashMap<>();
         HashMap<Integer,Integer> h2=new HashMap<>();
        for(int i=0;i<matches.length;i++){
            int notLost=matches[i][0];
            int oneLost=matches[i][1];
            if(!h2.containsKey(notLost)){
               h1.put(notLost,h1.getOrDefault(notLost,0)+1);
            }
            if(h1.containsKey(oneLost)){
                h1.remove(oneLost);
            }
             h2.put(oneLost,h2.getOrDefault(oneLost,0)-1);  
        }
        ArrayList<Integer> inner1=new ArrayList<>();
         ArrayList<Integer> inner2=new ArrayList<>();
        for(Integer i:h1.keySet()){
            if(h1.get(i)>0){
                inner1.add(i);
            }
        }
        for(Integer i:h2.keySet()){
            if(h2.get(i)==-1){
                inner2.add(i);
            }
        }
        Collections.sort(inner1);
        Collections.sort(inner2);
        res.add(inner1);
        res.add(inner2);
        return res;
    }
}

1. Add all the elements with no losses to one hashmap and element with losses in other hashmap.
  
Time complexity - o(nlogn)
Space complexity - o(n)
  
Second approach(Hashing-single hashmap)
  
class Solution {
    public List<List<Integer>> findWinners(int[][] matches) {
        List<List<Integer>> res=new ArrayList<>();   
         HashMap<Integer,Integer> h1=new HashMap<>();
        for(int i=0;i<matches.length;i++){
            int notLost=matches[i][0];
            int oneLost=matches[i][1];
            if(!h1.containsKey(notLost)){
            h1.put(notLost,h1.getOrDefault(notLost,0)+1);
            }
            if(h1.containsKey(oneLost) && h1.get(oneLost)>=1){
                h1.put(oneLost,-1);
            }
            else{
                h1.put(oneLost,h1.getOrDefault(oneLost,0)-1);  
            }
        }
        ArrayList<Integer> inner1=new ArrayList<>();
        ArrayList<Integer> inner2=new ArrayList<>();
        for(Integer i:h1.keySet()){
            if(h1.get(i)>0){
                inner1.add(i);
            }
            if(h1.get(i)==-1){
                inner2.add(i);
            }
        }
        Collections.sort(inner1);
        Collections.sort(inner2);
        res.add(inner1);
        res.add(inner2);
        return res;
    }
}

1. In hashmap, find the count of wins and losses .
  
Time complexity - o(nlogn)
Space complexity - o(n)
