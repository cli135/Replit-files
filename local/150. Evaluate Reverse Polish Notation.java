/**

https://leetcode.com/problems/evaluate-reverse-polish-notation/

150. Evaluate Reverse Polish Notation
Medium

3797

685

Add to List

Share
Evaluate the value of an arithmetic expression in Reverse Polish Notation.

Valid operators are +, -, *, and /. Each operand may be an integer or another expression.

Note that division between two integers should truncate toward zero.

It is guaranteed that the given RPN expression is always valid. That means the expression would always evaluate to a result, and there will not be any division by zero operation.

 

Example 1:

Input: tokens = ["2","1","+","3","*"]
Output: 9
Explanation: ((2 + 1) * 3) = 9
Example 2:

Input: tokens = ["4","13","5","/","+"]
Output: 6
Explanation: (4 + (13 / 5)) = 6
Example 3:

Input: tokens = ["10","6","9","3","+","-11","*","/","*","17","+","5","+"]
Output: 22
Explanation: ((10 * (6 / ((9 + 3) * -11))) + 17) + 5
= ((10 * (6 / (12 * -11))) + 17) + 5
= ((10 * (6 / -132)) + 17) + 5
= ((10 * 0) + 17) + 5
= (0 + 17) + 5
= 17 + 5
= 22
 

Constraints:

1 <= tokens.length <= 104
tokens[i] is either an operator: "+", "-", "*", or "/", or an integer in the range [-200, 200].
Accepted
487.7K
Submissions
1.1M
Seen this question in a real interview before?


*/

class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stk = new Stack<>();
        // going forward works
        for (int i = 0; i < tokens.length; i++) {
            // if an operator, pop the two previous
            // ints on the stack
            // and push the result
            if (tokens[i].equals("+")) {
                int second = stk.pop();
                int first = stk.pop();
                stk.push(first + second);
            }
            else if (tokens[i].equals("-")) {
                
                int second = stk.pop();
                int first = stk.pop();
                stk.push(first - second);
            }
            else if (tokens[i].equals("*")) {
                
                int second = stk.pop();
                int first = stk.pop();
                stk.push(first * second);
            }
            else if (tokens[i].equals("/")) {
                System.out.println(stk.toString());
                int second = stk.pop();
                int first = stk.pop();
                stk.push(first / second);
            }
            else {
                // if an int, just push to the stack
                stk.push(Integer.parseInt(tokens[i]));
                
            
            }
            // debugging
            System.out.println(stk.peek());
        }
        
        // RPN is designed to work like a stack
        // so a valid expression will leave just one
        // int on the stack at the end, the final result
        // of the arithmetic operations combined
        return stk.peek();
    }
}
