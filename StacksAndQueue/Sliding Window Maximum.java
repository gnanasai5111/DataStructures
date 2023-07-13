You are given an array of integers nums, there is a sliding window of size k which is moving from the very left of the array to the very right. 
You can only see the k numbers in the window. Each time the sliding window moves right by one position.

Return the max sliding window.

Input: nums = [1,3,-1,-3,5,3,6,7], k = 3
Output: [3,3,5,5,6,7]
Explanation: 
Window position                Max
---------------               -----
[1  3  -1] -3  5  3  6  7       3
 1 [3  -1  -3] 5  3  6  7       3
 1  3 [-1  -3  5] 3  6  7       5
 1  3  -1 [-3  5  3] 6  7       5
 1  3  -1  -3 [5  3  6] 7       6
 1  3  -1  -3  5 [3  6  7]      7

First approach(Deque)

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int res[]=new int[nums.length-k+1];
        Deque<Integer> q=new ArrayDeque<>();
        int max=0;
        for(int i=0;i<k;i++){
            while(!q.isEmpty() && nums[q.peekLast()]<nums[i]){
                q.pollLast();
            }
             q.offerLast(i);
        }
        res[0]=nums[q.peekFirst()];
        int j=1;
        for(int i=k;i<nums.length;i++){
            if(i-q.peekFirst()==k){
                q.pollFirst();
            }
            while(!q.isEmpty() && nums[q.peekLast()]<nums[i]){
                q.pollLast();
            }
            
            q.offerLast(i);
            res[j]=nums[q.peekFirst()];
            j++;
            
        }
        return res;
        
    }
}

1. we follow Monotonic decreasing deque here.That is largest element is at the first.
2. when we add a new element to queue,if the element is greater than the last element of the queue then pop the elements else push the index 
3. To maintain the window size,keep track of indexes, so if current element index - first element index==window size,pop the first element.

Time complexity - o(N)
Space complexity - o(K)
