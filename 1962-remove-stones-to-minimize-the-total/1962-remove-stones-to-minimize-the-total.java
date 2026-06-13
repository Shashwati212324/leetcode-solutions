class Solution {
    public int minStoneSum(int[] piles, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int total =0;
        for(int num : piles){
            pq.offer(num);
            total += num;
        }
        for(int x = 1;x<=k;x++){
            int largest = pq.poll();

            int removed = largest / 2;

            total -= removed;

            pq.offer(largest - removed);
        }
        return total;
        
    }
    
}