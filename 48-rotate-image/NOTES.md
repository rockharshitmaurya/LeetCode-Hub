[https://leetcode.com/problems/rotate-image/discuss/18872/A-common-method-to-rotate-the-image](https://leetcode.com/problems/rotate-image/discuss/18872/A-common-method-to-rotate-the-image)
```
​
* clockwise rotate
* first swap the symmetry (i.e. transpose the matrix), then reverse each row
* 1 2 3     1 4 7     7 4 1
* 4 5 6  => 2 5 8  => 8 5 2
* 7 8 9     3 6 9     9 6 3
*
* anti-clockwise rotate
* first swap the symmetry (i.e. transpose the matrix), then reverse each col
```
​
​
```
public void rotate(int[][] image) {
transposeImage(image);
​
// reverse each row of the image
for(int row = 0; row < image.length; row++) {
int i = 0;
int j = image[row].length - 1;
while(i < j) {
int tmp = image[row][i];
image[row][i++] = image[row][j];
image[row][j--] = tmp;
}
}
}
​
// Turns rows into cols and vice versa
private void transposeImage(int[][] image) {
for(int i = 0; i < image.length; i++) {
for(int j = i + 1; j < image[i].length; j++) {
int tmp = image[i][j];
image[i][j] = image[j][i];
image[j][i] = tmp;
}
}
}
​
```