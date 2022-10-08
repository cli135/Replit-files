class Solution {
    // accepted 201ms
    public int characterReplacement(String s, int k) {
        int[] cache = new int[256]; // frequency histogram
        // both l and r inclusive -- seems to work well
        int l = 0;
        int r = 0;
        // AABABBAABA
        // ^  ^
        int max = 0;
        boolean same = false;
        // sliding window two pointers - both starting from left
        while (l < s.length() && r < s.length()) {
            // same flag avoids adding r char twice
            // after we move up the l pointer
            if (!same) {
                char d = s.charAt(r);
                cache[d]++; // increment count in histogram
            }
            // checking if we can replace all of the characters
            // that are not the plurality in the array
            if (canReplaceInSubarray(cache, k)) {
                // this whole subarray here can be
                // turned into one singular character
                max = Math.max(max, r - l + 1);
                // move the right marker of the window right
                r++;
                same = false;
            }
            else {
                // move the left marker of the window right
                char c = s.charAt(l);
                cache[c]--; // remove that particular char from cache
                l++; // move left flag over
                same = true;
            }
            
        }
        return max;
    }
    private boolean canReplaceInSubarray(int[] cache, int k) {
        // finding the plurality character in this array
        int maxIdx = 0;
        for (int i = 0; i < cache.length; i++) {
            if (cache[i] > cache[maxIdx]) {
                maxIdx = i;
            }
        }
        // then checking to see if we can replace all of the
        // other characters that are not the plurality character
        // in this array
        for (int i = 0; i < cache.length; i++) {
            if (i != maxIdx) {
                k -= cache[i]; // see if you can convert
                // all of the non max chars into the
                // actual max freq char
            }
        }
        return k >= 0; // do we have enough to convert
        // the whole subarray into one of a kind
        // by turning them all into the plurality character
    }
}
