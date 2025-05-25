class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> subset = new ArrayList<>();
        backtrack(nums,0,new ArrayList<>(),subset);
        return subset;
    }
    private void backtrack(int [] nums,int i1,List<Integer> path,List<List<Integer>> result){
        result.add(new ArrayList<>(path));
        for(int i=i1;i<nums.length;i++){
            path.add(nums[i]);
            backtrack(nums,i+1,path,result);
            path.remove(path.size()-1);
        }
    }
}