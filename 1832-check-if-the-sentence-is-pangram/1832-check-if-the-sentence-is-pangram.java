class Solution {

    public boolean checkIfPangram(String sentence) {
        int mask=0;
        for (char ch : sentence.toCharArray()) {
             mask = (1<<(ch-'a') | mask);
        }
        
        return mask==67108863;
    }
}
