my thoughts ,similer to this
​
```
public int findMinArrowShots(int[][] points) {
if (points == null || points.length == 0) return 0;
int count = 0;      // results
// minEnd : Key parameter "active set" for overlapping intervals,
// e.g. the minimum ending point among all overlapping intervals;
int minEnd = Integer.MAX_VALUE;
Arrays.sort(points, (a,b) -> (a[0] - b[0]));   // Sorting the intervals/pairs in ascending order of its starting point
for (int[] in : points) {
// If the changing some states, record some information, and start a new active set "new arrow"
if (in[0] > minEnd) {
count++;
minEnd = in[1];
} else {
// renew key parameters of the active set
minEnd = Math.min(minEnd, in[1]);
}
}
return count + 1;
}
```