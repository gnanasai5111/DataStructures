First approach(Frequency counter)
class Solution {
    public boolean closeStrings(String word1, String word2) {
        if (word1.length() != word2.length()) {
            return false;
        }
        int word1Map[] = new int[26];
        int word2Map[] = new int[26];
        for (char c : word1.toCharArray()) {
            word1Map[c - 'a']++;
        }
        for (char c : word2.toCharArray()) {
            word2Map[c - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            if ((word1Map[i] == 0 && word2Map[i] > 0) ||
                (word2Map[i] == 0 && word1Map[i] > 0)) {
                return false;
            }
        }
        Arrays.sort(word1Map);
        Arrays.sort(word2Map);
        for(int i=0;i<26;i++){
            if(word1Map[i]!=word2Map[i]){
                   return false;
            }
        }
        return true;
        
    }
}

1. Take count of characters of both strings.
2. Check if a character appears in both Counters.If it doesnt return false.
3. Sort the array.
4. Check if tvalues in both the arrays are same or not.If not return false;

Time complexity - o(m+n)
Space complexity - o(1) - sorting takes o(26log26) since there are max of 26 charcters so its constant time.


Second approach(Hashing and sorting)
  
class Solution {
    public boolean closeStrings(String word1, String word2) {
        HashMap<Character,Integer> map1=new HashMap<>();
        HashMap<Character,Integer> map2=new HashMap<>();
        List<Integer> c1=new ArrayList<>();
        List<Integer> c2=new ArrayList<>();
        for(int i=0;i<word1.length();i++){
            map1.put(word1.charAt(i),map1.getOrDefault(word1.charAt(i),0)+1);
        }
        for(int i=0;i<word2.length();i++){
            if(!map1.containsKey(word2.charAt(i))){
                return false;
            }
            map2.put(word2.charAt(i),map2.getOrDefault(word2.charAt(i),0)+1);
        }
        for(Integer i:map1.values()){
               c1.add(i);
        }
        for(Integer i:map2.values()){
               c2.add(i);
        }
        Collections.sort(c1);
        Collections.sort(c2);
        for(Integer i=0;i<c1.size();i++){
               if(c1.get(i).intValue()!=c2.get(i).intValue()){
                   return false;
               }
        }
        return true;
        
    }
}

1. Take count of characters of both strings in two hashmaps.
2. Check if a character appears in both hashmap.If it doesnt return false.
3. Add the counts to a lits and sort it 
4. Check if tvalues in both the list are same or not.If not return false;

Time complexity - o(m+n)
Space complexity - o(1) - sorting takes o(26log26) since there are max of 26 charcters so its constant time.

Third approach(Hashing)
  
class Solution {
    public boolean closeStrings(String word1, String word2) {
        HashMap<Character,Integer> map1=new HashMap<>();
        HashMap<Character,Integer> map2=new HashMap<>();
        HashMap<Integer,Integer> c1=new HashMap<>();
        HashMap<Integer,Integer> c2=new HashMap<>();
        for(int i=0;i<word1.length();i++){
            map1.put(word1.charAt(i),map1.getOrDefault(word1.charAt(i),0)+1);
        }
        for(int i=0;i<word2.length();i++){
            if(!map1.containsKey(word2.charAt(i))){
                return false;
            }
            map2.put(word2.charAt(i),map2.getOrDefault(word2.charAt(i),0)+1);
        }
        for(Integer i:map1.values()){
               c1.put(i,c1.getOrDefault(i,0)+1);
        }
        for(Integer i:map2.values()){
               c2.put(i,c2.getOrDefault(i,0)+1);
        }
        for(Integer i:c2.keySet()){
               if(!c1.containsKey(i) ||  c2.get(i)!=c1.get(i)){
                   return false;

               }
        }
        return true;
        
    }
}

1. Take count of characters of both strings in two hashmaps.
2. Check if a character appears in both hashmap.If it doesnt return false.
3. Check the counts of characters and store it in hashmaps.
4. Check if the counts freq exits in other hashmap as well.If doesnt exist,return false.

Time complexity - o(m+n)
Space complexity - o(1)
  
