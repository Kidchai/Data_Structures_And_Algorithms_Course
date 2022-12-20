package kidchai.algortithms.tasks.leetcode.problem9;

class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        } else if (x / 10 == 0) {
            return true;
        } else {
            int length = (int) (Math.log10(x) + 1);
            int[] array = new int[length];
            for (int i = 0; i < length; i++) {
                array[i] = x % 10;
                x = x / 10;
            }
            int j = length - 1;
            int i = 0;
            do {
                if (array[i] != array[j]) {
                    return false;
                }
                i++;
                j--;
            } while (i < j);
        }
        return true;
    }
}
