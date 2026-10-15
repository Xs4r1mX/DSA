class Solution {
    public int sumCounts(List<Integer> nums) {
        Set<Integer> set = new HashSet<>();
        int count=0;

        for(int i=0;i<nums.size();i++){
            for(int j=i;j<nums.size();j++){
                set.add(nums.get(j));
                int size=set.size();
                count+=size*size;
            }
            set.clear();
        }
        return count;
    }
}