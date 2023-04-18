First approach(Prefix sum)
  
class Solution {
    public int largestAltitude(int[] gain) {
        int sum[]=new int[gain.length+1];
        int max=0;
        for(int i=1;i<sum.length;i++){
            sum[i]=sum[i-1]+gain[i-1];
            if(sum[i]>max){
                max=sum[i];
            }
        }
        return max;
        
    }
}

1. Calculate the prefix sum at each index and see which is greater

Time complexity - o(n)
Space complexity -o(1)
  
Second approach(sum without extra space)
  
class Solution {
    public int largestAltitude(int[] gain) {
        int max=0,sum=0;
        for(int i=0;i<gain.length;i++){
            sum=sum+gain[i];
            if(sum>max){
                max=sum;
            }
        }
        return max;
        
    }
}

1. Calculate the sum at each index and see which is greater

Time complexity - o(n)
Space complexity - o(1)
  
