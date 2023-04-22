Longest Substring with At Most K Distinct Characters

First approach(Brute force)
  
class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        int max=0;
        for(int i=0;i<s.length();i++){
             HashSet<Character> set=new HashSet<>();
             for(int j=i;j<s.length();j++){
                 set.add(s.charAt(j));
                 if(set.size()<=k){
                     max=Math.max(max,j-i+1);
                  
                 }
                 else{
                     break;
                 }
             }

        }
        return max;      
    }
}
1. Add the element count to hashset,if the hashmap size exceeds k then break the loop else find the max length

Time complexity - o(n*n)
Space complexity - o(k)

Second approach(Counter )
  
  

Second approach(Hashmap and sliding window)
 
class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        HashMap<Character,Integer> h=new HashMap<>();
        int left=0,max=0;
        for(int right=0;right<s.length();right++){
                h.put(s.charAt(right),h.getOrDefault(s.charAt(right),0)+1);
                if(h.size()<=k){
                max=Math.max(max,right-left+1);
                }
            while(h.size()>k){
                h.put(s.charAt(left),h.get(s.charAt(left))-1);
                if(h.get(s.charAt(left))==0){
                    h.remove(s.charAt(left));
                }
                left++;

            }

        }
        return max;
        
    }
}

1. Add the element count to hashamap,if the hashmap size exceeds k then decrement the element at left index in hashmap 
   and if the count of that element is zero,remove the element till size of the hashmap is less than or equal to k.
2. Find the max in each iteration.

Time complexity - o(n)
Space complexity - o(k) 
