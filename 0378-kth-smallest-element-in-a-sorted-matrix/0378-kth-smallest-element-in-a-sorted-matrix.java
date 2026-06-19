class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i =0;i<matrix.length; i++){
            for(int num : matrix[i]){
                pq.offer(num);
            }
        }

        for(int i = 1; i<k;i++)pq.poll();
        return pq.peek();
    }
}