package kidchai.algortithms.tasks.leetcode.problem69;

class Solution {
    public int mySqrt(int x) {
        int firstNumber = 0;
        int lastNumber = x;

        while (firstNumber <= lastNumber) {
            int midNumber = (firstNumber + lastNumber) / 2;
            long sqMidNumber = (long) midNumber * midNumber;
            long sqMidNumberMinus1 = (long) (midNumber - 1) * (midNumber - 1);

            if (sqMidNumber == x) {
                return midNumber;
            } else if (sqMidNumber > x && sqMidNumberMinus1 < x) {
                return midNumber - 1;
            }else if (sqMidNumber > x) {
                lastNumber = midNumber - 1;
            } else if (sqMidNumber < x) {
                firstNumber = midNumber + 1;
            }
        }
        return -1;
    }
}
