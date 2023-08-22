class Solution {
    public int minSwaps(String s) {
        int cntOne = 0, cntZero = 0;
        for (char c : s.toCharArray())
            if (c == '0') ++cntZero;
            else ++cntOne;
        if (Math.abs(cntOne - cntZero) > 1) // Invalid
            return -1;
        if (cntZero > cntOne) // Zero must be on even position
            return countSwaps(s, '0'); 
        if (cntZero < cntOne) // One must be on even position
            return countSwaps(s, '1'); 
        // get min swaps between 2 case (zero start first or one start first)
        return Math.min(countSwaps(s, '0'), countSwaps(s, '1'));
    }
    int countSwaps(String s, char start) {
        int cntWrongPos = 0;
        for (char c : s.toCharArray()) {
            if (c != start) ++cntWrongPos;
            start = (char) start=='0'?'1':'0';
        }
        return cntWrongPos / 2;
    }
}