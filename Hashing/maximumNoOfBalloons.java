First approach(counting characters-brute force)

class Solution {
    public int maxNumberOfBalloons(String s) {
        int b=0,a=0,l=0,o=0,n=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='b'){
                b++;
            }
            else if(s.charAt(i)=='a'){
                a++;
            }
            else if(s.charAt(i)=='l'){
                l++;
            }
            else if(s.charAt(i)=='o'){
                o++;
            }
            else if(s.charAt(i)=='n'){
                n++;
            }
        }
        if(l>=2){
            l=l/2;
        }
        else{
            return 0;
        }
        if(o>=2){
            o=o/2;
        }
        else{
            return 0;
        }
        return Math.min(b,Math.min(a,Math.min(l,Math.min(o,n))));
        
    }
}

1. Check for count of the variables and return the least count.
  
Time complexity - o(n)
Space complexity - o(1)
  
Second approach(Hashing)
  
class Solution {
    public int maxNumberOfBalloons(String s) {
        HashMap<Character,Integer> map=new HashMap<>();
        map.put('a',0);
        map.put('b',0);
        map.put('l',0);
        map.put('o',0);
        map.put('n',0);
        for(int i=0;i<s.length();i++){
            map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)+1);
        }
        int ans=Integer.MAX_VALUE;
        for(Character i:map.keySet()){
            if(i=='b' || i=='a' || i=='l' || i=='o' || i=='n'){
                ans=Math.min(ans,i=='l'?map.get(i)/2:i=='o'?map.get(i)/2:map.get(i));
            }
        }
        return ans;
        
    }
}

1. Count characters in hashmap.Iterate through hashmap and find min 

Time complexity - o(n)
Space complexity - o(n)
  
Third approach(counter)
  
class Solution {
    public int maxNumberOfBalloons(String s) {
        int p[]=new int[26];
        int c[]=new int[26];
        String pattern="balloon";
        for(int i=0;i<pattern.length();i++){
            p[pattern.charAt(i)-'a']++;
        }
        for(int i=0;i<s.length();i++){
            c[s.charAt(i)-'a']++;
        }
        int ans=Integer.MAX_VALUE;
        for(int i=0;i<26;i++){
            if(p[i]>0){
                ans=Math.min(ans,c[i]/p[i]);
            }
        }
        return ans;
        
    }
}

1. Count characters in array and find min

Time complexity - o(n)
Space complexity - o(1)
