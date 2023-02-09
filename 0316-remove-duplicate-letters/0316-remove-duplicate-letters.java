class Solution {

    public String removeDuplicateLetters(String s) {
        int count[] = new int[26];
        char str[] = s.toCharArray();
        for (char ch : str) {
            count[ch - 'a']++;
        }
        Stack<Character> st = new Stack<>();
        HashSet<Character> set = new HashSet<>();
        for (int i = 0; i < str.length; i++) {
            char ch = str[i];
            while (!st.isEmpty() && ch <= st.peek() && count[st.peek() - 'a'] > 0 && !st.contains(ch)) {
                set.remove(st.pop());
            }
            if (set.add(ch)) st.push(ch);
            count[ch - 'a']--;
        }
        StringBuilder ans=new StringBuilder();
        while(!st.isEmpty()) {
            ans.append(st.pop());
        }
        return ans.reverse().toString();
    }
}
