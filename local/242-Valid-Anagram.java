/** 
242. Valid Anagram
Easy

5413

226

Add to List

Share
Given two strings s and t, return true if t is an anagram of s, and false otherwise.

An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.

 

Example 1:

Input: s = "anagram", t = "nagaram"
Output: true
Example 2:

Input: s = "rat", t = "car"
Output: false
 

Constraints:

1 <= s.length, t.length <= 5 * 104
s and t consist of lowercase English letters.
 

Follow up: What if the inputs contain Unicode characters? How would you adapt your solution to such a case?

Accepted
1.4M
Submissions
2.3M
Seen this question in a real interview before?


*/


class Solution {
    public boolean isAnagram(String s, String t) {
        // return method0(s, t); // Java HashMap
        return method1(s, t); // [0, 26] freq array (hashmap from scratch)
        
        // they are an anagram iff <==> their letter count sums/
        // distribution are the same
    }
    
    
    public boolean method0(String s, String t) {
        // just use a hashmap
        HashMap<Character, Integer> hm = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            // increment count
            if (hm.containsKey(c)) {
                Integer cur = hm.get(c);
                hm.put(c, cur + 1);
            }
            else {
                hm.put(c, 1);
            }
        }
        HashMap<Character, Integer> hm2 = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            // increment count
            if (hm2.containsKey(c)) {
                Integer cur = hm2.get(c);
                hm2.put(c, cur + 1);
            }
            else {
                hm2.put(c, 1);
            }
        }
        
        System.out.println(hm);
        System.out.println(hm2);
        
        // probably could find a way to for loop check this too
        return hm.equals(hm2);
        
    }
    
    // yep it's faster than method0! wow cool
    // i guess for these cases with 0 to 26 spots it is faster
    // than all the optimizing oracle did with Java HashMap
    
    public boolean method1(String s, String t) {
        // code a hash map from scratch
        // since you can code the max memory, fastest time case
        // since it's only just lowercase english letters
        
        
        int[] letterDistributionS = new int[26]; // frequency distribution
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            c -= 'a'; // shifting range from [97, 122] to [0, 26]
            letterDistributionS[c] += 1;
        }
        int[] letterDistributionT = new int[26]; // frequency distribution
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            c -= 'a'; // shifting range from [97, 122] to [0, 26]
            letterDistributionT[c] += 1;
        }
        
        // kind of a lucky trick for now,
        // but all it would require is legit just a for loop O(N) equality check pass like
        /*
        for (int i = 0; i < arr.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false; // discrepancy detected
            }
        }
        return true;
        */
        return Arrays.equals(letterDistributionS, letterDistributionT);
        
    }
}
