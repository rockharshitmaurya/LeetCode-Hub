class Solution {

    public int findUnsortedSubarray(int[] nums) {
        Stack<Integer> st = new Stack<>();
        int min = nums.length, ans = 0, max = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {
            int idx = i;
            while (i < nums.length - 1 && nums[i] == nums[i + 1]) {
                idx = Math.min(idx, i++);
            }
            if (!st.isEmpty()  && nums[st.peek()] > nums[i]) {
                while (!st.isEmpty() && nums[st.peek()] > nums[i]) {
                    min = Math.min(st.pop(), min);
                    ans = Math.max(ans, (i - min) + 1);
                }
            } else if(max>nums[i]){
                ans = Math.max(ans, (i - min) + 1);
            }
            max = Math.max(max, nums[i]);
            st.push(idx);
        }

        return ans;
    }
}
