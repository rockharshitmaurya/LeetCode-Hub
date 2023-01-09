class Solution {

    public int maximumTop(int[] nums, int k) {
        int n = nums.length;
        if(k==0) return nums[0];
        if (n == 1) return (k % 2) == 0 ? nums[0] : -1;
        int max = 0;

        int len = n;

        if (k > n) {
            len = n;
        }else if(k==n){
             len=n-1;
        } else if (nums[k] >= nums[k - 1]) {
            len = k+1;
        }else{
            len=k-1;
            max=nums[k];
            if(k==1) return nums[k];
        }

        for (int i = 0; i < len; i++) {
            max = Math.max(max, nums[i]);
        }
        //         if(k<n){
        //             int max2=Math.max(max,nums[k-1]);
        //             if(max2<=nums[k]) return nums[k];
        //             else if(nums[k-1]>max) return max;

        //         }
        return max;
    }
}
