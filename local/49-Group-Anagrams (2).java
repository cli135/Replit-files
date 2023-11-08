// https://leetcode.com/problems/group-anagrams/submissions/

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // change each to their fingerprint e.g. their freq distrib.
        // then do uhhh some kind of hashmap
        // basically finding the equivalence classes
        
        HashMap<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            // sort the string to find out which
            // equivalence class it belongs to
            char[] toArray = str.toCharArray();
            Arrays.sort(toArray); // sorted string IDs the equiv. class.
            String sorted = String.valueOf(toArray);
            // add the string to that equivalence class
            if (!map.containsKey(sorted)) {
                List<String> list = new ArrayList<>();
                list.add(str);
                map.put(sorted, list);    
            }
            else {
                // add to existing list
                List<String> list = map.get(sorted);
                list.add(str);
            }
        }
        System.out.println()
        // return equivalence classes
        // only the value in the lists, not the
        // keys associated with them
        // the values are lists themselves
        return new ArrayList<>(map.values());
        
            
        
        
        // just use alphabetically sorted strings (mish mash of chars)
        // in sorted order)
        // as the representative of each equivalence class
        // and compare on that, compare == on that
        
        // and just remember the original indices of what they were in the
        // orig array at least
        // so you can group them later
        // alright sounds good
        
        // ok now we sort the hashmap
        // already sorted as a treemap
        
        // traversing treemap
        
    }
    private boolean isAnagram(String s1, String s2) {
        int[] alphabet = new int[26];
        // add s1's letters to alphabet frequency distribution
        for (int i = 0; i < s1.length(); i++) {
            alphabet[s1.charAt(i) - 'a']++;
        }
        // remove s2's letters from alphabet frequency distribution
        for (int i = 0; i < s2.length(); i++) {
            alphabet[s2.charAt(i) - 'a']--;
        }
        // anagrams should end up back at all 0's in freq. distrib.
        for (int i = 0; i < alphabet.length; i++) {
            if (alphabet[i] != 0) {
                // not an anagram - not perfectly cancelled out
                return false;
            }
        }
        return true; // is anagram, perfectly cancelled out letters in s1 and s2
    }
}
