class Solution {

    public int minCapability(int[] nums, int k) {
        int left = 1, right = (int) 1e9, n = nums.length;
        while (left < right) {
            int mid = (left + right) / 2;
            int take = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] <= mid) {
                    take++;
                    i++;
                }
                if(take>=k) break;
            }
            if (take >= k) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}
