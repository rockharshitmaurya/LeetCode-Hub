class Solution {

    public long minCost(int[] nums, int[] cost) {
        long l = 0, r = 0;
        for (int num : nums) {
            l = Math.min(l, num);
            r = Math.max(r, num);
        }
        long ans = 0;

        while (l <= r) {
            long mid = (int) (l + r) >> 1;
            long res_1 = helper(nums, cost, mid);
            long res_2 = helper(nums, cost, mid + 1);
            if (res_1 < res_2) {
                r = mid-1;
                ans = res_1;
            } else {
                l = mid + 1;
            }
        }

        return ans;
    }

    long helper(int nums[], int cost[], long point) {
        long sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += (Math.abs(point - nums[i]) * cost[i] * 1L);
        }
        return sum;
    }
}
