class Solution {

    public int minimumAverageDifference(int[] nums) {
  int n=nums.length;
        int ans[][]=new int[nums.length][2];
        long sum=0;
        for(int num:nums) sum+=num;
        long r_sum=0;
        for(int i=0; i<nums.length; i++){
            ans[i][0]=i; r_sum+=nums[i];
            long cur_sum=sum-r_sum;
            int l=i+1,r=n-i-1;
            ans[i][1]=(int)Math.abs((r_sum/l)-(r==0?cur_sum:(cur_sum/r)));
        }
        int idx=0,val=Integer.MAX_VALUE;
        for(int i=0; i<n; i++){
            if(ans[i][1]<val){
                val=ans[i][1];
                idx=ans[i][0];
            }else if(ans[i][1]==val && ans[i][0]<idx) idx=ans[i][0];
        }
        return idx;
    }
}
