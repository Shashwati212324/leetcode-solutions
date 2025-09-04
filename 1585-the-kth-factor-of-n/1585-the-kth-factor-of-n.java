class Solution {
    public int kthFactor(int n, int k) {
      ArrayList<Integer> list = new ArrayList<>();
      for(int i =1; i*i<=n;i++){
        if(n%i == 0){
            if(n/i != i){
                list.add(n/i);
            }    
            list.add(i);    
        }
      }
      int[] ar = new int[list.size()];
      for(int i =0; i<ar.length ; i++){
        ar[i] = list.get(i);
      }
      Arrays.sort(ar);
      int ans= -1;
      if(k<=ar.length){
        ans = ar[k-1];
      }
      return ans;

    }
}