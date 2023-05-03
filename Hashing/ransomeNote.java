First approach(Brute force)
  
class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        boolean flag[]=new boolean[magazine.length()];
        for(int i=0;i<ransomNote.length();i++){
            boolean f=false;
            for(int j=0;j<magazine.length();j++){
                if(ransomNote.charAt(i)==magazine.charAt(j) && !flag[j]){
                    f=true;
                    flag[j]=true;
                    break;
                }
            }
            if(f==false){
                return false;
            }
        }
        return true;
        
    }
}

1. Traverse the ransomnote array and check if it is contained in magazine .If it is not ,return false.
2. Repeat this process for all the elements in ransomnote array.
  
Time complexity - o(n*m)
Space complexity - o(m)
  
Second approach(Hashing)
  
class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
       HashMap<Character,Integer> map=new HashMap<>();
        for(int j=0;j<magazine.length();j++){
               map.put(magazine.charAt(j),map.getOrDefault(magazine.charAt(j),0)+1);
        }
        for(int i=0;i<ransomNote.length();i++){
           if(map.getOrDefault(ransomNote.charAt(i),0)>0){
               map.put(ransomNote.charAt(i),map.get(ransomNote.charAt(i))-1);
           }
            else{
                return false;
            }
        }
        return true;
        
    }
}

1. Store all the frequnecies of letters of magazine in hashmap and check if we can create a ransomenote using that frequencies.
  
Time complexity - o(n+m)
Space complexity - o(1)- 26 charcetrs max in hashmap

Third approach(Sorting and stack)
  
class Solution {
    private Stack<Character> sortedCharacterStack(String s) {
        char[] charArray = s.toCharArray();
        Arrays.sort(charArray);
        Stack<Character> stack = new Stack<>();
        for (int i = s.length() - 1; i >= 0; i--) {
            stack.push(charArray[i]);
        }
        return stack;
    }
    
    
    public boolean canConstruct(String ransomNote, String magazine) {

        if (ransomNote.length() > magazine.length()) {
            return false;
        }
        
        Stack<Character> magazineStack = sortedCharacterStack(magazine);
        Stack<Character> ransomNoteStack = sortedCharacterStack(ransomNote);
        
        while (!magazineStack.isEmpty() && !ransomNoteStack.isEmpty()) {
            if (magazineStack.peek().equals(ransomNoteStack.peek())) {
                ransomNoteStack.pop();
                magazineStack.pop();
            } 
            else if (magazineStack.peek() < ransomNoteStack.peek()) {
                magazineStack.pop();
            }
            else {
                return false;
            }
        }
                
        return ransomNoteStack.isEmpty();
        
    }
}

1. Convert the strings to char array and reverse it and store in stack.
2. check the top element from both stack , if they are equal ,pop if magazinestack top element is less than ransomnotestack top element then pop magazine stack element
else return false.
3. And check if ransomenote stack is empty or not,if empty return true else return false.
  
Time complexity - o(mlogm)
Space complexity - o(m)
