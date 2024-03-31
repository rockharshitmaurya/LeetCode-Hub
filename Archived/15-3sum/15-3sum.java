class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> ans=new HashSet<>();
        int n=nums.length;
        Arrays.sort(nums);
        for(int i=0; i<n-2; i++){
            int j=i+1,k=n-1;
            while(j<k){
                int sum=nums[i]+nums[j]+nums[k];
                if(sum==0) ans.add(Arrays.asList(nums[i],nums[j++],nums[k--]));
                else if(sum>0) k--;
                else j++;
            }
        }
        
        return new ArrayList<>(ans);
    }
}