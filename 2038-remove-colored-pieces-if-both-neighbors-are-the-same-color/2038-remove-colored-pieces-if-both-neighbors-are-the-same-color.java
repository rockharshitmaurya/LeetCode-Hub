class Solution {

    public boolean winnerOfGame(String colors) {
        int A = 0, B = 0;
        int i = 0, n = colors.length();
        while (i < n) {
            int temp_a = 0;
            while (i < n && colors.charAt(i) == 'A') {
                temp_a++;
                i++;
            }

            int temp_b = 0;
            while (i < n && colors.charAt(i) == 'B') {
                temp_b++;
                i++;
            }
            A += Math.max(0, temp_a - 2);
            B += Math.max(0, temp_b - 2);
        }

        return A>B;
    }
}
// AAABABB
