class Solution {

    public int[] maxSlidingWindow(int[] nums, int k) {
        int ans[] = new int[nums.length - k + 1];
        TreeMap<Integer, Integer> tm = new TreeMap<>();
        int idx = 0;
        for (int i = 0; i < nums.length; i++) {
            tm.put(nums[i], tm.getOrDefault(nums[i], 0) + 1);
            if ((i + 1) < k) continue;
            ans[idx++] = tm.lastKey();
            int count = tm.get(nums[i - (k - 1)]);
            if (count == 1) {
                tm.remove(nums[i - (k - 1)]);
            } else {
                tm.put(nums[i - (k - 1)], count - 1);
            }
        }

        return ans;
    }
}
