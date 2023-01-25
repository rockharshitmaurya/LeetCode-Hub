class Solution {

    public String largestNumber(int[] nums) {
        int n = nums.length;
        String str[] = new String[n];
        for (int i = 0; i < n; i++) {
            str[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(str,(str1, str2) -> {
                String oneTwo = str1 + str2;
                String twoOne = str2 + str1;
                return twoOne.compareTo(oneTwo);
            }
        );
        StringBuilder sb = new StringBuilder();
        for (String s : str) {
            sb.append(s);
        }
        int idx = -1;
        for (int i = 0; i < sb.length(); i++) {
            if (sb.charAt(i) != '0') {
                idx = i;
                break;
            }
        }
        return idx == -1 ? "0" : sb.toString().substring(idx);
    }
}
