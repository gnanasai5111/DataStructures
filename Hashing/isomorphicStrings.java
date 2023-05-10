First approach(Hashing)

class Solution {
    public boolean isIsomorphic(String s, String t) {
        HashMap<Character,Character> map=new HashMap<>();
        HashMap<Character,Character> map2=new HashMap<>();
        for(int i=0;i<s.length();i++){
            map.put(s.charAt(i),t.charAt(i));
            map2.put(t.charAt(i),s.charAt(i));
        }
        for(int i=0;i<s.length();i++){
           if(map.get(s.charAt(i))!=t.charAt(i) || map2.get(t.charAt(i))!=s.charAt(i)){
               return false;
           }
        }
        return true;
    }
}

1. Traverse both the strings and map it to the characters that are present at the same index in both strings.
2. Check if the mapped character is equal to the value at current index for both the strings

Time complexity - o(N)
Space complexity - o(N)
  
Second approach(Mapping)

class Solution {
    public boolean isIsomorphic(String s, String t) {
       char a[]=new char[256];
       char b[]=new char[256];
        HashMap<Character,Character> map2=new HashMap<>();
        for(int i=0;i<s.length();i++){
            a[s.charAt(i)]=t.charAt(i);
            b[t.charAt(i)]=s.charAt(i);
        }
        for(int i=0;i<s.length();i++){
           if(a[s.charAt(i)]!=t.charAt(i) || b[t.charAt(i)]!=s.charAt(i)){
               return false;
           }
        }
        return true;
    }
}

1. Similar to first approach,Instead of using hashmap we use array of 256 size and map characters at indexes and compare

Time complexity - o(N)
Space complexity - o(256)- o(1)
  
Third approach(First ocuurence transformation- mapping with index)
  
class Solution {
    public boolean isIsomorphic(String s, String t) {
        HashMap<Character,Integer> map1=new HashMap<>();
        HashMap<Character,Integer> map2=new HashMap<>();
        String res1="";
        String res2="";
        for(int i=0;i<s.length();i++){
           if(!map1.containsKey(s.charAt(i))){
              map1.put(s.charAt(i),i); 
           }
           res1=res1+map1.get(s.charAt(i))+" ";
           if(!map2.containsKey(t.charAt(i))){
              map2.put(t.charAt(i),i); 
           }
           res2=res2+map2.get(t.charAt(i))+" ";
        }
        for(int i=0;i<res1.length();i++){
            if(res1.charAt(i)!=res2.charAt(i)){
                return false;
            }
        }
        return true;
    }
}

1. Map the characters with index of first occured .Do it for both the strings ,sometimes strings can be equal even though if they are not isomorphic so append 
   extra space to string
   
Time complexity - o(N)
Space complexity - o(N)
