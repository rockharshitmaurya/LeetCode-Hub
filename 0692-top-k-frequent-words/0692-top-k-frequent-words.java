class Solution {

    class Pair {
        int count;
        String key;

        Pair(int c, String k) {
            count = c;
            key = k;
        }
    }

    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Pair> map = new HashMap<>();

        for (String word : words) {
            if (!map.containsKey(word)) map.put(word, new Pair(0, word));

            map.get(word).count++;
        }

        List<Pair> temp = new ArrayList<>();
        for (Pair p : map.values()) temp.add(p);
        List<String> ans = new ArrayList<>();
        Collections.sort(
            temp,
            (o1, o2) -> {
                if (o1.count != o2.count) return o2.count - o1.count; else return o1.key.compareTo(o2.key);
            }
        );
        for (int i = 0; i < k; i++) ans.add(temp.get(i).key);
        return ans;
    }
}
