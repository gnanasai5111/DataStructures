Given a 0-indexed string word and a character ch, reverse the segment of word that starts at index 0 and ends at the index of the first occurrence of ch (inclusive).
If the character ch does not exist in word, do nothing.

First approach(two pointer)
  
class Solution {
    public String reversePrefix(String word, char ch) {
        char c[]=word.toCharArray();
        int start=0;
        int end=0;
        for(int i=0;i<word.length();i++){
            if(word.charAt(i)==ch){
                end=i;
                break;
            }
        }
        while(start<end){
            char temp=c[start];
            c[start]=c[end];
            c[end]=temp;
            start++;
            end--;

        }
        return new String(c);
        
    }
}

1. Get the index of the character found.And reverse the array from the found index to start index.
  
Time complexity - o(n)
Space complexity - o(n)
  
Second approach(in place)
  
class Solution {
    public String reversePrefix(String word, char ch) {
        int index=0;
        for(int i=0;i<word.length();i++){
            if(word.charAt(i)==ch){
                index=i;
                break;
            }
        }
        int i=index;
        String res="";
        while(i>=0){
            res=res+word.charAt(i);
            i--;
        }
        int x=index+1;
        while(x<word.length()){
            res=res+word.charAt(x);
            x++;
        }
        return res;
        
    }
}

1. Get the index of character ,copy the elements in reverse before index and in order after index

Time complexity - o(n)
Space complexity - o(1)
