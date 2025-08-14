class BrowserHistory {
    private class Node{
        String url;
        Node next, prev;
        Node(String url){
            this.url =url;
        } 
    }
    private Node current;
    public BrowserHistory(String homepage) {
        current = new Node(homepage);
    }
    
    public void visit(String url) {
        Node node = new Node(url);
        current.next = node;//drop forward history
        node.prev = current;
        current =node;
    }
    
    public String back(int steps) {
        for(int i =0; i<steps&&current.prev!=null; i++){
            current = current.prev;
        }
        return current.url;
    }
    
    public String forward(int steps) {
        for(int i =0; i<steps&&current.next!=null; i++){
            current = current.next;
        }
        return current.url;
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */