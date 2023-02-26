class Solution {

    public int maxNumOfMarkedIndices(int[] nums) {
        Arrays.sort(nums);
        // System.out.println(Arrays.toString(nums));
        int ans = 0;
        int i = 0, n = nums.length, j = n/2;

        while (i < n && j < n) {

            while (j < n && nums[i] * 2 > nums[j]) {
                j++;
            }
            // System.out.println(i+" "+j);
            if (j < n) {
                nums[j]=-1;
                j++;
                ans += 2;
            }
            i++;
            while(i<n && nums[i]==-1) i++;
            
        }
        return ans;
    }
}
