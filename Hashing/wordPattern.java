First approach(Hashing)
  
class Solution {
    public boolean check(String a,String b){
        return a.equals(b);
    }
    public boolean wordPattern(String pattern, String s) {
        ArrayList<String> p2=new ArrayList<>();
        String word="";
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)==' '){
                p2.add(word);
                word="";
            }
            else{
               word=word+s.charAt(i);
            }
        }
        p2.add(word);
        if(p2.size()!=pattern.length()){
            return false;
        }  
        HashMap<Character,String> map=new HashMap<>();
        for(int i=0;i<pattern.length();i++){
            if(map.containsKey(pattern.charAt(i))){
                if(!check(map.get(pattern.charAt(i)),p2.get(i))){
                    return false;
                }           
            }
            else{ 
                if(map.containsValue(p2.get(i))){
                    return false;
                }
                 map.put(pattern.charAt(i),p2.get(i));
            }  
           
        }
        return true;
        
    }
}

1. Convert the s string into an array of strings whenver a space encounters.
2. Use hasmap to map the character to word and check if the value at current index equal to value at map and check if the value exists in map earlier.
  
Time complexity - o(N)
Space complexity - o(N)
  
Second approach(Single index hashmap)
  
class Solution {
    public boolean wordPattern(String pattern, String s) {
         String[] p2 = s.split(" ");
        if(p2.length!=pattern.length()){
            return false;
        }  
        HashMap map=new HashMap();
        for(Integer i=0;i<p2.length;i++){
            char res=pattern.charAt(i);
            String w=p2[i];     
            if(!map.containsKey(res))
                map.put(res,i);         
            if(!map.containsKey(w))
                map.put(w,i);          
            if(map.get(res)!=map.get(w)){
                return false;
            }
           
        }
        return true;
        
    }
}

1. Convert the s string into an array of strings whenver a space encounters.
2. Use hasmap to map the character and words to indexes at each index and check if the valued are equal or not.
  
Time complexity - o(N)
Space complexity - o(N)

Third approach(HASHING)
  
class Solution {
    public boolean wordPattern(String pattern, String s) {
         String[] p2 = s.split(" ");
        if(p2.length!=pattern.length()){
            return false;
        }  
        HashMap <Character, String> map_char = new HashMap();
        HashMap <String, Character> map_word = new HashMap();
        for(Integer i=0;i<p2.length;i++){
            char res=pattern.charAt(i);
            String w=p2[i];     
            map_char.put(res,w);         
            map_word.put(w,res);               
        }
         for(int i=0;i<p2.length;i++){
            char res=pattern.charAt(i);
            String w=p2[i];  
            if(!map_char.get(res).equals(w) || !map_word.get(w).equals(res)){
               return false;
           }
        }
        return true;
        
    }
}

1. Convert the s string into an array of strings whenver a space encounters.
2. Use hasmaps to map the character to word and word to characater and check if the value at current index equal to value at both maps .
