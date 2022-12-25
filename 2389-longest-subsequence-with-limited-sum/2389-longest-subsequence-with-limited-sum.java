class Solution {
    public int[] answerQueries(int[] nums, int[] qu) {
        int ans[]=new int[qu.length]; int index=0;
        
        Arrays.sort(nums);
        
        for(int num:qu){
            int len=0;
            long sum=0;
            
            for(int i=0; i<nums.length; i++){
                sum+=nums[i];
                
                if(sum>num) break;
                else len++;
            }
            
            ans[index++]=len;
        }
        return ans;
    }
}