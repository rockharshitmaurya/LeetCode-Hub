class Solution {
    public int[] sumEvenAfterQueries(int[] nums, int[][] queries) {
       HashMap<Integer,Integer> map=new HashMap<>(); 
       int sum=0;
        
       for(int i=0; i<nums.length; i++){
           map.put(i,nums[i]);
           if(nums[i]%2==0) sum+=nums[i];
       }
       int ans[]=new int[queries.length];
        
        for(int i=0; i<queries.length; i++){
            int val=queries[i][0];
            int idx=queries[i][1];  
            
            int prev=map.get(idx);
            map.put(idx,prev+val);
            
            if(map.get(idx)%2==0){
                if(prev%2==0) sum+=val;
                else sum+=(prev+val);
            }else{
                if(prev%2==0) sum-=prev;
            }
            ans[i]=sum;
        }
        return ans;
    }
}