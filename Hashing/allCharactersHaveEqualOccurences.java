First approach(Brute force)
  
class Solution {
    public boolean areOccurrencesEqual(String s) {
        HashMap<Character,Integer> h=new HashMap<>();
        int prevFreq=0;
        for(int i=0;i<s.length();i++){
            int count=0;
            for(int j=0;j<s.length();j++){
                if(s.charAt(i)==s.charAt(j)){
                    count++;
                }
            }
            if(i==0){
                prevFreq=count;
            }
            if(count!=prevFreq){
                return false;
            }

        }

        return true;
        
    }
}

1. Loop through the array and count the occurences of each letter and check the frequencies of the each letter are same or not

Time complexity - o(n*n)
Space complexity - o(1)

Second approach(Counter)
  
class Solution {
    public boolean areOccurrencesEqual(String s) {
        int c[]=new int[26];
        for(int i=0;i<s.length();i++){
            c[s.charAt(i)-'a']++;
        }
        int freq=0;
        for(int i=0;i<26;i++){
            if(c[i]!=0){
                freq=c[i];
                break;
            }
        }
        for(int i=0;i<26;i++){
            if(c[i]!=0){
                if(c[i]!=freq){
                    return false;
                }
            }
        }
        return true;
        
    }
}

- Use a counter to store frequencies of all characters and check if the frequencies are same or not

Time complexity - o(n)
Space complexity - o(1)
  
Third approach(Hash map)
  
class Solution {
    public boolean areOccurrencesEqual(String s) {
        HashMap<Character,Integer> h=new HashMap<>();
        for(int i=0;i<s.length();i++){
            h.put(s.charAt(i),h.getOrDefault(s.charAt(i),0)+1);
        }
        int freq=h.get(s.charAt(0));
        for(Character i:h.keySet()){
            if(freq!=h.get(i)){
                return false;
            }
        }
        return true;
        
    }
}

- Use a hashmap to store frequencies of characters and check if frequencies are same or not.
  
 Time complexity - o(n)
 Space complexity - o(n)
