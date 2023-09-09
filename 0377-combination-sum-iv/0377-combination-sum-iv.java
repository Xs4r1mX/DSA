public class Solution {
    
    public int help(int[] nums, int target, int[] dp) {
        int n = nums.length;
        if (target == 0) return 1;
        int ans = 0;
        
        if (dp[target] != -1) return dp[target];
        
        for (int i = 0; i < n; i++) {
            if (nums[i] <= target) {
                ans += help(nums, target - nums[i], dp);
            }
        }
        dp[target] = ans;
        return dp[target];
    }
    
    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target + 1];
        Arrays.fill(dp, -1);
        return help(nums, target, dp);
    }
}