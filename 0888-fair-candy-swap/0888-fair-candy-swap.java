class Solution {
    public int[] fairCandySwap(int[] aliceSizes, int[] bobSizes) {
        HashSet<Integer> set = new HashSet<>();
        int sumA =0, sumB =0;
        for(int i =0; i<aliceSizes.length ; i++){
            sumA+=aliceSizes[i];
        }
        for(int i =0; i<bobSizes.length ; i++){
            sumB+=bobSizes[i];
        }
        int diff = (sumA-sumB)/2;
        HashSet<Integer> Aset = new HashSet<>();
        HashSet<Integer> Bset = new HashSet<>();

        for(int b: bobSizes){
            Bset.add(b);
        }
        for(int a : aliceSizes){
            int y = a-diff;
            if(Bset.contains(y)){
                return new int[]{a,y};
            }
        }
        return new int[0];
    }
}