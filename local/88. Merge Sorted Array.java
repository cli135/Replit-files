class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // a is deep copy for the first part of nums1
        // we will directly overwrite nums1 now with
        // merged array 
        int[] a = new int[m];
        for (int i = 0; i < m; i++) {
            a[i] = nums1[i];
        }
        int[] b = nums2;
        
        // count is pointer in the merged array
        int count = 0;
        // pointers for a and b
        int i = 0;
        int j = 0;
        // index checking and also while we still
        // need more elements in the merged array
        while (i < m && j < n && count < m + n) {
            // equal case, add both and advance
            // both pointers
            if (a[i] == b[j]) {
                nums1[count++] = a[i++];
                nums1[count++] = b[j++];
            }
            // add the min and advance that pointer
            else if (a[i] < b[j]) {
                nums1[count++] = a[i++];
            }
            else { // (a[i] > b[j])
                nums1[count++] = b[j++];
            }
        }
        // if there are leftover ends,
        // we want to fill in the gaps
        // at the end of the merged array
        // with whatever remains (whichever
        // didn't reach the end first, i or j)
        while (count < m + n) {
            if (i == m) {
                // add remaining j's
                nums1[count++] = b[j++];
            }
            else {
                // add remaining i's
                nums1[count++] = a[i++];
            }
        }
        // array merged successfully
        return;
    }
}
