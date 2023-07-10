Given a string path, which is an absolute path (starting with a slash '/') to a file or directory in a Unix-style file system, 
convert it to the simplified canonical path.

In a Unix-style file system, a period '.' refers to the current directory,
a double period '..' refers to the directory up a level,
and any multiple consecutive slashes (i.e. '//') are treated as a single slash '/'.
For this problem, any other format of periods such as '...' are treated as file/directory names.

The canonical path should have the following format:

The path starts with a single slash '/'.
Any two directories are separated by a single slash '/'.
The path does not end with a trailing '/'.
The path only contains the directories on the path from the root directory to the target file or directory (i.e., no period '.' or double period '..')
Return the simplified canonical path.

Input: path = "/home//foo/"
Output: "/home/foo"
Explanation: In the canonical path, multiple consecutive slashes are replaced by a single one.

First approach(Stack)

class Solution {
    public String simplifyPath(String path) {
      String res="/";
      String name="";
      Stack<String> s=new Stack<>();
      Stack<String> newSt=new Stack<>();

      for(int i=0;i<path.length();i++){
        if(path.charAt(i)=='/'){
          if(name.length()!=0){     
            s.push(name);
            name="";
          }
        }
        else if(i==path.length()-1 && path.charAt(i)!='/'){
          s.push(name+path.charAt(i));
        }
        else{
          name=name+path.charAt(i);
        }
      }
      while(!s.empty()){
        newSt.push(s.pop());
      }
      while(!newSt.empty()){
        String val=newSt.pop();
        if(val.equals(".") || val.isEmpty()){
          continue;
        }
        else if(val.equals("..")){
          if(!s.empty()){
            s.pop();
          }
        }
        else{
          s.push(val);
        }
      }
      while(!s.empty()){
        newSt.push(s.pop());
      }
      while(!newSt.empty()){
        res=res+newSt.pop();
        if(!newSt.empty()){
          res=res+"/";
        }
      }         
      return res;
    }
}

1. Split the string based on "/" and add it to the stack.
2. Reverse the stack(to new stack)
3. Pop the elements from the stack,if the popped elements are of "." or "" continue else if element is ".." 
  and new stack is not empty then pop the element from stack else add the element to new stack.
4. reverse the stack(to new stack)
5. Pop the elements from stack and append to a string and return.


Time complexity - o(N)
Space complexity - o(N)
