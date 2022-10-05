class Solution {
    public boolean isValid(String s) {
        Stack<Character> stk = new Stack<>();
        
        int i = 0;
        
        // could just switch to a for loop
        while (i < s.length()) {
            char c = s.charAt(i);
            if (c == '(' || c == '[' || c == '{') {
                
                // System.out.println("got here");
                stk.push(c);
            }
            else {
                // need this check here
                // before we pop
                if (stk.isEmpty()) {
                    return false;
                }
                
                // pop and compare, to make sure brackets match
                char popped = stk.pop();
                // System.out.println(popped);
                if (c == ')' && popped != '(') {
                    return false;
                }
                else if (c == ']' && popped != '[') {
                    return false;
                }
                else if (c == '}' && popped != '{') {
                    return false;
                }
                // continue;
            }
            // for the next iteration
            i++;
        }
        
        return stk.isEmpty();
    }
}
