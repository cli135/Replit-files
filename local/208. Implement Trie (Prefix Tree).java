// https://leetcode.com/problems/implement-trie-prefix-tree/description/

class Trie {
    HashMap<Character, Trie> map;
    boolean isLeaf;
    public Trie() {
        map = new HashMap<>();
        isLeaf = false;
    }
    
    public void insert(String word) {
        if (word.length() == 0) {
            this.isLeaf = true;
            return;
        }
        else {
            char cur_char = word.charAt(0);
            String rest_of_string = word.substring(1);
            if (this.map.containsKey(cur_char)) {
                Trie child_node = this.map.get(cur_char);
                child_node.insert(rest_of_string);
            }
            else {
                Trie new_child_node = new Trie();
                this.map.put(cur_char, new_child_node);
                new_child_node.insert(rest_of_string);
            }
        }
    }
    
    public boolean search(String word) {
        if (word.length() == 0 && isLeaf) {
            return true;
        }
        else if (word.length() == 0 && !isLeaf) {
            return false;
        }
        // else if (word.length() != 0 && isLeaf) {
        //     return false;
        // }
        else {
            char cur_char = word.charAt(0);
            String rest_of_string = word.substring(1);
            if (this.map.containsKey(cur_char)) {
                Trie child_node = this.map.get(cur_char);
                return child_node.search(rest_of_string);
            }
            else {
                return false;
            }
        }
    }
    
    public boolean startsWith(String prefix) {
        if (prefix.length() == 0 && isLeaf) {
            return true;
        }
        else if (prefix.length() == 0 && !isLeaf) {
            // prefix is a prefix of another word in the trie
            return true;
        }
        // else if (prefix.length() != 0 && isLeaf) {
        //     // prefix has a prefix in the trie
        //     return false;
        // }
        else {
            char cur_char = prefix.charAt(0);
            String rest_of_string = prefix.substring(1);
            if (this.map.containsKey(cur_char)) {
                Trie child_node = this.map.get(cur_char);
                return child_node.startsWith(rest_of_string);
            }
            else {
                return false;
            }
        }
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
