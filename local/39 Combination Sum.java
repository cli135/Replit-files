class Solution {
    // backtracking is combinatorics and discrete math at its finest!!!
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates); // to be sure it's sorted
        
        List<List<Integer>> list = new ArrayList<>();
        
        List<Integer> curList = new ArrayList<>();
        backtrack(candidates, target, 0, list, curList);
        
        return list;
        
    }
    
    private void backtrack(int[] candidates, int target, int idx, List<List<Integer>> list, List<Integer> curList) {
        // try including 2 to the curList for now and see what happens
        // stay or go - how to increment idx
        if (idx >= candidates.length) {
            return; // not beyond end of array
        }
        if (target < 0) {
            // dead end and we went too far
            // this curList is no good (so we discard it)
            return;
        }
        else if (target == 0) {
            // perfect! we found a good ending point, right on!
            // exactly perfect to end at the right time -- at 0.
            
            // this is pretty slow here
            for (List<Integer> existingList : list) {
                if (existingList.equals(curList)) {
                    return;
                }
            }
            // otherwise, we can add it
            list.add(curList);
            // what to do now
        }
        // i got it -- you have to deep copy curList at certain breakpoints
        // in the recursive structure -- because it will branch into two
        // possible futures
        List<Integer> curListBranch1 = new ArrayList<>();
        List<Integer> curListBranch2 = new ArrayList<>();
        
        // deep copying two copies
        for (int i : curList) {
            curListBranch1.add(i);
            curListBranch2.add(i);
        }
        
        curListBranch1.add(candidates[idx]);
        backtrack(candidates, target - candidates[idx], idx, list, curListBranch1); // stay (indefinitely)
        // curList.remove(curList.size() - 1); // removing the thing we just added
        
        // curListBranch2.add(candidates[idx + 1]);
        backtrack(candidates, target, idx + 1, list, curListBranch2); // go 1 over
        // curList.remove(curList.size() - 1); // removing the thing we just added
        
    }
}
