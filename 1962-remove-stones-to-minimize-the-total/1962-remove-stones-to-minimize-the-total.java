class Solution {
    public int minStoneSum(int[] piles, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int num : piles){
            pq.offer(num);
        }
        int total = sum(piles);
        for(int x = 1;x<=k;x++){
            int largest = pq.poll();

            int removed = largest / 2;

            total -= removed;

            pq.offer(largest - removed);
        }
        return total;
        
    }
    private int sum(int[] arr){
        int tot = 0;
        for(int num: arr)tot+= num;
        return tot;
    }
}