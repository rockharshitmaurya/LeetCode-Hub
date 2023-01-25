class Solution {

    public String largestNumber(int[] nums) {
        int n = nums.length;
        String str[] = new String[n];
        for (int i = 0; i < n; i++) {
            str[i] = String.valueOf(nums[i]);
        }

        Arrays.sort(
            str,
            (str1, str2) -> {
                int n1 = str1.length(), n2 = str2.length();
                for (int i = 0; i < Math.max(n1, n2); i++) {
                    if (str1.charAt(i % n1) != str2.charAt(i % n2)) {
                        int one = str1.charAt(i % n1) - '0';
                        int two = str2.charAt(i % n2) - '0';
                        return two - one;
                    }
                }

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
