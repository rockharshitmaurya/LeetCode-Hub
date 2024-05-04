class Solution
{
    public:
        void sortColors(vector<int> &arr)
        {
            int count_0 = 0, count_1 = 0, count_2 = 0;
            int n=arr.size();
            for (int i = 0; i < n; i++)
            {
                if (arr[i] == 0)
                    count_0++;
                else if (arr[i] == 1)
                    count_1++;
                else
                    count_2++;
            }
            int index = 0;
            while (count_0--)
                arr[index++] = 0;
            while (count_1--)
                arr[index++] = 1;
            while (count_2--)
                arr[index++] = 2;
            for (int i = 0; i < n; i++)
                cout << arr[i] << " ";
        }
};