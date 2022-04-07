// { Driver Code Starts
import java.util.*;
import java.io.*;

class GFG
{
    public static void main (String[] args)
    {
        Scanner sc = new Scanner(System.in);
        // int arr[] = new int[10000];
        
        int t = sc.nextInt();
        
        while(t-->0)
        {
            int n = sc.nextInt();
            int arr[]=new int[n];
            for(int i=0; i<n; i++)
            {
                arr[i] = sc.nextInt();
            }
            
            solver x = new solver();
            int res[]=x.print_next_greater_freq(arr,n);
            StringBuffer sb=new StringBuffer("");
            for(int i : res){
                sb.append(i+" ");
            }
            System.out.println(sb);
        }
    }
}
// } Driver Code Ends


class solver
{
    static int[] print_next_greater_freq(int arr[], int n)
    {
    HashMap<Integer,Integer> map=new HashMap<>();
    for(int num:arr){
        map.put(num,map.getOrDefault(num,0)+1);
    }
    
    for(int i=0; i<n; i++){
       int freq=map.get(arr[i]);
       int ans=-1;
       int j=i+1;
       while(j<n){
           if(map.get(arr[j])>freq){
               ans=arr[j];
               break;
           }
           j++;
       }
       arr[i]=ans;
    }
     return arr;   
    }
}

