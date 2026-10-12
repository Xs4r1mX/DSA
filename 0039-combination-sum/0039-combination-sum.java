class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        checkAndAdd(candidates,target,result,0,0,new ArrayList<>());
        return result;
    }

    private void checkAndAdd(int[] nums, int target, List<List<Integer>> result, int index, int sum, List<Integer> current){
        if(sum==target){
            result.add(new ArrayList<>(current));
            return;
        }

        if(sum>target){
            return;
        }

        if(index==nums.length){
            return;
        }

        checkAndAdd(nums,target,result,index+1,sum,current);

        current.add(nums[index]);
        checkAndAdd(nums,target,result,index,sum+nums[index],current);
        current.remove(current.size()-1);
    }
}