class Solution {
public:
    int longestValidParentheses(string s) {
        if (s.at(0) == \"(\") {
            
        }
        else {
            return longestValidParentheses(s.substr(1));
        }
    }
};