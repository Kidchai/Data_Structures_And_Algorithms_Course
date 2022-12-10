package kidchai.algortithms.tasks.leetcode.problem268;

public class Solution {
    public int missingNumber(int[] nums) {
        int expected = 0;
        int actual = 0;
        int maxNumber = 0;
        boolean hasZero = false;

        for (int i = 0; i < nums.length; i++) {
            int nextExpected = i + 1;
            expected += nextExpected;
            actual += nums[i];
            if (nums[i] > maxNumber) {
                maxNumber = nums[i];
            }
            if (nums[i] == 0) {
                hasZero = true;
            }
        }
        if (!hasZero) {
            return 0;
        } else if (expected == actual) {
            return maxNumber + 1;
        } else {
            return expected - actual;
        }
    }
}