class BrowserHistory {
    Deque<String> history;
    Deque<String> forward;
    String current;

    public BrowserHistory(String homepage) {
        history = new ArrayDeque<>();
        forward = new ArrayDeque<>();
        current = homepage;
    }
    
    public void visit(String url) {
        forward = new ArrayDeque<>();

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