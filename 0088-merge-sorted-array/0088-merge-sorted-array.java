class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] temp = new int[m+n];
        int i=0,k=0,j =0;
        while(i<m && j<n){
            if(nums1[i]<nums2[j]){
                temp[k++] = nums1[i];
                i++;
            }
            else{
                temp[k++] = nums2[j];
                j++;
            }
        }
        while(i<m){
            temp[k++] = nums1[i++];
        }
        while(j<n){
            temp[k++] = nums2[j++];
        }
        for(int o =0; o<nums1.length ; o++){
            nums1[o] = temp[o];
        }
    }
}