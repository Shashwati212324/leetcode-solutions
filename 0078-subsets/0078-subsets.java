class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<Integer> arl = new ArrayList<>();
        return subsetArray(nums, arl, 0);
    }
    public List<List<Integer>> subsetArray(int[] arr, List<Integer> arl, int i ) {
        List<List<Integer>> ar= new ArrayList<>();
        if(i == arr.length){
            ar.add(new ArrayList<>(arl));
            return ar;
        }
        arl.add(arr[i]);
        ar.addAll(subsetArray(arr,arl,i+1));
        arl.remove(arl.size()-1);
        ar.addAll(subsetArray(arr,arl,i+1));
        return ar;
    }
}