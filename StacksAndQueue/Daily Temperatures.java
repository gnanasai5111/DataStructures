Given an array of integers temperatures represents the daily temperatures,
return an array answer such that answer[i] is the number of days you have to wait after the ith day to get a warmer temperature.
If there is no future day for which this is possible, keep answer[i] == 0 instead.

Input: temperatures = [73,74,75,71,69,72,76,73]
Output: [1,1,4,2,1,1,0,0]

First approach(Brute force)

class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int ans[]=new int[temperatures.length];
        for(int i=0;i<temperatures.length;i++){
            for(int j=i+1;j<temperatures.length;j++){
                if(temperatures[i]<temperatures[j]){
                    ans[i]=j-i;
                    break;
                }
            }         
        }
        return ans;
    }
}

1. Traverse the array ,for each value check if there exists in any value that is greater than the current value and return difference between indexes else return 0;

Time complexity - o(N)
Space co plexity - o(N)

Second approach(Monotonic Stack)

class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int ans[]=new int[temperatures.length];
        Stack<Integer> s=new Stack();
        for(int i=0;i<temperatures.length;i++){
            if(s.empty()){
                s.push(i);
            }
            else{
                while(!s.empty() && temperatures[i]>temperatures[s.peek()]){
                    int val=s.pop();
                    ans[val]=i-val;
                }
                s.push(i);
            }    
        }
        return ans;
    }
}

1. If stack is empty,push element to stack
2. Else check is current elemnt is graeter than the top of the stack,if yes pop the element and repeat the process

Time complexity - o(N)
Space complexity - o(N)
