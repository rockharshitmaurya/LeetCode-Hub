class Solution {

    public int sumImbalanceNumbers(int[] nums) {
        int n = nums.length;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            int temp = 0;
            SortingList<Integer> list = new SortingList<>();
            for (int j = i; j < n; j++) {
                list.add(nums[j]);
                temp += list.imbalance;
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
            int next = insertionIndex == len - 1 ? Integer.MAX_VALUE : (Integer) delegate.get(insertionIndex + 1);
            int prev = insertionIndex == 0 ? Integer.MIN_VALUE : (Integer) delegate.get(insertionIndex - 1);
            int e1 = (Integer) delegate.get(insertionIndex);
            if (next - prev > 1) imbalance--;
            if (next - e1 > 1) imbalance++;
            if (e1 - prev > 1) imbalance++;
        }
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
