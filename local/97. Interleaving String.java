class Solution {
    static String s1;
    static String s2;
    static String s3;
    public boolean isInterleave(String s1, String s2, String s3) {
        Solution.s1 = s1;
        Solution.s2 = s2;
        Solution.s3 = s3;
        // memoization below
        return isInterleave(0, 0);
        // what if we just did dp grid [m + 1][n + 1]
        // and did two for loops
        
        // ground up dynamic programming
        
        
    }
    
    
    
    // read only globals
    
    // k == i + j
    
    // memoization below
    // Success
// Details 
// Runtime: 60 ms, faster than 5.11% of Java online submissions for Interleaving String.
// Memory Usage: 54.5 MB, less than 6.73% of Java online submissions for Interleaving String.

    
    // for the hashmap cache key
    // imma do strings like "abcd,abcd" instead of indices "4,4"
    // in the case that strings appear as substrings elsewhere
    // well they wouldn't they would only be at that one place
    // because of their length and their last index rooting them there
    // but whatever I like it like this for now
    
    // memoization actually works dangggg
    // i guess it's like
    // b
    // bbbbbbb
    // and
    // bbbbbbb
    // b
    // will eventually reach
    // bbbbbbb
    // bbbbbbb
    // which is just cached from that point on to the end
    // bbbbbbbbbbbbbb
    // bbbbbbbbbbbbbb
    // so there is no wasted computation from that point on
    // and this applies all the way down the line,
    // so i guess there was repeated work being done
    // if i were to draw out the recursion tree
    // 
    
    // memo cache
    HashMap<String, Boolean> cache = new HashMap<>();
    private boolean isInterleave(int i, int j) {
        if (cache.containsKey(s1.substring(i) + "," + s2.substring(j))) {
            return cache.get(s1.substring(i) + "," + s2.substring(j));
        }
        // have to have three checks:
        // you made it successfully to the end of s3, s2, and s1
        if (i + j >= s3.length() && i >= s1.length() && j >= s2.length()) {
            // no need to cache base case
            // caching is primarily to disrupt a long recursive
            // chain, so we do it right after we run that chain
            // for the first time
            return true;
        }
        
        // recursive case
        boolean b1 = false; // init
        // short circuit evaluation is key here
        // indexing checks
        if (i < s1.length() && (i + j) < s3.length() && s1.charAt(i) == s3.charAt(i + j)) {
            // advance one in i and k
            b1 = isInterleave(i + 1, j);
            // quick follow up cache -- good place to cache
            cache.put(s1.substring(i + 1) + "," + s2.substring(j), b1);
        }
        
        // check if we can advance one in s2 with j
        // indexing checks
        boolean b2 = false; // init
        if (j < s2.length() && (i + j) < s3.length() && s2.charAt(j) == s3.charAt(i + j)) {
            // advance one in j and k
            b2 = isInterleave(i, j + 1);
            // this is a good place to put it
            cache.put(s1.substring(i) + "," + s2.substring(j + 1), b2);
        }
        
        // as long as one turned out okay, we are good
        // we just need at least one path
        
        return b1 || b2;
    }
}
