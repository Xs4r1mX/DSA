import java.util.Arrays;

class Solution {
    public int minMoves2(int[] nums) {
        // Sort the array to find the median
        Arrays.sort(nums);
        
        // The median is at the middle index
        int median = nums[nums.length / 2];
        
        int ans = 0;
        for (int n : nums) {
            ans += Math.abs(median - n);
        }
        
        return ans;
    }
}