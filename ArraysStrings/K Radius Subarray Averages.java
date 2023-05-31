First approach(Brute force)
  
class Solution {
    public int[] getAverages(int[] nums, int k) {
        int res[]=new int[nums.length];
        for(int i=0;i<nums.length;i++){
            if(i-k>=0 && k+i<nums.length){
                long sum=0;
                for(int j=i-k;j<=k+i;j++){
                    sum=sum+nums[j];
                }
                res[i]=(int)(sum/(2*k+1));
            }
            else{
                res[i]=-1;
            }
            
        }
        return res;      
    }
}

1. Traverse the array, At each end check for k indexes left and k indexes right if they exist find the average and store in res else store -1;

Time complexity - o(N*N)
Space complexity - o(N)
  
Second approach(Prefix sum)
  
class Solution {
    public int[] getAverages(int[] nums, int k) {
        if (k == 0) {
            return nums;
        }
        int N = nums.length;
        int res[]=new int[N];
        Arrays.fill(res,-1);
        if(2*k+1>N){
            return res;
        }
        long pre[]=new long[N];
        pre[0]=nums[0];
        for(int i=1;i<N;i++){
            pre[i]=pre[i-1]+nums[i];
        }
        for(int i=k;i<N-k;i++){ 
            res[i] = (int) ((pre[i+k] - pre[i-k]+nums[i-k]) / (2*k+1)); 
        }
        return res; 
    }
}

1. If the array length is less than 2*k+1 then return the array filled with -1
2. Traverse the array from k to N-k and find the average between this indexes using prefix sum

Time complexity - o(N)
Space complexity - o(N)
  
Third approach(Sliding window)
  
class Solution {
    public int[] getAverages(int[] nums, int k) {
        if (k == 0) {
            return nums;
        }
        int N = nums.length;
        int res[]=new int[N];
        Arrays.fill(res,-1);
        if(2*k+1>N){
            return res;
        }
        long sum=0;
        for(int i=0;i<2*k+1;i++){
            sum=sum+nums[i];
        }
        res[k]=(int)(sum/(2*k+1));
        for(int i=k+1;i<N-k;i++){ 
            sum=sum+nums[i+k]-nums[i-k-1];
            res[i]=(int)(sum/(2*k+1));
        }
        return res; 
    }
}

1. Calculate the sum of first window(2*k+1) .
2. Then move the window and add the next number and subtract the number which is not part of the window.
  
Time complexity - o(N)
Space complexity - o(1)
