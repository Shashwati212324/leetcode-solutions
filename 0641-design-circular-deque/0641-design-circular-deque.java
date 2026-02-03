class MyCircularDeque {
    LinkedList<Integer> list;
    int capacity;

    public MyCircularDeque(int k) {
        list = new LinkedList<>();
        capacity = k;
    }
    
    public boolean insertFront(int value) {
        if (isFull()) return false;
        list.addFirst(value);
        return true;
    }
    
    public boolean insertLast(int value) {
        if (isFull()) return false;
        list.addLast(value);
        return true;
    }
    
    public boolean deleteFront() {
        if (isEmpty()) return false;
        list.removeFirst();
        return true;
    }
    
    public boolean deleteLast() {
        if (isEmpty()) return false;
        list.removeLast();
        return true;
    }
    
    public int getFront() {
        if (isEmpty()) return -1;
        return list.getFirst();
    }
    
    public int getRear() {
        if (isEmpty()) return -1;
        return list.getLast();
    }
    
    public boolean isEmpty() {
        return list.isEmpty();
    }
    
    public boolean isFull() {
        return list.size() == capacity;
    }
}
