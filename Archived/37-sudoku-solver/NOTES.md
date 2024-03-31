1. traverse the matrix and find the empty place.
2. once we find the empty place than we tried all the numbers from 1 to 9 and check that it is a valid number or not by checking the rules.
3. and we find the correct number for that place than we find for the second empty place in 9 X 9 matrix.
4. for second empty place we repeat the same process and if we doesn't get any number, so we return false.
5. after getting the false from solve(board) function we make all the places empty that we have filled . than try for other member for first empty place.
6. and after all recursive calls we got true, than we have to stop over there only and no need to search for other solutions.