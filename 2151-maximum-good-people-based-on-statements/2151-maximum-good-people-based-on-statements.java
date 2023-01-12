class Solution {
 public int maximumGood(int[][] statements) {
        StringBuilder sb = new StringBuilder();
        int[] res = new int[]{0};
        dfs(sb, statements, 0, 0, res);
        return res[0];
    }
    
    private void dfs(StringBuilder sb, int[][] statements, int index, int count, int[] res) {
        if(index == statements.length) {
            if(isvalid(statements, sb)) {
                res[0] = Math.max(res[0], count);
            }
            return;
        }

        // bad person;
        sb.append("0");
        dfs(sb, statements, index + 1, count, res);
        sb.deleteCharAt(sb.length() - 1);
        
        // good person;
        sb.append("1");
        dfs(sb, statements, index + 1, count + 1, res);
        sb.deleteCharAt(sb.length() - 1);
    }
    
    private boolean isvalid(int[][] statements, StringBuilder sb) {
        String str = sb.toString();
        for(int i = 0; i < str.length(); i++) {
            if(str.charAt(i) == '1') {
                for(int j = 0; j < statements.length; j++) {
                    if(statements[i][j] != 2 && statements[i][j] != str.charAt(j) - '0') {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}