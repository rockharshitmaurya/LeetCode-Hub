In this type of questions (where question want some minimum/ maximum / at least ) we use concept of Binary search more formally this is a technique which generally called as "Answer on Binary Search" (some people also say Binary Search on Answer) .
​
Brute Force -
​
We will check whether the minimum time can be 1 , then 2 , then 3 .......... untill we found an answer.
​
BInary Search
​
Can we do something better ? , why we have to check linearly ? instead we can try Binary search , but how ?
​
Let me take a simple scenario -
​
suppose I take minimum time as 10 and this can not be the minimum time , then 9 also cannot be minimum time , 8 can't in general less than 10 cannot be answer , so instead of check every value we will check using Binary search if we find some valid condition we will move our left and right pointer accordingly.
​
```
PSUDO CODE-
-------------
int check(a,mid)
{
// find answer using this mid
}
while(l<r)
{
m = (l+r)/2;
if(check(arr,m)>=givenK)
//  move left or right accordingly
else
//  move left or right accordingly
}
return ans;
```