class StockSpanner {
    //AP 1 - stack

    // Stack<int[]> stack;
    // public StockSpanner() {
    //     stack = new Stack<>();       
    // }
    // public int next(int price) {
    //     int span=1;
    //     while(!stack.isEmpty() && stack.peek()[0]<=price){
    //         span+=stack.peek()[1];
    //         stack.pop();            
    //     }
    //     stack.push(new int[]{price,span});
    //     return span;

    //AP - 2 - ArrayList
    ArrayList<Integer> ar;

    public StockSpanner() {
        ar= new ArrayList<>();
    }
    public int next(int price) {
        
        ar.add(price);
        int span = 1;
        for(int i=ar.size()-2;i>=0;i--){
            if(ar.get(i)<=price){
                span++;
            }
            else{
                break;
            }
        }
        return span;


    }   
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */