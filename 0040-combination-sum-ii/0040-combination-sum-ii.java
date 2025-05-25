class Solution {
    public List<List<Integer>> combinationSum2(int[] cand, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(cand); 
        back(cand, 0, res, new ArrayList<>(), target);
        return res;
    }

    private void back(int[] cand, int start, List<List<Integer>> res, List<Integer> curr, int target) {
        if (target == 0) {
            res.add(new ArrayList<>(curr));
            return;
        }

        for (int i = start; i < cand.length; i++) {
            if (i > start && cand[i] == cand[i - 1]) continue; 
            if (cand[i] > target) break;

            curr.add(cand[i]);
            back(cand, i + 1, res, curr, target - cand[i]); 
            curr.remove(curr.size() - 1);
        }
    }
}
