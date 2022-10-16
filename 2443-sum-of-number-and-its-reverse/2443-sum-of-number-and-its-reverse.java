class Solution {

    public boolean sumOfNumberAndReverse(int num) {
        for (int i = 0; i <= num; i++) {
            if (rev_number(i) + i == num) return true;
        }
        return false;
    }

    public int rev_number(int number) {
        return Integer.parseInt(new StringBuilder(number+"").reverse().toString());
    }
}
