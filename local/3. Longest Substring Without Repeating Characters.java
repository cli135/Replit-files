class Solution {
    
    // accepted 29ms
    // memory 42mb beats 98.49%
    public int lengthOfLongestSubstring(String s) {
        int l = 0;
        int r = 0;
        int maxLen = 0;
        int[] cache = new int[256];
        boolean same = false;
        
        // lesson learned: look before you leap logic
        // is really not great, because the whole idea of
        // recursion or iteration is that each stack call
        // or iteration takes care of only what it's supposed
        // to do, and nothing more, nothing less
        // forming a partition of the entire task space.
        // when you start doing off-by-one look-before-you-leap
        // logic, the off-by-one accumulates or at least
        // propagates and it becomes very complicated to reason
        // about lots of future generations (adjusting indices,
        // null checks in binary trees, etc.) and there is
        // too much foresight required.
        // it is much better to just focus on one iteration.
        // you can use a boolean flag to signal what to do for the
        // next iteration, a sort of fake 'look before you leap'
        // which is much better for indices out of bounds checking
        // and null checks and validation and these sorts of things.
        while (l < s.length() && r < s.length()) {
            
            // avoid adding the same thing again,
            // after we moved up left
            if (!same) {
                char d = s.charAt(r);
                cache[d]++;
            }
            
            if (!containsDuplicate(cache)) {
                // order of statements matters
                maxLen = Math.max(r - l + 1, maxLen); // max check cur len
                r++; // increase boundary
                same = false; // consume next char
            }
            else {
                // move up the left char
                char c = s.charAt(l);
                cache[c]--; // remove from cache (that char in particular)
                l++; // move up left pointer
                same = true; // we will see the r same again
                // and we don't want to add that again / twice
                
                // go intellij debugging!!!
            
                // jump doesn't work:
                // counterexample: "dvdf" - we skip the v
                // l = r;
                // cache = new int[256];
            }
        }
        return maxLen;
    }
    // O(1) check over 256 elements in cache
    // to see if any are >= 2. it's a frequency histogram
    // so anything >= 2 means that there is a duplicated letter
    // (or ascii char, generally speaking)
    private boolean containsDuplicate(int[] cache) {
        for (int amt : cache) {
            if (amt >= 2) {
                return true;
            }
        }
        return false;
    }
    
    // i don't know if this works, probably not, it was my first attempt
    // earlier
    public int lengthOfLongestSubstring1(String s) {
        
        if (s.length() == 1) {
            return 1;
        }
        
        
        int[] cache = new int[256];
        for (int i = 0; i < cache.length; i++) {
            cache[i] = -1; // to init, char not found in array
            // to begin with
        }
        int cur = 0;
        int longest = 0;
        for (int i = 0; i < s.length(); i++) {
            // basically an O(N) linear traversal
            // keeping a 256 ascii cache of where
            // we last saw each character, and updating it
            // when we see a repeat. with this information
            // it should be enough to calculate longest
            // contiguous streaks of unique characters
            // in between
            char character = s.charAt(i);
            
            if (cache[character] != -1) {
                // already encountered earlier
                // basically the streak is from cache[character] to your current index - 1
                cur = i - cache[character];
                if (cur > longest) {
                    longest = cur;
                }
            }
            
            cache[character] = i;
            
            // cur++;
            
            
        }
        if (longest == 0 && s.length() > 0) {
            return s.length();
        }
        return longest;
    }
    
    // code below doesn't work
    /*
    public int lengthOfLongestSubstring(String s) {
        int max = 1;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j < s.length(); j++) {
                if (noRepeats(s.substring(i, j))) {
                    max = j - i;
                }
            }
        }
        return max;
    }
    private boolean noRepeats(String s) {
        HashSet<Character> set = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            if (set.contains(s.charAt(i))) {
                return false;
            }
            set.add(s.charAt(i));
        }
        return true;
    }
    */
}
