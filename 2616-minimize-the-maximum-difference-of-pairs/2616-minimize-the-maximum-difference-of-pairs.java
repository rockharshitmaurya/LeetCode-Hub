class Solution {

    public int minimizeMax(int[] nums, int p) {
        int n = nums.length;
        Arrays.sort(nums);
        int l = 0, r = nums[n - 1] - nums[0];
        int ans = r;
        while (l < r) {
            int mid = (l + r) / 2;
            if (helper(nums, mid, p)) {
                ans = mid;
                r = mid;
                // System.out.println(mid);
            } else {
                l = mid + 1;
            }
        }
                // System.out.println(helper(nums,2,p));
        
        return ans;
    }

    boolean helper(int arr[], int mid, int p) {
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] - arr[i-1] <= mid) {
                p--;
                i++;
            }
        }
        return p <= 0;
    }
}
