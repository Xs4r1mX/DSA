class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> ds = new ArrayList<>();
        boolean[] taken = new boolean[nums.length];
        solve(nums,ds,ans,taken);
        return ans;
    }

    public void solve(int[] nums,List<Integer> ds,List<List<Integer>> ans,boolean[] taken){
        if(ds.size()==nums.length){
            ans.add(new ArrayList<>(ds));
            return;
        }

        for(int i=0;i<nums.length;i++){
            if(!taken[i]){
                taken[i]=true;
                ds.add(nums[i]);
                solve(nums,ds,ans,taken);
                ds.remove(ds.size()-1);
                taken[i]=false;
            }
        }
    }
}