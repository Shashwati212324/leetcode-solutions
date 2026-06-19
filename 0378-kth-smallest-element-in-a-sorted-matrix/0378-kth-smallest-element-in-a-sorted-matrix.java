// BASIC
// class Solution {
//     public int kthSmallest(int[][] matrix, int k) {
//         PriorityQueue<Integer> pq = new PriorityQueue<>();
//         // for(int i =0;i<matrix.length; i++){
//         //     for(int num : matrix[i]){
//         //         pq.offer(num);
//         //     }
//         // }

//         // for(int i = 1; i<k;i++)pq.poll();
//         // return pq.peek();

//     }    
// }

class Solution {

    public int kthSmallest(int[][] matrix, int k) {

        int n = matrix.length;

        PriorityQueue<int[]> pq =
            new PriorityQueue<>(
                (a,b) -> a[0] - b[0]
            );

        for(int row = 0; row < n; row++) {

            pq.offer(
                new int[]{
                    matrix[row][0],
                    row,
                    0
                }
            );
        }

        while(k > 1) {

            int[] curr = pq.poll();

            int row = curr[1];
            int col = curr[2];

            if(col + 1 < n) {

                pq.offer(
                    new int[]{
                        matrix[row][col + 1],
                        row,
                        col + 1
                    }
                );
            }

            k--;
        }

        return pq.peek()[0];
    }
}