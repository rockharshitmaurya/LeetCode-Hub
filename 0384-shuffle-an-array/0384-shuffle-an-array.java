class Solution {
    int ans[];

    public Solution(int[] nums) {
        ans = nums;
    }

    public int[] reset() {
        return ans;
    }

    public int[] shuffle() {
        int shuffle[] = new int[ans.length];
        for (int i = 0; i < ans.length; i++) {
            int j = (int) (Math.random() * (i + 1));
            shuffle[i] = shuffle[j];
            shuffle[j] = ans[i];
        }
        return shuffle;
    }
}
/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */
