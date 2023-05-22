First approach(Brute force)
  
class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length()==0){
            return 0;
        }
        int max=1,start=0,end=0;
        for(int i=1;i<s.length();i++){
            boolean flag=false;
            for(int j=i-1;j>=start;j--){
                if(s.charAt(j)==s.charAt(i)){
                    flag=true;
                    start=j+1;
                    break;
                }   
                else{
                    end=i;
                }  
            }
            if(!flag){
                max=Math.max(max,end-start+1);
            }
        }
        return max;
        
    }
}

1. Initially put start index as 0.Traverse the array from first character to the start.
2. If there are no repeated values find the length of it.If there are repeated values put start as j+1.
3. Repeat this process for all elements.
  
Time complexity - o(N*N)
Space complexity - o(1)
  
Second approach(Hashing and sliding window)
  
class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length()==0){
            return 0;
        }
        int max=0,start=0;
        HashSet<Character> set=new HashSet<>();
        for(int i=0;i<s.length();i++){
            if(set.contains(s.charAt(i))){
                while(set.contains(s.charAt(i))){
                    set.remove(s.charAt(start));
                    start++;
                }
            }
            set.add(s.charAt(i));
            max=Math.max(max,set.size());
        }
        return max;
        
    }
}

1. Add elements to hashset.If the element already contains,remove the value at left pointer and increment it till the set doesnt contain the value.
2. Repeat this process by traversing till end of the array.
  
Time complexity - o(N)
Space complexity - o(1)- o(256)
  
Third approach(Hashing and sliding window)
  
class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length()==0){
            return 0;
        }
        int max=0,start=0;
        HashMap<Character,Integer> map=new HashMap<>();
        for(int i=0;i<s.length();i++){
            map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)+1);
            while(map.get(s.charAt(i))>1){
              map.put(s.charAt(start),map.get(s.charAt(start))-1);
               start++;
            }       
            max=Math.max(max,i-start+1);
        }
        return max;
        
    }
}

1. Add element freq to hashmap.If the element freq is greater than 1  the decrement the freq at left pointer and increment it till the current element freq is equal to 1.
2. Repeat this process by traversing till end of the array.
  
Time complexity - o(N)
Space complexity - o(1) - o(256)

Fourth approach(Hashing and sliding window optimised)
  
class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length()==0){
            return 0;
        }
        int max=0,start=0;
        HashMap<Character,Integer> map=new HashMap<>();
        for(int i=0;i<s.length();i++){
            if(map.containsKey(s.charAt(i))){
                start=Math.max(start,map.get(s.charAt(i)));
            }
            map.put(s.charAt(i),i+1);       
            max=Math.max(max,i-start+1);
        }
        return max;
        
    }
}


1. Store the index of element to hashmap.If the element already contains get the max start index and find the length.
2. Repeat this process by traversing till end of the array.
  
Time complexity - o(N)
Space complexity - o(1) - o(256)
