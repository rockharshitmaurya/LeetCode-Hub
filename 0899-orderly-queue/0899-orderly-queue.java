class Solution {

    public String orderlyQueue(String s, int k) {
        StringBuilder sb = new StringBuilder(s);
        String ans = s;
        if (k == 1) {
            for (int i = 0; i < s.length(); i++) {
                sb.append(sb.charAt(0));
                sb.deleteCharAt(0);
                if (ans.compareTo(sb.toString())>0) {
                    ans = sb.toString();
                }
            }
            return ans;
        }
        char arr[]=s.toCharArray(); Arrays.sort(arr);
        return new String(arr);
    }
}
