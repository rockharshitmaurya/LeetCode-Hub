class Solution {

    public int trap(int[] height) {
        int n = height.length;
        int left[] = new int[n];
        int right = 0;

        left[0] = height[0];
        for (int i = 1; i < n; i++) {
            left[i] = Math.max(left[i - 1], height[i]);
        }

        right = height[n - 1];
        left[n-1]=Math.min(left[n-1],right);
        for (int i = n - 2; i >= 0; i--) {
            // int cur=
            left[i] = Math.min(left[i],right=Math.max(right, height[i]));
        }

        int ans = 0;

        for (int i = 0; i < n; i++) {
            int min = left[i];

            ans += (min - height[i]);
        }

        return ans;
    }
}
