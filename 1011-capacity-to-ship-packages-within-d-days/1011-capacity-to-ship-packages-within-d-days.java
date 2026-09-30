class Solution 
{
  public int shipWithinDays(int[] weights, int days){
        int l = 0;
        int r = 0;

        // Lower bound is max weight (must fit heaviest package)
        // Upper bound is sum of all weights (ship everything in 1 day)
        for (int w : weights) {
            l = Math.max(l, w);
            r += w;
        }

        int ans = r;

        while (l <= r) {
            int mid = l + (r - l) / 2;

            if (getDaysNeeded(weights, mid) <= days) {
                ans = mid;
                r = mid - 1; // Try smaller capacity
            } else {
                l = mid + 1; // Increase capacity
            }
        }
        return ans;
    }

    private int getDaysNeeded(int[] weights, int capacity) {
        int daysNeeded = 1;
        int currentLoad = 0;

        for (int w : weights) {
            if (currentLoad + w > capacity) {
                daysNeeded++;
                currentLoad = w; // Start new day with current package
            } else {
                currentLoad += w;
            }
        }
        return daysNeeded;
    }
}