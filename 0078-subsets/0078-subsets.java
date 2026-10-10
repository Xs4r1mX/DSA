class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result= new ArrayList<>();
        int index=0;
        generate(nums,index,new ArrayList<>(),result);
        return result;
    }


    private void generate(int[] nums, int index, List<Integer> list, List<List<Integer>> result){
        if(index==nums.length){
            result.add(new ArrayList<>(list));
            return;
        }

        generate(nums,index+1,list,result);
        list.add(nums[index]);
        generate(nums,index+1,list,result);
        list.remove(list.size()-1);
    }
}