class Solution {
    public String reverseWords(String s) {
        String[] str = s.split("\\s+");
        StringBuilder sb = new StringBuilder();
        for(int i=str.length-1; i>=0; i--){
            for(int j=0; j<str[i].length(); j++){
                sb.append(str[i].charAt(j));
            }
            sb.append(" ");
        }
        return sb.toString().trim();
    }
}