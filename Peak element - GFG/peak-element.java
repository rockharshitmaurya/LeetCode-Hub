// { Driver Code Starts
import java.util.*;
class PeakElement{
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		while(t-->0){
			int n=sc.nextInt();
			int[] a=new int[n];
		    int[] tmp=new int[n];
			for(int i=0;i<n;i++){
				a[i]=sc.nextInt();
				tmp[i] = a[i];
			}
		    
		    int f=0;
			int A=(new Solution()).peakElement(tmp,n);
			
			if(A<0 && A>=n)
			    System.out.println(0);
			else
			{
    			if(n==1 && A==0)
    			    f=1;
    			else if(A==0 && a[0]>=a[1])
    			    f=1;
    			else if(A==n-1 && a[n-1]>=a[n-2])
    			    f=1;
    			else if(A >= 0 && A < n && a[A] >=a[A+1] && a[A]>= a[A-1])
    			    f=1;
    			else
    			    f=0;
			    System.out.println(f);
			}
		}
	}
}// } Driver Code Ends


/*Complete the function below*/

class Solution
{
	// Function to find the peak element
	// arr[]: input array
	// n: size of array a[]
	public int peakElement(int[] arr,int n)
    {
       if(n==1) return 0; 
       int low=0,high=n-1;
       while(low<=high){
           int m=low+(high-low)/2;
           if(m>0 && m<n-1){
             if(arr[m]>arr[m-1] && arr[m]>arr[m+1]){
               return m;  
             }else if(arr[m]<=arr[m-1]){
                 high=m-1;
             }else{
                 low=m+1;
             }   
           }else if(m==0){
               if(arr[m]>arr[m+1]) return 0;
              else return 1;
           }else if(m==n-1){
               if(arr[n-1]>arr[n-2]) return n-1;
              else return n-2;
           }
           
        
       }
        return 0;
    }
}