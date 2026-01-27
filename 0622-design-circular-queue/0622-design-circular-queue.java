class MyCircularQueue {

    private int[] q;
    private int front, rear, count, capacity;

    public MyCircularQueue(int k) {
        q = new int[k];
        capacity = k;
        front = 0;
        rear = 0;
        count = 0;
    }

    public boolean enQueue(int value) {
        if (count == capacity) {
            return false; // full
        }
        q[rear] = value;
        rear = (rear + 1) % capacity;
        count++;
        return true;
    }

    public boolean deQueue() {
        if (count == 0) {
            return false; // empty
        }
        front = (front + 1) % capacity;
        count--;
        return true;
    }

    public int Front() {
        if (count == 0) return -1;
        return q[front];
    }

    public int Rear() {
        if (count == 0) return -1;
        return q[(rear - 1 + capacity) % capacity];
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public boolean isFull() {
        return count == capacity;
    }
}
