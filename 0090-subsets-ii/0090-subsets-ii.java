class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        // Sort the array to handle duplicates easily
        Arrays.sort(nums);
        backtrack(result, new ArrayList<>(), nums, 0);
        return result;
    }
    
    private void backtrack(List<List<Integer>> result, List<Integer> tempList, int[] nums, int start) {
        // Add a copy of the current subset to the result
        result.add(new ArrayList<>(tempList));
        
        for (int i = start; i < nums.length; i++) {
            // Skip duplicates at the same level of the recursion tree
            if (i > start && nums[i] == nums[i - 1]) {
                continue;
            }
            
            // Include the number and move forward
            tempList.add(nums[i]);
            backtrack(result, tempList, nums, i + 1);
            
            // Backtrack: remove the number to explore other paths
            tempList.remove(tempList.size() - 1);
        }
    }
}