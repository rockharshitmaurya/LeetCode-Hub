class Solution {

    public String predictPartyVictory(String senate) {
        Queue<Character> q = new LinkedList<>();
        for (char ch : senate.toCharArray()) {
            q.offer(ch);
        }

        int R = 0, D = 0;
        boolean flag = true;

        while (R<=q.size() && D<=q.size()) {
            // flag = false;
            char ch = q.poll();
            // System.out.println("R : "+R + " D : " + D);
            if (R == 0 && D == 0) {
                if (ch == 'R') {
                    R++;
                } else {
                    D++;
                }
                q.offer(ch);
            } else if (R > D) {
                if (ch == 'R') {
                    R++;
                    q.offer(ch);
                } else {
                    R--;
                }
            } else if (D > R) {
                if (ch == 'D') {
                    D++;
                    q.offer(ch);
                } else {
                    D--;
                }
            }
        }

        return R>0?"Radiant":"Dire";
    }
}
// RDRDRDRDRDD
