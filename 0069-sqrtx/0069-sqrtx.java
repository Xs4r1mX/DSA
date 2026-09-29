class Solution {
    public int mySqrt(int n) {
        // if (n == 0)
        //     return 0;

        // if (n == 1)
        //     return 1;

        // if (n == 2 || n == 3)
        //     return 1;

        int l = 0;
        int r = n;
        int ans = -1;

        while (l <= r) {
            int m = l + (r - l) / 2;

            if ((long) m * m == n) {
                return m;
            }

            else if ((long) m * m > n) {
                r = m - 1;
            } else {
                ans = m;
                l = m + 1;
            }
        }
        return ans;
    }
}