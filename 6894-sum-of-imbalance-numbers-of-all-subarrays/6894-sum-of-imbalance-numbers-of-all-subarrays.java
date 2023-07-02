class Solution {

    public int sumImbalanceNumbers(int[] nums) {
        int n = nums.length;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            // String sub = "";
            int temp = 0;
            SortingList<Integer> list = new SortingList<>();
            for (int j = i; j < n; j++) {
                list.add(nums[j]);
                temp += list.imbalance;
                // System.out.println(list.imbalance);
                // System.out.println(list.delegate);
            }
            ans += temp;
        }

        return ans;
    }

    class SortingList<E extends Comparable<E>> {
        private ArrayList<E> delegate;
        private int len;
        private int imbalance;

        public SortingList() {
            delegate = new ArrayList<>();
            len = 0;
            imbalance = 0;
        }

        public void add(E e) {
            int insertionIndex = Collections.binarySearch(delegate, e);
            if (insertionIndex < 0) {
                insertionIndex = -(insertionIndex + 1);
            } else {
                insertionIndex++;
            }
            len++;
            delegate.add(insertionIndex, e);
            if (len == 1) return;
            if (insertionIndex == 0) {
                if ((Integer) delegate.get(1) - (Integer) delegate.get(0) > 1) imbalance++;
            } else if (insertionIndex == len-1) {
                if ((Integer) delegate.get(len-1) - (Integer) delegate.get(len - 2) > 1) imbalance++;
            } else {
                Integer next = (Integer) delegate.get(insertionIndex + 1);
                Integer prev = (Integer) delegate.get(insertionIndex - 1);
                if (next - prev > 1) {
                    imbalance--;
                    // System.out.println(" first ");
                }
                if (next - (Integer) e > 1) {
                    imbalance++;
                    // System.out.println(" second ");
                }
                if ((Integer) e - prev > 1) {
                    imbalance++;
                    // System.out.println(" third ");
                }
            }
            // System.out.println(insertionIndex+" index ");

            // if (delegate.size() >= 2) {
            //     if (((Integer) delegate.get(len - 1) - (Integer) delegate.get(len - 2)) > 1) imbalance++;
            // }
        }

        // 10 13 11
        public void remove(E e) {
            int index = Collections.binarySearch(delegate, e);
            delegate.remove(index);
            len--;
        }

        public int size() {
            return len;
        }

        public E get(int index) {
            return delegate.get(index);
        }
    }
}
