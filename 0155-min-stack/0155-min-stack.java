class MinStack {
    private int[] data;
    private int[] minData;
    private int ptr;

    public MinStack() {
        data = new int[1000];
        minData = new int[1000];
        ptr = -1;
    }
    
    public void push(int val) {
        if(ptr == data.length-1)return;
        data[++ptr] = val;
        if (ptr == 0) {
            minData[ptr] = val;
        } else {
            minData[ptr] = Math.min(val, minData[ptr - 1]);
        }
    }
    
    public void pop() {
        if(ptr == -1){
            return;
        }
        ptr--;
    }
    
    public int top() {
        if(ptr == -1){
            return -1;
        }
        return data[ptr];
        
    }
    
    public int getMin() {
        if (ptr == -1) return -1;
        return minData[ptr];
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */