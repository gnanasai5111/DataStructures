// Reverse the array
First approach (Extra space)

class Solution {
    public void reverseString(char[] s) {
        char []rev=new char[s.length];
        int j=0;
        while(j<s.length){
            rev[j]=s[s.length-1-j];
            j++;
        }
        for(int i=0;i<s.length;i++){
            s[i]=rev[i];
        }
        
    }
}

1. Create an new array of length equal to the given array.
2. Copy the contents in reverse from the given array to the declared array.
3. Again Copy the contents from declared array to given array.
  
Time complexity - o(n)
Space complexity - o(n)

Second approach (Recursion,in-place and o(n) stack space)
    
class Solution {
    public void helper(int i,int j,char[] s){
        if(i>=j){
            return ;
        }
        char temp=s[i];
        s[i]=s[j];
        s[j]=temp;
        helper(i+1,j-1,s);
    }
    public void reverseString(char[] s) {
        int i=0;
        int j=s.length-1;
        helper(i,j,s);      
    }
}

1. we use two pointers and pass in a recursive function.
2. we swap the two indices and move the pointers close to each other 
3. when the first pointers reaches the second pointer then return 
    
Time complexity - o(n)
Space complexity - o(n) (Stack space)
  
Third approach (Two pointer and in-place)
  
class Solution {
    public void reverseString(char[] s) {
        int i=0;
        int j=s.length-1;
        while(i<j){
            char temp=s[i];
            s[i]=s[j];
            s[j]=temp;
            i++;
            j--;
        }
      
    }
}

1.Two pointer approach-first pointer starts at 0 index and second pointer starts at last index
2.Swap two pointers and move the pointers close to each other till they are equal.
  
Time complexity - o(n)
Space complexity - o(1)

