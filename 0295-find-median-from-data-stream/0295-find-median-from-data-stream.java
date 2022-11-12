class MedianFinder {

    // SortedList<Integer> sl;
    class SortingList<E extends Comparable<E>> {
        private ArrayList<E> delegate;
        private int len;
        public SortingList() {
            delegate = new ArrayList<>();
            len=0;
        }

        public void add(E e) {
            int insertionIndex = Collections.binarySearch(delegate, e);

            // < 0 if element is not in the list, see Collections.binarySearch
            if (insertionIndex < 0) {
                insertionIndex = -(insertionIndex + 1);
            } else {
                // Insertion index is index of existing element, to add new element
                // behind it increase index
                insertionIndex++;
            }
            len++;
            delegate.add(insertionIndex, e);
        }

        public void remove(E e) {
            int index = Collections.binarySearch(delegate, e);
            delegate.remove(index);
            len--;
        }
        public int size(){
            return len;
        }
        public E get(int index) {
            return delegate.get(index);
        }
    }
    SortingList<Integer> st;
    public MedianFinder() {
        st=new  SortingList<>();
    }

    public void addNum(int num) {
        st.add(num);
    }

    public double findMedian() {
        if(st.size()%2==1) return st.get(st.size()/2);
        return (st.get(st.size()/2)+st.get((st.size()/2)-1))/2.0;
    }
}
//1 2 3 4 5 6
/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
