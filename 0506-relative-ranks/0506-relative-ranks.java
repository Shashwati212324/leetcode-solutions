class Solution {
    public String[] findRelativeRanks(int[] score) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        HashMap<Integer, Integer> map = new HashMap<>();
        String[] answer = new String[score.length];
        for(int i =0; i<score.length;i++){
            pq.offer(score[i]);
            map.put(score[i],i);
        }
        int rank = 1;
        
        while(!pq.isEmpty()){
            int val = pq.poll();
            int index = map.get(val);

            if(rank == 1){
                answer[index] = "Gold Medal";
                rank++;
            }
            else if(rank == 2){
                answer[index] = "Silver Medal";
                rank++;
            }
            else if(rank == 3){
                answer[index] = "Bronze Medal";
                rank++;
            }
            else{
                answer[index] = rank+"";
                rank++;
            }
        }
        return answer;

    }
}