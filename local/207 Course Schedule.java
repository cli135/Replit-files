/**

https://leetcode.com/problems/course-schedule/

207. Course Schedule
Medium

11441

442

Add to List

Share
There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1. You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you must take course bi first if you want to take course ai.

For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
Return true if you can finish all courses. Otherwise, return false.

 

Example 1:

Input: numCourses = 2, prerequisites = [[1,0]]
Output: true
Explanation: There are a total of 2 courses to take. 
To take course 1 you should have finished course 0. So it is possible.
Example 2:

Input: numCourses = 2, prerequisites = [[1,0],[0,1]]
Output: false
Explanation: There are a total of 2 courses to take. 
To take course 1 you should have finished course 0, and to take course 0 you should also have finished course 1. So it is impossible.
 

Constraints:

1 <= numCourses <= 2000
0 <= prerequisites.length <= 5000
prerequisites[i].length == 2
0 <= ai, bi < numCourses
All the pairs prerequisites[i] are unique.
Accepted
1M
Submissions
2.3M

*/

class Solution {
    
    
    // correct method: find v, the 0th source node with no incoming edges
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // change data to adjacency lists
        int n = numCourses;
        List<List<Integer>> adjacencyList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjacencyList.add(new ArrayList<Integer>());
        }
        
        
        // Kahn's algorithm
        int[] indegree = new int[n];
        
        
        // populating adj list
        for (int i = 0; i < prerequisites.length; i++) {
            int from = prerequisites[i][0];
            int to = prerequisites[i][1];
            indegree[to]++;
            adjacencyList.get(from).add(to); // from node get 'to' appended
        }
        
        Queue<Integer> queue = new LinkedList<>();
        
        // int minIndegree = Integer.MAX_VALUE;
        // for (int i : indegree) {
        //     // -1 means we are done processing it
        //     if (i < minIndegree && i >= 0) {
        //         minIndegree = i;
        //     }
        // }
        
        int minIndegree = 0;
        for (int idx = 0; idx < n; idx++) {
            if (indegree[idx] == minIndegree) {
                queue.add(idx);
            }
        }
        
        
        while(!queue.isEmpty()) {
            //
            int idx = queue.remove();
            indegree[idx] = -1;
            for (Integer neighbor : adjacencyList.get(idx)) {
                indegree[neighbor]--;
                if (indegree[neighbor] == 0) {
                    queue.add(neighbor);
                }
            }
            
            // you don't want to double add a node to the queue
            // because then that would make its idx -2
            
            // or you could account for this at the very end then

            // nope, because any neighbors they have would be double discounted
            // which is not true to the original nature of the graph
            
            // which sets off an accumulating off by one error propagating
            // throughout the graph which makes the end result totally off
            
            // lesson - only add stuff once to the queue
            
            // minIndegree = 0;
            // minIndegree = Integer.MAX_VALUE;
            // for (int i : indegree) {
            //     // -1 means we are done processing it
            //     if (i < minIndegree && i >= 0) {
            //         minIndegree = i;
            //     }
            // }
            // for (int k = 0; k < n; k++) {
            //     if (indegree[k] == 0) {
            //         queue.add(k);
            //     }
            // }
            
        }
        
        for (int i : indegree) {
            if (i >= 0) {
                return false;
            }
        }
        return true;
        
        
        
    }
    
    public boolean canFinish2(int numCourses, int[][] prerequisites) {
        // change data to adjacency lists
        int n = numCourses;
        List<List<Integer>> adjacencyList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjacencyList.add(new ArrayList<Integer>());
        }
        
        // populating adj list
        for (int i = 0; i < prerequisites.length; i++) {
            int from = prerequisites[i][0];
            int to = prerequisites[i][1];
            adjacencyList.get(from).add(to); // from node get 'to' appended
        }
        
        // detect directed cycle in directed graph
        // find v, the source node
        // just mark off any nodes that have incoming edges
        // by looking only at outgoing edges
        // not very efficient but it works
        
        boolean[] hasIncomingEdges = new boolean[n];
        
        for (int i = 0; i < n; i++) {
            for (int destination : adjacencyList.get(i)) {
                hasIncomingEdges[destination] = true;
            }
        }
        for (boolean b : hasIncomingEdges) {
            if (b == false) {
                return true;
            }
        }
        return false;
    }

    // brute force bfs iterative queue - time limit exceeded
    // but 29/52 test cases passed yay
    public boolean canFinish1(int numCourses, int[][] prerequisites) {
        // change data to adjacency lists
        int n = numCourses;
        List<List<Integer>> adjacencyList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjacencyList.add(new ArrayList<Integer>());
        }
        
        // populating adj list
        for (int i = 0; i < prerequisites.length; i++) {
            int from = prerequisites[i][0];
            int to = prerequisites[i][1];
            adjacencyList.get(from).add(to); // from node get 'to' appended
        }
        
        // detect directed cycle in directed graph
        // all starting nodes v
        for (int startNode = 0; startNode < n; startNode++) {
            // bfs on them
            
            // setting up sets and queues for bfs
            int curNode = startNode;
            HashSet<Integer> explored = new HashSet<>(); // ahhh, and we look for repeats here
            explored.add(startNode);
            Queue<Integer> queue = new LinkedList<>();
            queue.add(startNode);
            
            // bfs iterative loop - might not quite be possible recursively?
            // at least not optimally because the call stack is optimized for stack behavior,
            // as the name suggests, not quite queue behavior...
            // call stack is a very special stack that does function operations. hmm. stack better than queue?
            // at least for recursion it seems so...
            
            while (!queue.isEmpty()) {
                curNode = queue.remove();
                for (int neighbor : adjacencyList.get(curNode)) { // order of exploring sibling nodes is undefined...?
                    // explore first, so that we can look before we leap
                    // and detect a cycle from one step behind
                    // instead of just looking at the spot (which makes
                    // us differentiate the beginning and the end where
                    // we start at startNode)
                    
                    // if unexplored, mark neighbor as explored
                    if (!explored.contains(neighbor)) {
                        explored.add(neighbor);
                    }
                    // otherwise, repeating ourselves - which is fine if it's just another node out there
                    // the big issue is if we see the start node again
                    if (neighbor == startNode) {
                        // then we've found a cycle back to the start
                        return false;
                    }
                    // add to queue
                    queue.add(neighbor);
                }    
            }
            
        } // end for
        return true; // otherwise, it is true
    }
}
