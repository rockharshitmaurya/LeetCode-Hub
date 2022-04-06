class BrowserHistory {
    Stack<String> visit=new Stack<>();
    Stack<String> fwd=new Stack<>();
    public BrowserHistory(String homepage) {
       visit.push(homepage); 
    }
    
    public void visit(String url) {
        visit.push(url);
        fwd=new Stack<>();
    }
    
    public String back(int steps) {
        while(steps-->0 && visit.size()>1){
            fwd.push(visit.pop());
        }
        return visit.peek();
    }
    
    public String forward(int steps) {
        while(steps-->0 && fwd.size()>0){
            visit.push(fwd.pop());
        }
        
        return visit.peek(); 
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */