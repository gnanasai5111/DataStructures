First approach(Brute force)

class Solution {
    public boolean checkIfPangram(String sentence) {
        for(int i=0;i<26;i++){
           char c=(char)('a'+i);
           boolean flag=false;
           for(int j=0;j<sentence.length();j++){
               if(c==sentence.charAt(j)){
                   flag=true;
               }
           }
           if(!flag){
               return false;
           }
        }
       return true;
        
    }
}

1. For each letter in alphabets, loop through the sentence if it doesnt exists return false else return true;

Time complexity - o(n)
Space complexity -o(1)
  
Second approach(counter)
  
class Solution {
    public boolean checkIfPangram(String sentence) {
        int a[]=new int[26];
        for(int i=0;i<sentence.length();i++){
           a[sentence.charAt(i)-'a']++;
        }
        for(int i=0;i<a.length;i++){
           if(a[i]==0){
               return false;
           }
        }

       return true;
        
    }
}

1. Add charceter count to counter array.If the count is 0 of any alphabet return false else return true;

Time complexity - o(n)
Space complexity -o(1)

Third approach(Set)
  
class Solution {
    public boolean checkIfPangram(String sentence) {
        HashSet<Character> set=new HashSet<>();
        for(int i=0;i<sentence.length();i++){
            set.add(sentence.charAt(i));
        }
       return set.size()==26?true:false;
        
    }
}

1. Add all the letters to hashset and check if size==26 return true else return false;

Time complexity - o(n)
Space complexity -o(1)(There are atmost 26 letters ,so it is constant time )
