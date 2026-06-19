class Solution {
    public int findKthLargest(int[] nums, int k) {
        //without sorting - heap
        PriorityQueue<Integer> pq;
        int l = nums.length;
        if(k<l/2){
            pq = new PriorityQueue<>(Collections.reverseOrder());
            for(int num : nums)
                pq.offer(num);

            for(int i = 1; i < k; i++)
                pq.poll();

            return pq.peek();
        }
        else{
            pq = new PriorityQueue<>();
            for(int num:nums){
                pq.offer(num);
            }

            for(int i =0 ;i<l-k;i++){
                pq.poll();
            }
            return pq.peek();
        }
        

        
        



        //done with sortin - quick sort
        // int high=nums.length-1, low = 0;
        // quicksort(nums, low, high);

        // return nums[nums.length - k];
        
    }
    public void quicksort(int[] nums, int low, int high){
        if(low>=high)return;
        int s=low, e=high;
        int mid= (low+high)/2;
        int pivot = nums[mid];

        while(s<=e){
            while(nums[s]<pivot)s++;
            while(nums[e]>pivot)e--;

            if(s<=e){
                int temp= nums[s];
                nums[s]=nums[e];
                nums[e]=temp;
                s++;
                e--;
            }
        }
        quicksort(nums, low, e);
        quicksort(nums, s, high);
    }
    
}