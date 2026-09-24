class Solution {
    public int reversePairs(int[] nums) {
        if (nums == null || nums.length <= 1) return 0;
        int[] temp = new int[nums.length]; // Single allocation
        return mergeSort(nums, 0, nums.length - 1, temp);
    }

    private int mergeSort(int[] nums, int l, int r, int[] temp) {
        if (l >= r) return 0;

        int m = l + (r - l) / 2;
        int count = 0;

        count += mergeSort(nums, l, m, temp);
        count += mergeSort(nums, m + 1, r, temp);
        count += merge(nums, l, m, r, temp);

        return count;
    }

    private int merge(int[] nums, int l, int m, int r, int[] temp) {
        // 1. Count Reverse Pairs
        int reverse = 0;
        int j = m + 1;
        for (int i = l; i <= m; i++) {
            while (j <= r && (long) nums[i] > 2L * nums[j]) {
                j++;
            }
            reverse += (j - (m + 1));
        }

        // 2. Standard Merge into temp array
        int i = l;
        j = m + 1;
        int k = l;

        while (i <= m && j <= r) {
            if (nums[i] <= nums[j]) {
                temp[k++] = nums[i++];
            } else {
                temp[k++] = nums[j++];
            }
        }

        while (i <= m) temp[k++] = nums[i++];
        while (j <= r) temp[k++] = nums[j++];

        // Copy merged result back to nums
        for (i = l; i <= r; i++) {
            nums[i] = temp[i];
        }

        return reverse;
    }
}