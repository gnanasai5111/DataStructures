First approach(two pointer with extra space)
  
  class Solution {
    public  boolean isLetterOrDigit(char c) {
    return (c >= 'a' && c <= 'z') ||
           (c >= 'A' && c <= 'Z') ||
           (c >= '0' && c <= '9');
    } 
    public boolean isPalindrome(String s) {
        String res="";
        for(int i=0;i<s.length();i++){
            if(isLetterOrDigit(s.charAt(i))){
                res=res+s.charAt(i);
            }
        }
        int i=0;
        int j=res.length()-1;
         while(i<j){
            if(Character.toLowerCase(res.charAt(i))==Character.toLowerCase(res.charAt(j))){
                i++;
                j--;
            }
            else{
                return false;
            }
        }
        return true;
    }
}

1.Remove all non alphanumeric characters and append it to a string.
2. Check if two charcetrs at each pointer is same ,if not return false.

Time complexity - o(n)
Space complexity - o(n)


Second approach(two pointer)
  
  class Solution {
    public  boolean isLetterOrDigit(char c) {
    return (c >= 'a' && c <= 'z') ||
           (c >= 'A' && c <= 'Z') ||
           (c >= '0' && c <= '9');
    } 
    public boolean isPalindrome(String s) {
        
        int i=0;
        int j=s.length()-1;
        while(i<j){
            if(!isLetterOrDigit(s.charAt(i))){
                i++;
            }
            else if(!isLetterOrDigit(s.charAt(j))){
                j--;
            }
            else{
            if(Character.toLowerCase(s.charAt(i))==Character.toLowerCase(s.charAt(j))){
                i++;
                j--;
            }
            else{
                return false;
            }
            }
        }
        return true;
    }
}

1. At each pointer check if its either an letter or digit ,if it is check if they are equal else return false.
2.If they are not either letter or digit move the pointers and repeat the process

Time complexity - o(n)
Space complexity - o(1)
