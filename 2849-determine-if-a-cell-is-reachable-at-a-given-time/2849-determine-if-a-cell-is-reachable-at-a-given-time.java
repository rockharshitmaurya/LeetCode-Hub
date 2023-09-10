class Solution {
    public boolean isReachableAtTime(int x1, int y1, int x2, int y2, int t) {
        int dx = Math.abs(x2 - x1);
        int dy = Math.abs(y2 - y1);
        int distance = Math.max(dx, dy);
        
        if(x1==x2 && y1==y2 && t==1) return false;
        System.out.println(distance);
        return distance<=t;
    }
}