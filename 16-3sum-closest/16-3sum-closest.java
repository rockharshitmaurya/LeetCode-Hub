class Solution {
    public int threeSumClosest(int[] nums, int target) {
       Arrays.sort(nums);
        int n=nums.length;
        int ans=nums[0]+nums[1]+nums[2];
        
        for(int i=0; i<n-2; i++){
            int j=i+1,k=n-1;
            while(j<k){
                int temp=nums[i]+nums[j]+nums[k];
                if(temp==target) return temp;
                    
                if(Math.abs(temp-target)<Math.abs(ans-target)){
                    ans=temp;
                }
                
                if(temp>target){
                    k--;
                }else {
                    j++;
                }
            }
        }
        
        return ans;
        
    }
}