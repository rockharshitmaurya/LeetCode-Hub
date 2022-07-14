```
public static int LCSubStrM1(char[] X, char[] Y, int m, int n, int lcsCount) {
if (m <= 0 || n <= 0)
return lcsCount;
int lcsCount1=lcsCount;
if (X[m - 1] == Y[n - 1])
lcsCount1 = LCSubStrM1(X, Y, m - 1, n - 1, lcsCount + 1);
​
int lcsCount2 = LCSubStrM1(X, Y, m, n - 1, 0); // put length 0 to count substring again
int lcsCount3 = LCSubStrM1(X, Y, m - 1, n, 0); // put length 0 to count substring again
​
return Math.max(lcsCount1, Math.max(lcsCount2, lcsCount3));
}
```