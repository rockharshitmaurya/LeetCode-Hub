class Solution {

    public int maxCandies(int[] status, int[] candies, int[][] keys, int[][] containedBoxes, int[] initialBoxes) {
        Queue<Integer> q = new LinkedList<>();
        HashSet<Integer> key = new HashSet<>();
        HashSet<Integer> vis = new HashSet<>();
        int ans = 0;
        for (int box : initialBoxes) {
            q.offer(box);
            for (int xkey : keys[box]) {
                key.add(xkey);
            }
        }

        while (!q.isEmpty()) {
            int box = q.poll();

            if (vis.contains(box)) continue;
            vis.add(box);

            if (status[box] == 1 || key.contains(box)) {
                ans += candies[box];
                key.remove(box);
                for (int boxx : containedBoxes[box]) {
                    q.offer(boxx);
                    for (int xkey : keys[boxx]) {
                        key.add(xkey);
                    }
                }
            }
        }

        // System.out.println(q);
        return ans;
    }
}
