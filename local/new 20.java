class Solution {
    public boolean isCovered(int[][] ranges, int left, int right) {
        if (left <= right) {
            // search for left in ranges
            for (int[] range : ranges) {
                if (range.length >= 2 && range[0] <= left && left <= range[1]) {
                        // found it, keep on searching
                        return isCovered(ranges, left + 1, right);
                }
            }
            // nope not found this one
            return false;
        }
        else {
            // yep we made it to the end, finding everything!
            return true;
        }
    }
}