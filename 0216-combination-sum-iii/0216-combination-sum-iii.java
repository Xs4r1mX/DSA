
class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        generate(k, n, result, new ArrayList<>(), 1);
        return result;
    }

    private void generate(int limit, int currentSum,
                          List<List<Integer>> result,
                          List<Integer> current, int currentNum) {

        if (currentSum == 0 && limit == 0) {
            result.add(new ArrayList<>(current));
            return;
        }

        if (currentSum <= 0 || limit <= 0 || currentNum > 9) {
            return;
        }

        // Skip current number
        generate(limit, currentSum, result, current, currentNum + 1);

        // Include current number
        current.add(currentNum);
        generate(limit - 1, currentSum - currentNum,
                 result, current, currentNum + 1);
        current.remove(current.size() - 1);
    }
}
