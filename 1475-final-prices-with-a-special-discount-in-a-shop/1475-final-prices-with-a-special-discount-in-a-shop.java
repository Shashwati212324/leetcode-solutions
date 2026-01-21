class Solution {
    public int[] finalPrices(int[] prices) {
        Stack<Integer> stack = new Stack<>();
        int[] ans= prices;

        for(int i =0; i<prices.length; i++){
            while(!stack.isEmpty() && prices[i]<=prices[stack.peek()]){
                int index = stack.pop();
                ans[index]= prices[index]-prices[i];
            }
            stack.push(i);
        }
        return ans;
    }
}