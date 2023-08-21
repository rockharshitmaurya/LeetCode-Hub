class Solution {

    public int minJumps(int[] arr) {
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        int n = arr.length;
        for (int i = 0; i < arr.length; i++) {
            if (!map.containsKey(arr[i])) map.put(arr[i], new ArrayList<>());
            map.get(arr[i]).add(i);
        }

        Queue<Integer> q = new LinkedList<>();
        HashSet<Integer> vis = new HashSet<>();

        q.offer(0);
        vis.add(0);

        int time = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int idx = q.poll();
                if (idx == n - 1) return time;
                for (int jump : new int[] { -1, 1 }) {
                    int new_jump = idx + jump;
                    if (new_jump < 0 || new_jump >= n || !vis.add(new_jump)) continue;
                    q.offer(new_jump);
                }

                for (int j = map.get(arr[idx]).size() - 1; j >= 0; j--) {
                    int new_jump = map.get(arr[idx]).get(j);
                    if (!vis.add(new_jump)) continue;
                    q.offer(new_jump);
                }

                map.get(arr[idx]).clear();
            }
            time++;
        }

        return -1;
    }
}
