class Solution {

    public int singleNonDuplicate(int[] nums) {
        int l = 0, n = nums.length, r = n - 1;
        if(n==1) return nums[0];
        while (l < r) {
            int mid = (l + r) / 2;
            boolean flag = (mid % 2) == 0;
            // System.out.println(mid);
            if (ok(nums, mid, n)) return nums[mid];

            if (flag) {
                if (nums[mid] != nums[mid + 1]) {
                    r = mid;
                } else {
                    l = mid+1;
                }
            } else {
                if (nums[mid] != nums[mid - 1]) {
                    r = mid;
                } else {
                    l = mid + 1;
                }
            }
        }
        
        return nums[l];
    }

    boolean ok(int nums[], int idx, int n) {
        if (idx != 0 && idx != n - 1 && nums[idx] != nums[idx - 1] && nums[idx] != nums[idx + 1]) return true;
        if (idx == 0 && nums[idx] != nums[idx + 1]) return true;
        if (idx == n - 1 && nums[idx] != nums[idx - 1]) return true;
        return false;
    }
}
