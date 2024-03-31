class Solution {

    public String reorganizeString(String s) {
        int arr[] = new int[26];
        for (char ch : s.toCharArray()) {
            arr[ch - 'a']++;
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> (o2[1] - o1[1]));
        for (int i = 0; i < 26; i++) {
            if (arr[i] == 0) continue;
            pq.offer(new int[] { i, arr[i] });
        }
        StringBuilder sb = new StringBuilder();

        while (!pq.isEmpty()) {
            if (pq.size() == 1) {
                if (pq.peek()[1] > 1) return "";
            }

            int one[]=new int[0], two[]=new int[0];

            one = pq.poll();
            if (pq.size() != 0) two = pq.poll();

            sb.append(getChar(one[0]));
            one[1]--;
            if (one[1] != 0) {
                pq.offer(one);
            }

            if (two.length != 0) {
                sb.append(getChar(two[0]));
                two[1]--;
                if (two[1] != 0) {
                    pq.offer(two);
                }
            }
        }

        return sb.toString();
    }

    char getChar(int i) {
        return (char) ('a' + i);
    }
}
// abac
// "aaaaabbbccd"
// a->0
// b->0
// c->0
// d->1
// ababacabacd
