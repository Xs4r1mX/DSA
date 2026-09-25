class Solution {
    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int n = nums.length;
        int maxProduct = Integer.MIN_VALUE;
        int prefix = 1;
        int suffix = 1;

        for (int i = 0; i < n; i++) {
            // If prefix or suffix becomes 0, reset it to 1 to start a new subarray
            if (prefix == 0) prefix = 1;
            if (suffix == 0) suffix = 1;

            // Calculate prefix from the left, suffix from the right
            prefix *= nums[i];
            suffix *= nums[n - 1 - i];

            // Update the maximum product found so far
            maxProduct = Math.max(maxProduct, Math.max(prefix, suffix));
        }

        return maxProduct;
    }
}