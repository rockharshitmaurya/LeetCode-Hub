class Solution {
    int MOD = (int) 1e9 + 7;
    int[] map;

    public int countKSubsequencesWithMaxBeauty(String s, int k) {
        map = new int[26];
        for (char ch : s.toCharArray()) {
            map[ch - 'a']++;
        }

        int count = (int) Arrays.stream(map).filter(x -> x > 0).count();
        if (k > count) return 0;

        Arrays.sort(map);
        int max = Arrays.stream(map).skip(26 - k).sum();

        return helper(0, k, max, new HashMap<>());
    }

    int helper(int idx, int k, int sum, Map<String, Integer> dp) {
        if (k == 0 && sum == 0) return 1;
        if (sum <= 0 || k <= 0 || idx == 26) return 0;
        String key = idx + "," + sum + "," + k;
        if (dp.containsKey(key)) return dp.get(key);

        long pick = (map[idx] * 1L * helper(idx + 1, k - 1, sum - map[idx], dp)) % MOD;
        long notpick = helper(idx + 1, k, sum, dp);

        dp.put(key, (int) (pick + notpick) % MOD);
        return dp.get(key);
    }
}
