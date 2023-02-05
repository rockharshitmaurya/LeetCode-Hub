class Solution {

    public List<Integer> findAnagrams(String s, String p) {
        int n1 = s.length(), n2 = p.length();
        int map2[] = new int[26], map1[] = new int[26];
        ArrayList<Integer> ans = new ArrayList<>();
        int left = 0, right = 0;

        for (char ch : p.toCharArray()) {
            map1[ch - 'a']++;
        }

        while (right < n1) {
            char ch = s.charAt(right);
            map2[ch - 'a']++;

            while (left <= right && map2[ch - 'a'] > map1[ch - 'a']) {
                char ch1 = s.charAt(left++);
                map2[ch1 - 'a']--;
            }
            int len = right - left + 1;
            if (len == n2) {
                // System.out.println(left + " : " + right);
                ans.add(left);
            }
            right++;
        }

        return ans;
    }
}
