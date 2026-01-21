class Solution {
    public int countStudents(int[] students, int[] sandwiches) {

        //int[] count = new int[2];

        // // Count students' preferences
        // for (int s : students) {
        //     count[s]++;
        // }

        // // Process sandwiches
        // for (int s : sandwiches) {
        //     if (count[s] == 0) {
        //         break;   // no student wants this sandwich
        //     }
        //     count[s]--;
        // }

        // return count[0] + count[1];

        //Stack+Queue

        Queue<Integer> q = new LinkedList<>();
        Stack<Integer> stack= new Stack<>();

        for(int s:students){
            q.offer(s);
        }
        for (int i = sandwiches.length - 1; i >= 0; i--) {
    stack.push(sandwiches[i]);
}
        int rot=0;
        while(!q.isEmpty()&&rot<q.size()){
            if(q.peek().equals(stack.peek())){
                q.poll();
                stack.pop();
                rot=0;
            }else{
                q.offer(q.poll());
                rot++;
            }
        }
        return q.size();
    }
}
