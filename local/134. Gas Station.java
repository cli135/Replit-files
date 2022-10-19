class Solution {
    // holy mother of god i actually figured this one out on my own
    // this is just a bunch of crazy guesses wow
    // so lucky
    public int canCompleteCircuit(int[] gas, int[] cost) {
        // reduce to a n node linked list cycle / graph
        int[] net = new int[gas.length];
        for (int i = 0; i < gas.length; i++) {
            net[i] = gas[i] - cost[i];
        }
        int sum = 0;
        for (int i = 0; i < net.length; i++) {
            sum += net[i];
        }
        if (sum < 0) {
            return -1; // literally not enough gas
            // to go around
        }
        else {
            // we know our net totals to >= 0 at this point
            // find the min in the accumulated array
            int minIdx = 0;
            int[] prefixSum = new int[net.length];
            int accumulator = 0;
            for (int i = 0; i < net.length; i++) {
                accumulator += net[i];
                prefixSum[i] = accumulator;
            }
            for (int i = 0; i < prefixSum.length; i++) {
                if (prefixSum[i] <= prefixSum[minIdx]) {
                    minIdx = i;
                }
            }
            // go one after that one to start the tour
            // an upward climb
            return (minIdx + 1) % net.length;
        }
    }
}
