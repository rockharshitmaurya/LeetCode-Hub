class Solution {

    public List<Integer> majorityElement(int[] nums) {
        ArrayList<Integer> ans = new ArrayList<>();
        Arrays.sort(nums);
        int count = 0;
        int ele = nums[0];
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            if (nums[i] == ele) {
                count++;
            } else {
                if (count > (len / 3)) ans.add(ele);
                ele = nums[i];
                count = 1;
            }
            // System.out.println(count + " " + ele);
        }
        if (count > (len / 3)) ans.add(ele);
        return ans;
    }
}
