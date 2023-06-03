class Solution {

    class Pair {
        char ch;
        int count = 0;

        Pair(char _ch, int _count) {
            ch = _ch;
            count = _count;
        }
    }

    public String frequencySort(String s) {
        ArrayList<Pair> list = new ArrayList<>();

        for (char ch = 'a'; ch <= 'z'; ch++) {
            list.add(new Pair(ch, 0));
        }

        for (char ch = 'A'; ch <= 'Z'; ch++) {
            list.add(new Pair(ch, 0));
        }

        for (char ch = '0'; ch <= '9'; ch++) {
            list.add(new Pair(ch, 0));
        }

        for (char ch : s.toCharArray()) {
            if (ch >= 'A' && ch <= 'Z') continue;
            if (ch >= '0' && ch <= '9') continue;
            list.get(ch - 'a').count++;
        }

        for (char ch : s.toCharArray()) {
            if (ch >= 'a' && ch <= 'z') continue;
            if (ch >= '0' && ch <= '9') continue;
            list.get((ch - 'A') + 26).count++;
        }

        for (char ch : s.toCharArray()) {
            if (ch >= 'a' && ch <= 'z') continue;
            if (ch >= 'A' && ch <= 'Z') continue;
            list.get((ch - '0') + 26 + 26).count++;
        }

        StringBuilder sb = new StringBuilder();

        Collections.sort(list, (o1, o2) -> (o2.count - o1.count));

        for (int i = 0; i < list.size(); i++) {
            int totle = list.get(i).count;
            if (totle == 0) break;
            while (totle-- > 0) {
                sb.append(list.get(i).ch);
            }
        }

        return new String(sb);
    }
}
