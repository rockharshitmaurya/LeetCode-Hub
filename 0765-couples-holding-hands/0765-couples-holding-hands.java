class Solution {
    int arr[] = new int[100];

    public int minSwapsCouples(int[] row) {
        for (int i = 0; i < row.length; i++) {
            arr[row[i]] = i;
        }

        int ans = 0;

        for (int i = 0; i < row.length; i += 2) {
            if (row[i] % 2 == 0 && row[i] + 1 == row[i + 1]) {
                continue;
            }

            if (row[i] % 2 == 1 && row[i] - 1 == row[i + 1]) {
                continue;
            }

            if (row[i] % 2 == 0) {
                
                int next_val=row[i+1];
                int target_val=row[i]+1;
                
                
                int next_idx = arr[next_val];
                int target_idx = arr[target_val];
                                     
                
                // System.out.println(target_idx+" "+next_idx+" "+i);

                int temp = row[next_idx];
                row[next_idx] = row[target_idx];
                row[target_idx] = temp;

                arr[next_val] = target_idx;
                arr[target_val] = next_idx;
                                     
                // System.out.println(Arrays.toString(row));
            } else if (row[i] % 2 == 1) {
                int next_val=row[i+1];
                int target_val=row[i]-1;
                
                
                int next_idx = arr[next_val];
                int target_idx = arr[target_val];
                                     
                
                // System.out.println(target_idx+" "+next_idx+" "+i);

                int temp = row[next_idx];
                row[next_idx] = row[target_idx];
                row[target_idx] = temp;

                arr[next_val] = target_idx;
                arr[target_val] = next_idx;
                                     
                // System.out.println(Arrays.toString(row));
            }

            ans++;
        }
        // System.out.println(Arrays.toString(row));
        return ans;
    }
}

// [0,1,7,6,2,3,4,5]
// [0,3,7,4,2,5,6,1]