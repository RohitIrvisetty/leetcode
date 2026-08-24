class BrowserHistory {
    Stack<String> history;
    Stack<String> forward;
    String current;

    public BrowserHistory(String homepage) {
        history = new Stack<>();
        forward = new Stack<>();
        current = homepage;
    }
    
    public void visit(String url) {
        forward = new Stack<>();

        history.push(current);
        current = url;
    }
    
    public String back(int steps) {
        
        while (steps-- > 0 && !history.isEmpty()) {
            forward.push(current);
            current = history.pop();
        }

        return current;
    }
    
    public String forward(int steps) {
        
        while(steps-- > 0 && !forward.isEmpty()) {
            history.push(current);
            current = forward.pop();
        }
        return current;
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */