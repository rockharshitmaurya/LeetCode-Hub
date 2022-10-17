class Solution {

    public boolean checkIfPangram(String sentence) {
        if (sentence.length() < 26) return false;
        int count[] = new int[26];
        for (char ch : sentence.toCharArray()) {
            count[ch - 'a']++;
        }
        for(int num:count) if (num == 0) return false;
        return true;
    }
}
