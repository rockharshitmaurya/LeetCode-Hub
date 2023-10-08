class Solution {
    int dp[][][];

    public int maxDotProduct(int[] nums1, int[] nums2) {
        dp = new int[nums1.length][nums2.length][2];
        for (int arr2[][] : dp) {
            for (int arr1[] : arr2) {
                Arrays.fill(arr1, -1);
            }
        }
        int ans = helper(nums1, nums2, 0, 0, 0);
        return ans;
    }

    int helper(int[] nums1, int[] nums2, int i, int j, int flag) {
        if (nums1.length == i || nums2.length == j) return flag == 0 ? (int) -1e9 : 0;

        if (dp[i][j][flag] != -1) return dp[i][j][flag];

        int first = helper(nums1, nums2, i + 1, j, flag);
        int second = helper(nums1, nums2, i, j + 1, flag);
        int both = helper(nums1, nums2, i + 1, j + 1, flag);
        int use = (nums1[i] * nums2[j]) + helper(nums1, nums2, i + 1, j + 1, 1);

        return dp[i][j][flag] = Math.max(first, Math.max(second, Math.max(both, use)));
    }
}
