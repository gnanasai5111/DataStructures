First approach(Brute force)
  
class Solution {
    public boolean isVowel(char a){
        if(a=='a' || a=='e' || a=='i' || a=='o' || a=='u'){
            return true;
        }
        return false;
    }
    public int maxVowels(String s, int k) {
        int max=0;
        for(int i=0;i<s.length();i++){
            int x=0,count=0;
            for(int j=i;j<s.length();j++){
                if(isVowel(s.charAt(j))){
                    count++;
                }
                x++;
                if(x==k){
                    if(count>max){
                        max=count;
                    }
                    count=0;
                }
            }
            
        }
        return max;     
    }
}

1. Traverse the sub arrays of length k and find max vowels

Time complexity -o(n*n)
Space complexity - o(1)
  
Second approach(Sliding window)
  
class Solution {
    public boolean isVowel(char a){
        if(a=='a' || a=='e' || a=='i' || a=='o' || a=='u'){
            return true;
        }
        return false;
    }
    public int maxVowels(String s, int k) {
        int max=0;
        int left=0;
        int count=0;
        int right=0;
        for(int i=0;i<s.length();i++){
            if(isVowel(s.charAt(i))){
                    count++;
            }
            right++;
            if(right==k){
                if(count>max){
                    max=count;
                }
                if(isVowel(s.charAt(left))){
                    left++;
                    count--;
                }
                else{
                    left++;
                }
                right--;

            }   
        }
        return max;     
    }
}

1. Traverse the array till k length and find no of vowels
2. Move the left pointer and repeat this process till the end 

Time complexity - o(n)
Space complexity - o(1)

Third approach(Another sliding window)
  
class Solution {
    public boolean isVowel(char a){
        if(a=='a' || a=='e' || a=='i' || a=='o' || a=='u'){
            return true;
        }
        return false;
    }
    public int maxVowels(String s, int k) {
        int count=0;
        for(int i=0;i<k;i++){
            if(isVowel(s.charAt(i))){
                    count++;
            }
        }
        int max=count;
        for(int i=k;i<s.length();i++){
            if(isVowel(s.charAt(i))){
                    count++;
            }
            count=isVowel(s.charAt(i-k))?count-1:count;
            if(count>max){
                max=count;
            }

        }
        return max;     
    }
}

1. Traverse the array till k and find no of vowels
2. Move the right and left pointer by 1 and calculate the max number of vowels 

Time complexity - o(n)
Space complexity - o(1)
