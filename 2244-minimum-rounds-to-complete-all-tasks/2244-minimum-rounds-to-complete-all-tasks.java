class Solution {

    public int minimumRounds(int[] tasks) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int task : tasks) {
            map.put(task, map.getOrDefault(task, 0) + 1);
        }

        int ans = 0;

        for (int count : map.values()) {
            if (count == 1) {
                return -1;
            }
            ans += ((count / 3) + ((count % 3 == 0) ? 0 : 1));
        }

        return ans;
    }
}
