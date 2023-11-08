class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> returnList = new ArrayList<>();
        List<Integer> cur = new ArrayList<>(); // prime the pump
        backtrack(candidates, 0, target, cur, returnList);
        return returnList;
    }
    public void backtrack(int[] candidates, int start, int target, List<Integer> cur, List<List<Integer>> resultList) {
        if (target == 0) {
            List<Integer> copyCur = new ArrayList<>(cur);
            resultList.add(copyCur);
            return;
        }
        if (target < 0) {
            return;
        }
        // otherwise
        for (int i = start; i < candidates.length; i++) {
            if (i != start && candidates[i - 1] == candidates[i]) {
                continue; // skip this iteration
            }
            // add it
            cur.add(candidates[i]);
            backtrack(candidates, i + 1, target - candidates[i], cur, resultList);
            // then remove it
            cur.remove(cur.size() - 1);
            // and move on
            
        }
    }
}
