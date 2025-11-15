class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> a = new ArrayList<>();
        combination(1,n,k,new ArrayList<>(),a);
        return a;
    }
    public static void combination(int start, int n, int k,List<Integer> temp, List<List<Integer>> ans){
        if(temp.size()==k){
            ans.add(new ArrayList<>(temp));
            return;
        }
        for(int i =start; i<=n; i++){
            temp.add(i);
            combination(i+1,n,k,temp, ans);
            temp.remove(temp.size()-1);
        }
    }
}