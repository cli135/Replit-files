/**

https://leetcode.com/problems/min-stack/

155. Min Stack
Medium

9278

663

Add to List

Share
Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

Implement the MinStack class:

MinStack() initializes the stack object.
void push(int val) pushes the element val onto the stack.
void pop() removes the element on the top of the stack.
int top() gets the top element of the stack.
int getMin() retrieves the minimum element in the stack.
You must implement a solution with O(1) time complexity for each function.

 

Example 1:

Input
["MinStack","push","push","push","getMin","pop","top","getMin"]
[[],[-2],[0],[-3],[],[],[],[]]

Output
[null,null,null,null,-3,null,0,-2]

Explanation
MinStack minStack = new MinStack();
minStack.push(-2);
minStack.push(0);
minStack.push(-3);
minStack.getMin(); // return -3
minStack.pop();
minStack.top();    // return 0
minStack.getMin(); // return -2
 

Constraints:

-231 <= val <= 231 - 1
Methods pop, top and getMin operations will always be called on non-empty stacks.
At most 3 * 104 calls will be made to push, pop, top, and getMin.
Accepted
1.1M
Submissions
2.1M
Seen this question in a real interview before?


*/

class MinStack {
    Stack<Integer> stk;
    Stack<Integer> mins;
    
    public MinStack() {
        stk = new Stack<>();
        mins = new Stack<>();
    }
    
    public void push(int val) {
        stk.push(val);
        // <= keeps duplicates, since we want that
        // redundancy, so that even if one copy
        // goes away, the others remain
        if (mins.isEmpty() || val <= mins.peek()) {
            // like a track record of all the mins
            // we've ever seen
            mins.push(val);
            // our track record goes in monotonic decreasing
            // order, meaning that we only look for equal
            // or more min to update the mins stack
        }
        
    }
    
    public void pop() {
        int val = stk.pop();
        // if we're popping a min, then we take one off
        // any duplicates still remain to be popped off later
        if (val == mins.peek()) {
            mins.pop();
            // now getMin() will return
            // the min before we saw the one that was
            // popped off
            // returning to a previous version
            // it's just version history / stack / undo/redo
        }
    }
    
    public int top() {
        return stk.peek();
    }
    
    public int getMin() {
        return mins.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
