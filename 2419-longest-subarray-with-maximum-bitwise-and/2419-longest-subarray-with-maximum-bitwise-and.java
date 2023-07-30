import java.util.Arrays;

class Solution {
    public int longestSubarray(int[] nums) {
        int max = Arrays.stream(nums).max().orElse(0);
        return Arrays.stream(nums)
                .boxed()
                .reduce(new int[]{0, 0}, (result, ele) -> ele == max ? new int[]{Math.max(result[0], ++result[1]), result[1]} : new int[]{Math.max(result[0], result[1]), 0}, (a, b) -> new int[]{Math.max(a[0], b[0]), 0})[0];
    }
}
