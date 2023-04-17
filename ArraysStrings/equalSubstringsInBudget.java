First approach(Brute force)
  
class Solution {
    public int equalSubstring(String s, String t, int maxCost) {
        int max=0;       
        for(int i=0;i<s.length();i++){
            int diff=0;
            int index=0;
            for(int j=i;j<s.length();j++){
                diff+=Math.abs(s.charAt(j)-t.charAt(j));
                if(diff<=maxCost){
                    index=j-i+1;
                }
                else{
                    break;
                }
            }
            if(index>max){
                max=index;
            }
        }
        return max;
    }
}

1. Traverse the array ,and find the difference betwwen two charcters at each indexes .
2. If the difference of the sum is less than the maxcost then find the length and repeat the process my moving the pointer .

Time complexity - o(n*n)
Space complexity - o(1)
  
Second approach(Sliding window)
  
class Solution {
    public int equalSubstring(String s, String t, int maxCost) {
        int max=0,diff=0,index=0;  
        int left=0;     
        for(int i=0;i<s.length();i++){
            diff+=Math.abs(s.charAt(i)-t.charAt(i));
            if(diff<=maxCost){
                index=i-left+1;
                if(index>max){
                    max=index;
                }
            }
            else{
                diff=diff-Math.abs(s.charAt(left)-t.charAt(left));
                left++;
            }
        }
        return max;
    }
}

1. Traverse the array till you find the sum of diff of charcters greater than maxCost 
2. move the pointer and calculate the maxLength when sum is less than maxcost

Time complexity - o(n)
Space complexity - o(1)
