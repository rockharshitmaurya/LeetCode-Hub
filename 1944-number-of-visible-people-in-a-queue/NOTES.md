* Idea
​
* It's quite similar idea with 496. Next Greater Element I problem.
* We use increasing mononotic stack will store heights by increasing order.
* Process from right to left, i = [n-1..0]
* while heights[i] > st.top() // If heights[i] > st.top() then i_th person will obscure the others shorter people on the right side.
* st.pop() // Remove shorter people on the right side, because those people can't be seen anymore.
* ans[i] += 1 // i_th person can see those shorter people, so increase by one
* if !st.empty(): // If stack is not empty then i_th person can see one more person which is taller than himself.
* ans[i] += 1 // increase by one
* st.append(heights[i]) // add i_th person to our stack
* return ans