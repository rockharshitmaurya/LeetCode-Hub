class Solution {
    HashMap<Double, Integer> map = new HashMap<>();

    public int numberOfBoomerangs(int[][] points) {
        int ans = 0;
        for (int i = 0; i < points.length; i++) {
            for (int j = 0; j < points.length; j++) {
                if (i == j) continue;
                double dis = getDis(points[i][0], points[i][1], points[j][0], points[j][1]);
                map.put(dis, map.getOrDefault(dis, 0) + 1);
            }
            for (int num : map.values()) {
                if (num > 1) {
                    ans += ((num * (num - 1)));
                }
            }
            
            map.clear();
        }

        return ans;
    }

    double getDis(double x1, double y1, double x2, double y2) {
        double distance = Math.sqrt((x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1));
        return distance;
    }
}
// [[1,0],[1,1],[1,2],[0,1]]
// [[0,0],[1,0],[2,0]]
