// { Driver Code Starts
#include <bits/stdc++.h>
using namespace std;


 // } Driver Code Ends
//User function Template for C++

class Solution{
public:
    string LCP(string ar[], int n)
    {
        // code here
        sort(ar,ar+n);
        string temp=ar[0];
        for(int i=1;i<n;i++)
        {
            string comp=ar[i];
            for(int j=0;j<temp.size();j++)
            {
                if(temp[j]!=comp[j])
                {
                    temp=temp.substr(0,j);
                }
            }
        }
        return temp==""?"-1":temp;
    }
};

// { Driver Code Starts.

int main() 
{

	int t;
	cin>>t;
	while(t--)
	    {
	        int n;
	        cin>>n;
	        string arr[n];
	        for(int i = 0;i<n;i++)
	            cin>>arr[i];
	        Solution ob;
	        cout<<ob.LCP(arr,n)<<endl;
	    }
	return 0;
}  // } Driver Code Ends