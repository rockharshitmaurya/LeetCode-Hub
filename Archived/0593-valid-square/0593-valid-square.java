class Solution {
    HashMap<Double, Integer> map = new HashMap<>();
    HashSet<String> set = new HashSet<>();

    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        set.add(p1[0] + ":" + p1[1]);
        set.add(p2[0] + ":" + p2[1]);
        set.add(p3[0] + ":" + p3[1]);
        set.add(p4[0] + ":" + p4[1]);
        if (set.size() != 4) return false;
        getDis(p1[0], p1[1], p2[0], p2[1]);
        getDis(p1[0], p1[1], p3[0], p3[1]);
        getDis(p1[0], p1[1], p4[0], p4[1]);

        getDis(p2[0], p2[1], p1[0], p1[1]);
        getDis(p2[0], p2[1], p3[0], p3[1]);
        getDis(p2[0], p2[1], p4[0], p4[1]);

        getDis(p3[0], p3[1], p2[0], p2[1]);
        getDis(p3[0], p3[1], p1[0], p1[1]);
        getDis(p3[0], p3[1], p4[0], p4[1]);

        getDis(p4[0], p4[1], p2[0], p2[1]);
        getDis(p4[0], p4[1], p1[0], p1[1]);
        getDis(p4[0], p4[1], p3[0], p3[1]);

        System.out.println(map);
        for (int num : map.values()) {
            if (num == 8 && map.size() == 2) return true;
        }
        return false;
    }

    void getDis(double x1, double y1, double x2, double y2) {
        double distance = Math.sqrt((x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1));
        map.put(distance, map.getOrDefault(distance, 0) + 1);
    }
}
