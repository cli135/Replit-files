class Solution {
    public int chalkReplacer(int[] chalk, int k) {
        // find the sum:
        int sum = 0;
        for (int num : chalk) {
            sum += num;
        }
        return chalkReplacer(chalk, 0, k, sum);
        /*
        int n = chalk.length;
        int i = 0;
        // check enough chalk left
        while (chalk[i] <= k) {
            k -= chalk[i];
            i++;
            i %= n; // within mod n
        }
        return i;
        */
    }
    private int chalkReplacer(int[] chalk, int i, int k, int sum) {
        int before = ((i - 1) % (chalk.length) + chalk.length ) % chalk.length;
        if (k < chalk[i] && k + chalk[before] >= chalk[i]) {
            return i;
        }
        else if (sum <= k) {
            return chalkReplacer(chalk, i % (chalk.length), k - sum, sum);
        }
        else if (chalk[i] <= k) {
            // use the chalk
            return chalkReplacer(chalk, (i + 1) % (chalk.length), k - chalk[i], sum);
        }
        else { // if (k < chalk[i]) {
            return chalkReplacer(chalk, before, k + chalk[before], sum);
        }
    }
}