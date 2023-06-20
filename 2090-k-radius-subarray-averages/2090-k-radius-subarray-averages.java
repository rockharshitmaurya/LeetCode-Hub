class Solution {

    public int[] getAverages(int[] nums, int k) {
        int n = nums.length;
        long psum[] = new long[n];
        psum[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            psum[i] = (psum[i - 1] + nums[i]);
        }
        // System.out.println(Arrays.toString(psum));
        for (int i = 0; i < n; i++) {
            if (i + k >= n || i - k < 0) {
                nums[i] = -1;
                continue;
            }

            long right = psum[i + k];
            long remove = (i - k) == 0 ? 0 : psum[i - k - 1];
            long sum = right - remove;
            // System.out.println(sum);
            nums[i] = (int) (sum / ((k * 2) + 1));
        }

        return nums;
    }
}
