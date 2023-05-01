First approach(Categorize by sorted string)
  
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,Integer> map=new HashMap<>();
        List<List<String>> a =new ArrayList<>();
        int j=0;
        for(int i=0;i<strs.length;i++){
           char ch[]=strs[i].toCharArray();
           Arrays.sort(ch);
           String temp=new String(ch);
            if(map.containsKey(temp)){
               a.get(map.get(temp)).add(strs[i]);
           }else{
               ArrayList<String> s=new ArrayList<>();
               s.add(strs[i]);
               a.add(s);
                map.put(temp,j);
                j++;
           }
           
        }
       
       return a;
        
    }
}

1. sort the string and add it to hashmap and find same and distinct elements and add to nested list

Time complexity - o(nklogk) - k is the max length of string
Space complexity - o(nk)
  
Second approach(categorize by count)
  
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,Integer> map=new HashMap<>();
        List<List<String>> a =new ArrayList<>();
        int j=0;
        for(int i=0;i<strs.length;i++){
           char ch[]=strs[i].toCharArray();
           int c[]=new int[26];
           for(int y=0;y<ch.length;y++){
               c[ch[y]-'a']++;
           }
           String temp="";
           for(int k=0;k<26;k++){
               while(c[k]>0){
               temp=temp+(char)(k+'a');
               c[k]--;
               }
           }
            if(map.containsKey(temp)){
               a.get(map.get(temp)).add(strs[i]);
           }else{
               ArrayList<String> s=new ArrayList<>();
               s.add(strs[i]);
               a.add(s);
                map.put(temp,j);
                j++;
           }
           
        }
       
       return a;
        
    }
}

1. count the letters in string and create a new string from count and add it to hashmap and find same and distinct elements and add to nested list

Time complexity - o(nk) 
Space complexity - o(nk)

