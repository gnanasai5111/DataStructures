Given a string s, reverse the order of characters in each word within a sentence while still preserving whitespace and initial word order.
  
First approach(Traverse and reverse characters by space)
  
class Solution {
    public String reverseWords(String s) {
        int start=0,index=0;
        String res="";
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)==' ' || i==s.length()-1){
                if(i==s.length()-1){
                    index=i;
                }
                else{
                    index=i-1;
                }
                while(index>=start){
                  res=res+s.charAt(index);
                  index--;
                }
                start=i+1;
                if(i!=s.length()-1)
                {
                res=res+" ";
                }
            }
           
        }
        return res;
        
    }
}

1. Traverse the array when you encounter a space or end of the array,copy the letters.

Time complexity -o(n)
Space complexity -o(1)
  
Second approach(Two pointer)
  
class Solution {
    public String reverseWords(String st) {
        int start=0,index=0;
        int end=0;
        String res="";
        char s[]=st.toCharArray();
        for(int i=0;i<s.length;i++){
            if(s[i]==' ' || i==s.length-1){
                 if(i==s.length-1){
                    end=i;
                }
                else{
                   end=i-1;
                }
                while(start<=end){
                    char swap=s[start];
                    s[start]=s[end];
                    s[end]=swap;
                    start++;
                    end--;
                } 
                    start=i+1;
            
            }

            
           
        }
        return new String(s);
        
    }
}

1. Traverse the array, use two pointer and swap the variables in the indexes till you reach a space .Repeat this process


Time complexity - o(N)
Space complexity - o(1)
