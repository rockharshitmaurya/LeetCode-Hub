class Solution {

    public boolean isNStraightHand(int[] hand, int groupSize) {
        TreeMap<Integer, Integer> map = new TreeMap<>();

        for (int num : hand) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        while (map.size() > 0) {
            int start = map.firstKey();
            for (int i = start; i <= start + groupSize - 1; i++) {
                if (!map.containsKey(i)) return false; else {
                    map.put(i, map.get(i) - 1);
                    if (map.get(i) == 0) map.remove(i);
                }
            }
        }

        return true;
    }
}
