class Solution {
    public String removeStars(String s) {
        StringBuilder sb=new StringBuilder();  
        for(char ch:s.toCharArray()){
            if(ch!='*') sb.append(ch);
            else sb.setLength(sb.length() - 1);
        }
        return sb.toString();
    }
}