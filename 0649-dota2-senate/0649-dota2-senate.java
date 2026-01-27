class Solution {
    public String predictPartyVictory(String senate) {
        Queue<Integer> radiant = new ArrayDeque<>();
        Queue<Integer> dire = new ArrayDeque<>();


        for(int i=0;i<senate.length();i++){
            if(senate.charAt(i)==('R')){
                radiant.offer(i);
            }
            else{
                dire.offer(i);
            }
        }
        int n= senate.length();
        while(!radiant.isEmpty() && !dire.isEmpty()){
            if(radiant.peek() < dire.peek()){
                dire.poll();
                n= n+1;
                radiant.poll();
                radiant.offer(n);
            }else{
                radiant.poll();
                n=n+1;
                dire.poll();
                dire.offer(n);
            }
        }
        if(!dire.isEmpty())return "Dire";
        return "Radiant";
    }
}
