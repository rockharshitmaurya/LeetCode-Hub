class Solution {

    public boolean checkIfCanBreak(String s1, String s2) {
        char str1[] = s1.toCharArray();
        char str2[] = s2.toCharArray();
        Arrays.sort(str1);
        Arrays.sort(str2);
        // System.out.println(Arrays.toString(str1));
        // System.out.println(Arrays.toString(str2));
        int i=0;
        while(i<str1.length && str1[i]==str2[i]) i++;
        int idx=i;
        for (; i < str1.length; i++) {
            if(str1[idx]>str2[idx] && str1[i]<str2[i]) return false;
            if(str1[idx]<str2[idx] && str1[i]>str2[i]) return false;
        }
        return true;
    }
}
// abc
// axy
