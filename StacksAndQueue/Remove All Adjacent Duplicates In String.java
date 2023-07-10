You are given a string s consisting of lowercase English letters.
A duplicate removal consists of choosing two adjacent and equal letters and removing them.

We repeatedly make duplicate removals on s until we no longer can.

Return the final string after all such duplicate removals have been made. It can be proven that the answer is unique.

Input: s = "abbaca"
Output: "ca"
Explanation: 
For example, in "abbaca" we could remove "bb" since the letters are adjacent and equal, and this is the only possible move.
The result of this move is that the string is "aaca", of which only "aa" is possible, so the final string is "ca".

First approach(Stacks)

class Solution {
    public String removeDuplicates(String s) {
        Stack<Character> stack=new Stack<>();
        for(int i=0;i<s.length();i++){
            char curVal=s.charAt(i);
            if(!stack.empty() && curVal==stack.peek()){
                stack.pop();
            }
            else{
                stack.add(s.charAt(i));
            }
        }
        String res="",out="";
        while(!stack.empty()){
            res=res+stack.pop();
        }
        for(int i=res.length()-1;i>=0;i--){
            out=out+res.charAt(i);
        }
        return out;
    }
}

1. Check if stack is empty and current value is not equal to top of the stack, add curr to top of stack.
2. Else remove the top of the element from the stack.
3. do it for all the elements in the array.
4. Finally pop all the elements in the stack and append it to a string and return the reverse of a string

Time complexity - o(N)
Space complexity - o(N)
