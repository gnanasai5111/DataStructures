Given a string s of lower and upper case English letters.

A good string is a string which doesn't have two adjacent characters s[i] and s[i + 1] where:

0 <= i <= s.length - 2
s[i] is a lower-case letter and s[i + 1] is the same letter but in upper-case or vice-versa.
To make the string good, you can choose two adjacent characters that make the string bad and remove them. You can keep doing this until the string becomes good.

Return the string after making it good. The answer is guaranteed to be unique under the given constraints.

Notice that an empty string is also good.

Input: s = "abBAcC"
Output: ""
Explanation: We have many possible scenarios, and all lead to the same answer. For example:
"abBAcC" --> "aAcC" --> "cC" --> ""
"abBAcC" --> "abBA" --> "aA" --> ""

First approach(Stack)

class Solution {
    public String makeGood(String s) {
        Stack<Character> stack=new Stack<>();
        stack.push(s.charAt(0));
        for(int i=1;i<s.length();i++){
            char c=s.charAt(i);
            if(!stack.empty() && Math.abs(stack.peek()-c)==32){
                stack.pop();
            }
            else{
                stack.add(c);
            }
        }
        String res="";
        while(!stack.empty()){
            res=res+stack.pop();
        }
        String out="";
        for(int i=res.length()-1;i>=0;i--){
            out=out+res.charAt(i);
        }
        return out;
        
    }
}

1. Traverse the array ,if stack is not empty or if adacent charcters are of same letter(curr char and top of stack) one is of lower case and other one is of
  upper case(i.e difference between them is 32) then pop the element from top of the stack.
2. Else add the elements to stack.
3 . Pop the elements from stack and append to string and return reverse of thr string.

Time complexity - o(N)
Space complexity - o(N)
