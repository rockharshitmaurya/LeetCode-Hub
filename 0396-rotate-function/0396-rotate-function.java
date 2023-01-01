class Solution {
// https://leetcode.com/problems/rotate-function/discuss/87842/Java-Solution-O(n)-with-non-mathametical-explaination
    public int maxRotateFunction(int[] nums) {
        int sum = 0, intialScore = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            intialScore += (i * nums[i]);
        }
        
        int best_till_now=intialScore;
        
        for(int i=1; i<nums.length; i++){
           intialScore = (intialScore-sum)+nums[i-1]*nums.length;
            best_till_now=Math.max(best_till_now,intialScore);
        }
        
        return best_till_now;
    }
}
