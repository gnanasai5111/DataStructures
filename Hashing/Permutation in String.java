First approach(Brute force)
    
public class Solution {
    boolean flag = false;
    
    public boolean checkInclusion(String s1, String s2) {
        permute(s1, s2, 0);
        return flag;
    }
    
    public String swap(String s, int i0, int i1) {
        if (i0 == i1)
            return s;
        String s1 = s.substring(0, i0);
        String s2 = s.substring(i0 + 1, i1);
        String s3 = s.substring(i1 + 1);
        return s1 + s.charAt(i1) + s2 + s.charAt(i0) + s3;
    }
    
    void permute(String s1, String s2, int l) {
        if (l == s1.length()) {
            if (s2.indexOf(s1) >= 0)
                flag = true;
        } else {
            for (int i = l; i < s1.length(); i++) {
                s1 = swap(s1, l, i);
                permute(s1, s2, l + 1);
                s1 = swap(s1, l, i);
            }
        }
    }
}

1.  Generate all susbstrings and and check if generated substring is part of longer substring.

Time complexity - o(n!)
Space complexity - o(n*n)

Second approach(Sorting)

class Solution {
    public String sort(String s){
          char c[]=s.toCharArray();
          Arrays.sort(c);
          return new String(c);
    }
    public boolean checkInclusion(String s1, String s2) {
        s1=sort(s1);
        for(int i=0;i<=s2.length()-s1.length();i++){
            if(s1.equals(sort(s2.substring(i,i+s1.length())))){
                return true;
            }
        }
        return false;     
    }
}

1. Sort the first string. And compare the first string with sorted sub string in second string.
2. Check for all the indexes with sorted substring of length of first string.
3. If any substring in second string is equal to first string return true.

Time complexity - o(nlogn+(m-n)nlogn)
Space complexity - o(n)
  
Third approach(HashMap)
  
class Solution {
    public boolean matches(HashMap<Character,Integer> m1,HashMap<Character,Integer> m2){
          for(Character i:m1.keySet()){
              if(m1.get(i)-m2.getOrDefault(i,-1)!=0){
                  return false;
              }
          }
          return true;
    }
    public boolean checkInclusion(String s1, String s2) {
         if (s1.length() > s2.length())
            return false;
        HashMap<Character,Integer> map1=new HashMap<>();
        for(int i=0;i<s1.length();i++){
            map1.put(s1.charAt(i), map1.getOrDefault(s1.charAt(i), 0) + 1);
        }
         for(int i=0;i<=s2.length()-s1.length();i++){
             HashMap<Character,Integer> map2=new HashMap<>();
             for(int j=i;j<i+s1.length();j++){
                  map2.put(s2.charAt(j), map2.getOrDefault(s2.charAt(j), 0) + 1);
             }
             if(matches(map1,map2)){
                 return true;
             }
           
        }
        return false;     
    }
}

1. Add the freq of chars in first string.
2. Traverse the second string and check the freq of second substring equal to freq of first string
3. If any substring in second string is equal to first string return true.

Time complexity - o(n+26(m-n)n)
Space complexity - o(1)
  
Fourth approach(Counter)
  
class Solution {
    public boolean matches(int m1[],int m2[]){
          for(int i=0;i<26;i++){
              if(m1[i]!=m2[i]){
                  return false;
              }
          }
          return true;
    }
    public boolean checkInclusion(String s1, String s2) {
         if (s1.length() > s2.length())
            return false;
        int map1[]=new int[26];
        for(int i=0;i<s1.length();i++){
            map1[s1.charAt(i)-'a']++;
        }
         for(int i=0;i<=s2.length()-s1.length();i++){
            int map2[]=new int[26];
             for(int j=i;j<i+s1.length();j++){
                  map2[s2.charAt(j)-'a']++;
             }
             if(matches(map1,map2)){
                 return true;
             }
           
        }
        return false;     
    }
}

1. Same as using hashmap.But we use counter.

Time complexity - o(n+26(m-n)n)
Space complexity - o(1)
  
  
Fifth approach(Sliding window and hashmap)
  
class Solution {
    public boolean matches(int m1[],int m2[]){
          for(int i=0;i<26;i++){
              if(m1[i]!=m2[i]){
                  return false;
              }
          }
          return true;
    }
    public boolean checkInclusion(String s1, String s2) {
         if (s1.length() > s2.length())
            return false;
        int map1[]=new int[26];
         int map2[]=new int[26];
        for(int i=0;i<s1.length();i++){
            map1[s1.charAt(i)-'a']++;
            map2[s2.charAt(i)-'a']++;
        }
         for(int i=0;i<s2.length()-s1.length();i++){
             if(matches(map1,map2)){
                 return true;
             }
             map2[s2.charAt(i+s1.length())-'a']++;
             map2[s2.charAt(i)-'a']--;
           
        }
        return matches(map1,map2);     
    }
}

1. Instead of using hashmap for every window.We calculate freq initially and move the window and subtract the character and check if freq are equal or not.
  
Time complexity - o(n+26(m-n))
Space complexity - o(1)
  
Sixth approach(Optimised sliding window)
  
class Solution {
    public boolean checkInclusion(String s1, String s2) {
         if (s1.length() > s2.length())
            return false;
        int map1[]=new int[26];
         int map2[]=new int[26];
        for(int i=0;i<s1.length();i++){
            map1[s1.charAt(i)-'a']++;
            map2[s2.charAt(i)-'a']++;
        }
        int count=0;
        for(int i=0;i<26;i++){
              if(map1[i]==map2[i]){
                  count++;
              }
          }
         for(int i=0;i<s2.length()-s1.length();i++){
             int r=s2.charAt(i+s1.length())-'a';
             int l=s2.charAt(i)-'a';
             if(count==26){
                 return true;
             }
             map2[r]++;
             if(map2[r]==map1[r]){
                 count++;
             }
             else if(map2[r]==map1[r]+1){
                 count--;
             }
             map2[l]--;
             if(map2[l]==map1[l]){
                 count++;
             }
             else if(map2[l]==map1[l]-1){
                 count--;
             }
           
        }
        return count==26;     
    }
}

1. We calculate freq of letters of both strings till first string length.Check for count of similar elements .
2. If count is equal to 26 return true else move the window and if values at right and left index are equal increment count else decrement count.
  
Time complexity - o(n+(m-n))
Space complexity - o(1)

