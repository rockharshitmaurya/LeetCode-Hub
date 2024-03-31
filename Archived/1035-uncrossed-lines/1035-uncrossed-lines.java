class Solution {
    int dp[][]=new int[501][501];
    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        for(int arr[]:dp) Arrays.fill(arr,-1);
        return helper(nums1,nums2,0,0);
    }

    int helper(int arr1[], int arr2[], int idx1, int idx2) {
        
        if(idx1==arr1.length || idx2==arr2.length) return 0;
        
        if(dp[idx1][idx2]!=-1) return dp[idx1][idx2];
        
        if (arr1[idx1] == arr2[idx2]) return 1 + helper(arr1, arr2, idx1 + 1, idx2 + 1);

        int left = helper(arr1, arr2, idx1 + 1, idx2);
        int right = helper(arr1, arr2, idx1, idx2 + 1);
        return dp[idx1][idx2]=Math.max(left , right);
    }
}
