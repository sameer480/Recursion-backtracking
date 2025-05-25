class Solution {
    public List<List<Integer>> combinationSum(int[] cand, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        back(cand, 0, res, curr, target);
        return res;
    }

    private void back(int[] cand, int start, List<List<Integer>> res, List<Integer> curr, int target) {
        if (target == 0) {
           
            res.add(new ArrayList<>(curr));
            return;
        }

        if (target < 0) {
            
            return;
        }

        for (int i = start; i < cand.length; i++) {
            curr.add(cand[i]);
            back(cand, i, res, curr, target - cand[i]);
            curr.remove(curr.size() - 1); 
        }
    }
}
