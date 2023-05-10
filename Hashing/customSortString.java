First approach(Hashing)
  
class Solution {
    public String customSortString(String order, String s) {
        HashMap<Character,Integer> map=new HashMap<>();
        for(int i=0;i<s.length();i++){
            map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)+1);
        }
        String res="";
        for(int i=0;i<order.length();i++){
            char c=order.charAt(i);
            while(map.getOrDefault(c,0)>=1){
                res=res+c;
                map.put(c,map.get(c)-1);
            }     
        }
        for(Character i:map.keySet()){
            int val=map.get(i);
            while(val>0){
                res=res+i;
                val--;
            }
        }

        return res;
        
    }
}

1. Store the frequencies of letters of string s in a map.
2. Traverse the order array and check the frequencies of letters in map and append to res .
3. Finally traverse through the map and append the rest of letters.
  
Time complexity - o(N)
Space complexity - o(N)
  
Second approach(Counter)
  
class Solution {
    public String customSortString(String order, String s) {
         int[] count = new int[26];
        for(int i=0;i<s.length();i++){
            count[s.charAt(i)-'a']++;
        }
        String res="";
        for(int i=0;i<order.length();i++){
            char c=order.charAt(i);
            while(count[c-'a']>=1){
                res=res+c;
                count[c-'a']--;
            }     
        }
        for(int i=0;i<26;i++){
            int val=count[i];
            while(val>0){
                char c=(char)(i+97);
                res=res+c;
                val--;
            }
        }

        return res;
        
    }
}

1. Store the frequencies of letters of string s in a counter
2. Traverse the order array and check the frequencies of letters in counter and append to res .
3. Finally traverse through the counter and append the rest of letters.
  
Time complexity - o(N)
Space complexity - o(N)
