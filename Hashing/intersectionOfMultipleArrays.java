Second approach(Hashing)
  
class Solution {
    public List<Integer> intersection(int[][] nums) {
        int count=0;
        ArrayList<Integer> res=new ArrayList<>();
        HashMap<Integer,Integer> m=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            for(int j=0;j<nums[i].length;j++){  
                m.put(nums[i][j],m.getOrDefault(nums[i][j],0)+1);      
            }
        }
        for(Integer i:m.keySet()){
            if(m.get(i)==nums.length){
                res.add(i);
            }
        }
        Collections.sort(res);
        return res;
        
    }
}

1.check the count of all the elements .If the count of each element is equal to array length then add to res and repeat this proceess and sort the res and return .

Time complexity - o(nm+mlogm)
Space complexity - o(nm)
