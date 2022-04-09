// { Driver Code Starts
import java.util.LinkedList; 
import java.util.Queue; 
import java.io.*;
import java.util.*;

class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
}

class GfG {
    
    static Node buildTree(String str){
        
        if(str.length()==0 || str.charAt(0)=='N'){
            return null;
        }
        
        String ip[] = str.split(" ");
        // Create the root of the tree
        Node root = new Node(Integer.parseInt(ip[0]));
        // Push the root to the queue
        
        Queue<Node> queue = new LinkedList<>(); 
        
        queue.add(root);
        // Starting from the second element
        
        int i = 1;
        while(queue.size()>0 && i < ip.length) {
            
            // Get and remove the front of the queue
            Node currNode = queue.peek();
            queue.remove();
                
            // Get the current node's value from the string
            String currVal = ip[i];
                
            // If the left child is not null
            if(!currVal.equals("N")) {
                    
                // Create the left child for the current node
                currNode.left = new Node(Integer.parseInt(currVal));
                // Push it to the queue
                queue.add(currNode.left);
            }
                
            // For the right child
            i++;
            if(i >= ip.length)
                break;
                
            currVal = ip[i];
                
            // If the right child is not null
            if(!currVal.equals("N")) {
                    
                // Create the right child for the current node
                currNode.right = new Node(Integer.parseInt(currVal));
                    
                // Push it to the queue
                queue.add(currNode.right);
            }
            i++;
        }
        
        return root;
    }
    
	public static void main (String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int t=Integer.parseInt(br.readLine());
        
        while(t > 0){
            String line = br.readLine().trim();
            Node root = buildTree(line);
            
            line = br.readLine().trim();
            String target_k[] = line.split(" ");
            int target = Integer.parseInt(target_k[0]);
            int k = Integer.parseInt(target_k[1]);
            
            solver x = new solver();
            System.out.println( x.sum_at_distK(root, target, k) );
            t--;
        }
    }
}

// } Driver Code Ends


/*
// node structure:

class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
}

*/
class solver{
    static Node res=new Node(-1);
    static int sum_at_distK(Node root, int target, int k){
        // code here
        HashMap<Node,Node> parent=new HashMap<>();
        
        dfs(root,parent,target);
        HashMap<Node,Boolean> visited=new HashMap<>();
        Queue<Node> q=new LinkedList<>();
        q.offer(res);
        int sum=target;
        visited.put(res,true);
        int count=0;
        while(!q.isEmpty()){
           int size=q.size();
           if(count==k) break;
           for(int i=0; i<size; i++){
               Node node=q.poll();
               if(node.left!=null && visited.get(node.left)==null){
                   q.offer(node.left);
                   visited.put(node.left,true);
                   sum+=node.left.data;
               }
                if(node.right!=null && visited.get(node.right)==null){
                   q.offer(node.right);
                    visited.put(node.right,true);
                   sum+=node.right.data;
               }
                if(parent.get(node)!=null && visited.get(parent.get(node))==null){
                   q.offer(parent.get(node));
                    visited.put(parent.get(node),true);
                   sum+=parent.get(node).data;
               }
           }
           count++;
           
        }
        // System.out.println(parent.get(root.left.left.right.right).data);
        return sum;
    }
    static void dfs(Node root,HashMap<Node,Node> parent,int target){
        if(root==null) return;
        if(root.data==target) res=root;
        if(root.left!=null) parent.put(root.left,root);
        if(root.right!=null) parent.put(root.right,root);
        dfs(root.left,parent,target);
        dfs(root.right,parent,target);
    }
}

