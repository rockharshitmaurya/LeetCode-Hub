class Solution {

    public List<String> summaryRanges(int[] nums) {
        
        ArrayList<String> list = new ArrayList<>();
        if(nums.length==0) return list;
        int start = nums[0];
        boolean check = true;
        for (int i = 0; i < nums.length - 1; i++) {
            check = true;
            if (Math.abs(nums[i + 1] - nums[i]) != 1) {
                if (start == nums[i]) {
                    list.add(start + "");
                } else {
                    list.add(start + "->" + nums[i]);
                }
                start = nums[i + 1];
                check = false;
            }
        }

        // if (check) {
            if (start == nums[nums.length - 1]) {
                list.add(start + "");
            } else {
                list.add(start + "->" + nums[nums.length - 1]);
            }
        // }
        return list;
    }
}
