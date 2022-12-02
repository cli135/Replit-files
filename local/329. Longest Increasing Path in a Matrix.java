// not working as of 12-2-2022

class Cell implements Comparable<Cell> {
    public Integer val;
    public Integer idx;
    public Cell (Integer v, Integer i) {
        val = v;
        idx = i;
    }
    @Override
    public int compareTo(Cell other) {
        // compare by value in matrix first
        if (this.val.compareTo(other.val) != 0) {
            return this.val.compareTo(other.val);
        }
        else {
            return this.idx.compareTo(other.idx);
        }
    }
}

class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        // dp array two dimensional
        // but two dimensional in what aspect?
        // ok i'm going to do the i, j in the most traditional sense
        // and the dp rule will inherit from all four adjacent neighbors
        // what is the base case?
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[n][n];
        
        
        // well okay we're going to make a long list of cell objects
        // List<Cell> is one way
        // but TreeSet just looks waaaay cooler
        TreeSet<Cell> remaining = new TreeSet<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // encoding to 1-D indices
                remaining.add(new Cell(matrix[i][j], i * n + j));
            }
        }
        
        
        // try memo propagating
        // and you know that the minimum must be zero
        // in terms of paths that end at that point
        // this is the base case
        
        
        // int x = 0;
        // int y = 0;
        // int min = Integer.MAX_VALUE;
        // for (int i = 0; i < n; i++) {
        //     for (int j = i; j < n; j++) {
        //          if (matrix[i][j] < min) {
        //              min = matrix[i][j];
        //              x = i;
        //              y = j;
        //          }
        //     }
        // }
        
        int x = remaining.first().idx / n;
        int y = remaining.first().idx % n;
        
        // now we know where the min is at this point
        // so for sure then the increasing path matrix must be 0
        // at this point
        dp[x][y] = 0; // ending at this point
        // and from here on out we build up recursion bottom up
        // the main challenge was where to start the base case
        // so we weren't drawing from empty boxes that weren't yet
        // filled. This is why memoization is so powerful, it will
        // recurse down to the bottom levels for you and find exactly
        // what needs to be populated first before you do anything
        // ok sounds good
        
        // now we just expand out to adjacent neighbors little by little it seems
        // this is like a bfs type thing
        // looks like bfs sounds good
        // wow this dp is hard but we are spreading out bfs style
        // to populate the dp grid
        // sounds good
        // actually we can turn this into a hashed version
        // where the 2-d array is linearly labelled ok
        // i think this is more mathematical and robust
        // rather than relying on Strings or lists of integers
        
        // int idx = i * n + j;
        // i == idx / n
        // j == idx % n
        Queue<Cell> queue = new LinkedList<>();
        // tree set of explored nodes
        // and bfsing up there
        // Set<Cell> explored = new HashSet<>(); // "i,j" format of strings
        // TreeMap<Integer, Integer> sortedTreeMap = new TreeMap<>(); // ahh i have to figure this out
        queue.add(remaining.first());
        // go through all in queue and all in treeset
        while (!queue.isEmpty() && !remaining.isEmpty()) {
            Cell cur = queue.remove();
            // explored.add(cur); // explored this node
            remaining.remove(cur); // explored this node
            int i = cur.idx / n;
            int j = cur.idx % n;
            // gathering neighbors
            List<Cell> neighbors = new ArrayList<>();
            // left
            if (j - 1 >= 0) {
                neighbors.add();
            }
            // right
            if (getMatrixValFrom1Did(matrix, cur + 1) < m * n) {
                neighbors.add(cur + 1);
            }
            // up
            if (getMatrixValFrom1Did(matrix, cur - n) >= 0) {
                neighbors.add(cur - n);
            }
            // down
            if (getMatrixValFrom1Did(matrix, cur + n) < m * n) {
                neighbors.add(cur + n);
            }
            // add those neighbors that aren't explored yet
            for (Cell cell : neighbors) {
                if (remaining.contains(cell)) {
                    queue.add(cell);
                }
            }
            int i = cur / n;
            int j = cur % n;
            
            // the value at dp[i][j] will be
            // the maximum of all four of its neighbors
            // in the dp array
            int max = dp[i][j];
            
            for (Integer integer : neighbors) {
                int x = integer / n;
                int y = integer % n;
                max = Math.max(max, dp[x][y]);
            }
            
            dp[i][j] = max; // 
        }
        
    }
    public int getMatrixValFrom1Did(int[][] matrix, int cur) {
        int i = cur / matrix[0].length;
        int j = cur % matrix[0].length;
        return matrix[i][j];
    }
}
