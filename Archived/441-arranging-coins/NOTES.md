Binary Search Approach:
While an Iterative approach works, what if we were to use a little math to help us solve our problem?
Our staircase can be represented as a triangle of size "k", and can contain "N" coins.
Using the area of a triangle formula, we get:
​
(K^2)/2 = N
​
This doesn't work though, because of the fact that there is a daigonal line that isn't counted when using this formula
​
We can count in this diagonal line by increasing the base of our staircase by 1, leaving us with:
​
K * (K+1)/2 = N
​
* We can implement Binary Search now, by setting
*
* Our "left" marker to 0
* Our "right" marker to N, since we cannot use more coins than we our given
* Our "pivot" to left + (right-left)/2, we use this equation instead of (left + right)/2 to avoid getting an integer overflow
* The "area" of our proposed staircase to (pivot * (pivot+1))/2
* To implement Binary Search with these variables, we:
*
* Check if our area is equal to the amount of coins that we are given
* at which point we return "pivot"
* If we used more coins than our limit of coins, then we set "right" to "pivot-1", to use less coins during the next iteration
* If we used less coins than our limit of coins, then we set "left" to "pivot+1", to use more coins during the next iteration
* When our "left" is greater than our "right", our "left" will be set to a incomplete row and our "right" will be set to a complete row, so we return "right"