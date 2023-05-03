First approach(Brute force)
  
class Solution {
    public int numJewelsInStones(String jewels, String stones) {
        int count=0;
        for(int i=0;i<stones.length();i++){
            for(int j=0;j<jewels.length();j++){
                if(stones.charAt(i)==jewels.charAt(j)){
                    count++;
                    break;
                }
            }
        }
        return count;
        
    }
}

-Traverse the stones and check if it is contained in jewels or not.Increment the count if it contains in jewels.Repeat the process

Time complexity - o(m*n)
Space complexity - o(1)
  
Second approach(Hashing)
  
class Solution {
    public int numJewelsInStones(String jewels, String stones) {
        int count=0;
        HashSet<Character> set=new HashSet<>();
        for(int j=0;j<jewels.length();j++){
                set.add(jewels.charAt(j));
        }
        for(int i=0;i<stones.length();i++){
                if(set.contains(stones.charAt(i))){
                    count++;  
                }
        }
        return count;
        
    }
}

1. Store all the jewels in hashmap.
2. Increment the count if stone is in jewels.

Time complexity - o(m*n)
Space complexity - o(m)
