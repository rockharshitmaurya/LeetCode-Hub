class TopVotedCandidate {
    int min, max, res;
    TreeMap<Integer, Integer> map1 = new TreeMap<>();
    HashMap<Integer, Integer> map = new HashMap<>();
    int ans[];

    public TopVotedCandidate(int[] persons, int[] times) {
        min = persons.length;
        max = 0;
        res = -1;
        int idx = 0;

        for (int num : persons) {
            map.put(num, map.getOrDefault(num, 0) + 1);
            
            if (map.get(num) >= max ){
                res = num;
                max = map.get(num);
            }
            persons[idx++] = res;
        }
        // System.out.println(Arrays.toString(persons));
        ans = persons;
        for (int i = 0; i < times.length; i++) {
            map1.put(times[i], i);
        }
    }

    public int q(int t) {
        if (map1.containsKey(t)) return ans[map1.get(t)]; else {
            return ans[map1.get(map1.lowerKey(t))];
        }
    }
}
/**
 * Your TopVotedCandidate object will be instantiated and called as such:
 * TopVotedCandidate obj = new TopVotedCandidate(persons, times);
 * int param_1 = obj.q(t);
 */
