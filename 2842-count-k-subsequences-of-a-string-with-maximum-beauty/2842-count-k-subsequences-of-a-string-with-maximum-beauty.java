class Solution {
    int MOD = (int) 1e9 + 7;
    int map[];
    Map<String, Integer> dp;

    public int countKSubsequencesWithMaxBeauty(String s, int k) {
        map = new int[26];
        for (char ch : s.toCharArray()) {
            map[ch - 'a']++;
        }
        int count = 0;

        for (int num : map) {
            if (num > 0) count++;
        }

        if (k > count) return 0;

        Arrays.sort(map);

        int k_copy = k;

        int max = 0;

        for (int i = 25; i >= 0 && k_copy > 0; i--) {
            max += map[i];
            k_copy--;
        }

        map = new int[26];
        for (char ch : s.toCharArray()) {
            map[ch - 'a']++;
        }

        dp = new HashMap<>();

        return helper(0, k, max);
    }

    int helper(int idx, int k, int sum) {
        if (k == 0 && sum == 0) return 1;

        if (sum <= 0 || k <= 0) return 0;

        if (idx == 26) return 0;

        String key = idx + "," + sum + "," + k;

        if (dp.containsKey(key)) return dp.get(key);

        long pick = (map[idx] * 1L * helper(idx + 1, k - 1, sum - map[idx])) % MOD;
        long notpick = helper(idx + 1, k, sum);

        dp.put(key, (int) (pick + notpick) % MOD);

        return dp.get(key);
    }
        int setBit(int number, int i) {
            int mask = 1 << i;
            return number | mask;
        }

        boolean isBitSet(int number, int i) {
            int mask = 1 << i;
            return (number & mask) != 0;
        }
}
