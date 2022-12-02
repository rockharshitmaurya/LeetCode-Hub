class Solution {

    public boolean closeStrings(String word1, String word2) {
        // if (word1.length() < word2.length()) return closeStrings(word2, word1);
        int map1[] = new int[26], map2[] = new int[26];

        HashSet<Character> set = new HashSet<>();
        for (char ch : word1.toCharArray()) {
            set.add(ch);
            map1[ch - 'a']++;
        }

        for (char ch : word2.toCharArray()) {
            if (!set.contains(ch)) return false;
            map2[ch - 'a']++;
        }

        Arrays.sort(map1);
        Arrays.sort(map2);

        for (int i = 0; i < 26; i++) {
            if (map1[i] != map2[i]) return false;
        }

        return true;
    }
}
