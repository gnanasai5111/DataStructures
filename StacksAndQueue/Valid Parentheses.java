Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:

Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.
Every close bracket has a corresponding open bracket of the same type.

Input: s = "()[]{}"
Output: true

First approach(Stack)

class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack=new Stack<>();
        for(int i=0;i<s.length();i++){
            char v=s.charAt(i);
            if(v=='(' || v=='{' || v=='['){
                stack.add(v);
            }
            else{
                if(stack.empty()){
                    return false;
                }
                char topVal=stack.pop();
                if(v=='}'){
                    if(topVal!='{'){
                        return false;
                    }
                }
                else if(v==')'){
                    if(topVal!='('){
                        return false;
                    }
                }
                else{
                    if(topVal!='['){
                        return false;
                    }

                }
            }
            
        }
        return stack.empty();
    }
}

1. Add all the open brackets to stack.
2. When you encounter any close bracket,check if stack is empty ,if empty return false because there is no open brackets before it.
3. If not empty then check the current close bracket with the matching open bracket,if they are different return false.
4. Repeat this for all the elements in the string.
5. Finally check if stack is empty or not.If empty return true else false.

Time complexity - o(N)
Space complexity - o(N)

Second approach(Stack and hashing)

class Solution {
    public boolean isValid(String s) {
        HashMap<Character,Character> map=new HashMap<>();
        map.put('(', ')');
        map.put('[', ']');
        map.put('{', '}');
        Stack<Character> stack=new Stack<>();
        for(int i=0;i<s.length();i++){
            char v=s.charAt(i);
            if(map.containsKey(v)){
                stack.add(v);
            }
            else{
                if(stack.empty()){
                    return false;
                }
                if(map.get(stack.pop())!=v){
                    return false;
                }
            }
            
        }
        return stack.empty();
    }
}

1. Similar approach like first one,the only difference is we use hashmap for mapping brackets,so its easier for access.

Time complexity - o(N)
Space complexity - o(N)
