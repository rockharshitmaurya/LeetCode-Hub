class Solution {

    public int[] getSumAbsoluteDifferences(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        int n = nums.length;
        int pref = 0;
        for (int i = 0; i < n; i++) {
            int left = pref;
            int right = (sum - left - nums[i]);

            left = Math.abs(left - (nums[i] * i));
            right = Math.abs((right - (nums[i] * (n - i - 1))));
            pref += nums[i];
            nums[i] = (left + right);
        }

        return nums;
    }
}
// 2 3 5
