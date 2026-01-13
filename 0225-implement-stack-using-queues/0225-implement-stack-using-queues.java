import java.util.LinkedList;
import java.util.Queue;

class MyStack {
    static class Queue{
        int[] arr= new int [100];
        int front=0, rear=0;

        public void enqueue(int x){
            arr[rear++]=x;
        }
        public int dequeue(){
            return arr[front++];
        }
        public boolean isEmpty(){
            return front==rear;
        }
        public int size(){
            return rear-front;
        }
        public int peek(){
            return arr[front];
        }
    }
    Queue q= new Queue();
    public void push(int x){
        int size=q.size();
        q.enqueue(x);
        for(int i =0; i<size;i++){
            q.enqueue(q.dequeue());
        }
    }
    public int pop(){
        return q.dequeue();
    }
    public int top(){
        return q.peek();
    }
    public boolean empty(){
        return q.isEmpty();
    }
    
}


/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */