class Solution {

    public List<String> watchedVideosByFriends(List<List<String>> watchedVideos, int[][] friends, int id, int level) {
        HashMap<String, Integer> map = new HashMap<>();
        HashSet<Integer> vis = new HashSet<>();
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] { id, 0 });
        vis.add(id);
        while (!q.isEmpty()) {
            int person = q.peek()[0];
            int cur_level = q.poll()[1];

            for (int friend : friends[person]) {
                if (vis.contains(friend)) continue;
                vis.add(friend);
                if (cur_level + 1 == level) { //if we recahed to level
                    for (String video : watchedVideos.get(friend)) {
                        map.put(video, map.getOrDefault(video, 0) + 1);
                    }
                } else {
                    q.offer(new int[] { friend, cur_level + 1 });
                }
            }
        }
        System.out.println(map);
        List<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());
        Collections.sort(
            list,
            (a, b) -> {
                if (a.getValue().equals(b.getValue())) {
                    return a.getKey().compareTo(b.getKey());
                }
                return a.getValue().compareTo(b.getValue());
            }
        );
        List<String> ans = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : list) {
            // map.put(entry.getKey(), entry.getValue());
            ans.add(entry.getKey());
        }
        return ans;
    }
}
