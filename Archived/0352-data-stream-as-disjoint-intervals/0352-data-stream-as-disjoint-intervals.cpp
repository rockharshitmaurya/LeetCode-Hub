class SummaryRanges
{
    public:
        int maxi = 0;
    int arr[(int) 1e4 + 1] = { 0 };
    SummaryRanges() {}

    void addNum(int value)
    {
        arr[value]++;
        maxi = max(maxi, value + 5);
        // for (int i = value; i <= value+1; i++)
        // {
        //     arr[i] += arr[i - 1];
        // }
        // for (int i = 0; i <= maxi; i++)
        // {
        //     cout << arr[i] << " ";
        // }
        // cout << "\n";
    }

    vector<vector < int>> getIntervals()
    {
        vector<vector < int>> ans;
        int psum = 0;
        int start = -1;
        for (int i = 0; i <= maxi; i++)
        {
            if (arr[i] != 0 && start == -1)
            {
                start = i;
            }

            if (arr[i] == 0 && start != -1)
            {
                vector<int> temp;
                temp.push_back(start);
                temp.push_back(i - 1);
                ans.push_back(temp);
                start = -1;
            }
        }
        return ans;
    }
};

/**
 *Your SummaryRanges object will be instantiated and called as such:
 *SummaryRanges* obj = new SummaryRanges();
 *obj->addNum(value);
 *vector<vector < int>> param_2 = obj->getIntervals();
 */