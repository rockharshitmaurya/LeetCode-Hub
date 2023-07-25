class Solution {

    public long sumScores(String s) {
        int arr[] = z_function_fast(s);
        // System.out.println(Arrays.toString(arr));
        long ans=0;
        
        for(int num:arr) ans+=num;
        return ans;
    }

    public static int[] z_function_fast(String string) {
        char[] cs = string.toCharArray();
        int[] zs = new int[string.length()];
        int n = string.length();
        int lt = 0, rt = 0;
        zs[0] = n;
        for (int i = 1; i < n; i++) {
            if (i > rt) {
                lt = i;
                rt = i - 1;
                while (rt + 1 < n && cs[rt + 1] == cs[rt + 1 - lt]) {
                    rt++;
                }
                zs[i] = rt - lt + 1;
            } else {
                int k = i - lt;
                if (zs[k] < rt - i + 1) {
                    zs[i] = zs[k];
                } else {
                    lt = i;
                    while (rt + 1 < n && cs[rt + 1] == cs[rt + 1 - lt]) {
                        rt++;
                    }
                    zs[i] = rt - lt + 1;
                }
            }
        }
        return zs;
    }
}
