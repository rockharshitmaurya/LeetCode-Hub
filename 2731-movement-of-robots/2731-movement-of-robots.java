class Solution {

    public int sumDistance(int[] nums, String s, int d) {
        for (int i = 0; i < s.length(); i++) {
            char dir = s.charAt(i);

            if (dir == 'R') {
                nums[i] += d;
            } else {
                nums[i] -= d;
            }
        }
        Arrays.sort(nums);
        return sumPairs(nums, nums.length);
    }

    int sumPairs(int nums[], int n) {
        Arrays.sort(nums);
        long sum = 0;
        int mod=(int)1e9+7;
        // int n = nums.length;
        for (int i = 0; i < n; i++) {
            long curr = i * (long) nums[i] - (n - 1 - i) * (long) nums[i];
            sum += curr;
            sum %= mod;
        }

        return (int) sum;
    }
}
