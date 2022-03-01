why is it (n-1)/m?
```
If you divide some number 2 times, it effectively creates 3 pieces.
Generalization: Dividing N times. creates N+1 pieces.
Same logic applies the other way around, if you have 3 'pieces' then you needed 2 division operations.
​
This is to handle the edge case. Let's say we have a bag with 14 balls and we need to divide it into bags with maximum of 7 balls. 14/7 = 2 which is will be incorrect number of operations. We just need one operation( (14-1)/7 ) two divide a bag of 14 balls into 2 bags with 7 balls each.
​
TLDR:
One 14 bag => 2 Bags with max 7 max balls.
14/7 = 2 Operations (WRONG)
(14-1)/7 = 1 Operation (RIGHT)
```
​