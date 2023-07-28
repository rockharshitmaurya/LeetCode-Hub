class Solution {

    public boolean PredictTheWinner(int[] nums) {
        int n = nums.length;
        int sum = 0;
        // for (int num : nums) sum += num;
        // int ans = helper(nums, 0, n - 1);
        // System.out.println(ans);
        // return ans>=(sum/2);
        return helper(nums,0,n-1)>=0;
    }

    int helper(int nums[], int start, int end) {
        if (start == end) return nums[start];


//         int first1 = helper(nums, start + 2, end);
//         int second1 = helper(nums, start + 1, end - 1);

//         first = nums[start] + Math.max(first1, second1);

//         int first2 = helper(nums, start, end - 2);
//         int second2 = helper(nums, start + 1, end - 1);

        // last = nums[end] + Math.max(first2, second2);
        
        int first=nums[start]-helper(nums,start+1,end);
        int second=nums[end]-helper(nums,start,end-1);
        

        return Math.max(first, second);
    }
}
