First Approach(Two pointer)

class Solution {
    public String reverseOnlyLetters(String s) {
        char c[]=s.toCharArray();
        String res="";
        int i=0;
        int j=c.length-1;
        while(i<j){
            if(!(c[i] >= 'a' && c[i] <= 'z') && !(c[i] >= 'A' && c[i] <= 'Z')){
              i++;

            }
            if(!(c[j]>='a' && c[j]<='z') && !(c[j]>='A' && c[j]<='Z')){
              j--;

            }
            if(((c[i]>='a' && c[i]<='z') || (c[i]>='A' && c[i]<='Z')) && 
            ((c[j]>='a' && c[j]<='z') || (c[j]>='A' && c[j]<='Z'))){
                char temp=c[i];
                c[i]=c[j];
                c[j]=temp;
                i++;
                j--;
            }
        }
        return new String(c);
        
    }
}

1. If the two values in indexes are characters than swap values in indexes
2. else increment the first pointer if its not character and decrement the second pointer if its not an character

Time complexity -o(n)
Space complexity - o(n)

Second approach(Stack)
  
class Solution {
    public String reverseOnlyLetters(String s) {
        Stack<Character> letters = new Stack();
        String res="";
        for(int i=0;i<s.length();i++){
            if(Character.isLetter(s.charAt(i))){
                letters.push(s.charAt(i));
            }
        }
        for(int i=0;i<s.length();i++){
            if(Character.isLetter(s.charAt(i))){
                res=res+letters.pop();
            }
            else{
                res=res+s.charAt(i);

            }
        }
        return res;
        
    }
}

1. Copy all the letters to stack.
2. Traverse the array and if value is alphabet then pop the value from stack and append to the result else append the value from array.
 

Time complexity - o(n)
Space compexity - o(n)
    
