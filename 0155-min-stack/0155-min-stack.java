class MinStack {

    private long[] stack;
    private int top;
    private long min;

    public MinStack() {
        stack = new long[30000];
        top = -1;
    }

    public void push(int val) {
        if (top == -1) {
            stack[++top] = val;
            min = val;
        } else if (val < min) {
            stack[++top] = 2L * val - min;  // encode
            min = val;
        } else {
            stack[++top] = val;
        }
    }

    public void pop() {
        long popped = stack[top--];
        if (popped < min) {
            min = 2 * min - popped;
        }
    }

    public int top() {
        if (stack[top] < min) {
            return (int) min;
        }
        return (int) stack[top];
    }

    public int getMin() {
        return (int) min;
    }
}
