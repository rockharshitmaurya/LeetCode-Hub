class Solution {

    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        List<String> ans = new ArrayList<>();
        Trie root = new Trie();
        for (String str : words) {
            addWord(str, root);
        }
        for (String str : words) {
            if (isOk(str, 0, 0, root)) {
                ans.add(str);
            }
        }
        return ans;
    }

    boolean isOk(String str, int idx, int count, Trie root) {
        Trie temp = root;
        for (int i = idx; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (temp.childrens[ch - 'a'] == null) {
                return false;
            }
            if (temp.childrens[ch - 'a'].isEnd) {
                if (i == str.length() - 1) {
                    return count+1 > 1; //+1 is for last cut in the string
                }
                if (isOk(str, i + 1, count + 1, root)) {
                    return true;
                }
            }
            temp = temp.childrens[ch - 'a'];
        }

        return false;
    }

    // void addWord(String str, Trie root) {
    //     Trie node = root;
    //     for (char ch : str.toCharArray()) {
    //         if (node.childrens[ch - 'a'] == null) {
    //             node.childrens[ch - 'a'] = new Trie();
    //         }
    //         node = node.childrens[ch - 'a'];
    //     }
    //     node.isEnd = true;
    // }
    void addWord(String str, Trie root) {
        char[] chars = str.toCharArray();
        Trie cur = root;
        for (char c : chars) {
            if (cur.childrens[c - 'a'] == null) {
                cur.childrens[c - 'a'] = new Trie();
            }
            cur = cur.childrens[c - 'a'];
        }
        cur.isEnd = true;
    }

    class Trie {
        Trie childrens[];
        boolean isEnd;

        public Trie() {
            childrens = new Trie[26];
            isEnd = false;
        }
    }
}
