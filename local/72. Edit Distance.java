class Solution {
    public int minDistance(String word1, String word2) {
        // if (word1.equals(word2)) {
        //     return 0;
        // }
        // otherwise, return the edit distance between the two words
        // the removes and add's don't really(?)
        // affect the order in which they are done
        // so maybe you can just add and remove in any order, but not sure
        
        // what if you did longest common subsequence
        // and just looked for differences
        // yeah but it wouldn't account for replaces, only for
        // insertions and deletions
        
        // ok some dp grid stuff might work
        int[][] dp = new int[word1.length() + 1][word2.length() + 1];
        // bottom and right layers are padded with base case values
        // all insertions starting from empty string
        // bottom layer
        for (int i = 0; i < word1.length() + 1; i++) {
            // 5, 4, 3, 2, 1, 0
            dp[i][word2.length()] = word1.length() - i;
        }
        // left layer
        for (int j = 0; j < word2.length() + 1; j++) {
            // 3, 2, 1, 0
            dp[word1.length()][j] = word2.length() - j;
        }
        // cool, now we are applying the dp rule
        // pretty sure it is greedy but we will see
        for (int i = word1.length() - 1; i >= 0; i--) {
            for (int j = word2.length() - 1; j >= 0; j--) {
                // traversing from bottom right
                // towards the top left of the dp grid
                if (word1.charAt(i) == word2.charAt(j)) {
                    // they are the same
                    // we would probably keep them i guess?
                    dp[i][j] = dp[i + 1][j + 1]; // guessing
                }
                else {
                    // different cases
                    // like minimizing the edit distance
                    // optimization function
                    // three options: replace, add, delete
                    dp[i][j] = Math.min(1 + dp[i + 1][j + 1], Math.min(1 + dp[i + 1][j], 1 + dp[i][j + 1]));
                }
            }
        }
        return dp[0][0];
    }
}
