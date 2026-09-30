class Solution {
    public int minDays(int[] nums, int m, int k) {
        int n = nums.length;
        // 1. Guard clause: avoid binary search entirely if total required roses exceed n
        if ((long) m * k > n) {
            return -1;
        }

        // 2. Tighter search space: find min and max bloom days in a single pass
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int day : nums) {
            min = Math.min(min, day);
            max = Math.max(max, day);
        }

        int l = min;
        int r = max;
        int ans = -1;

        // 3. Binary search on days
        while (l <= r) {
            int mid = l + (r - l) / 2;

            if (canMake(nums, mid, k, m)) {
                ans = mid;
                r = mid - 1; // Try to find a smaller valid day
            } else {
                l = mid + 1; // Need more days
            }
        }
        return ans;
    }

    private boolean canMake(int[] nums, int day, int k, int m) {
        int bouquets = 0;
        int count = 0;

        for (int bloomDay : nums) {
            if (bloomDay <= day) {
                count++;
                if (count == k) {
                    bouquets++;
                    count = 0;
                    // Early exit: stop scanning array as soon as target m is reached
                    if (bouquets == m) {
                        return true;
                    }
                }
            } else {
                count = 0;
            }
        }
        return false;
    }
}