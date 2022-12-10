package kidchai.algortithms.tasks.leetcode.problem888;

public class Solution {
    public int[] fairCandySwap(int[] aliceSizes, int[] bobSizes) {
        int aliceCandies = 0;

        for (int candies : aliceSizes) {
            aliceCandies += candies;
        }

        int bobCandies = 0;

        for (int candies : bobSizes) {
            bobCandies += candies;
        }

        int extra = aliceCandies > bobCandies ? (aliceCandies - bobCandies) / 2 :
                (bobCandies - aliceCandies) / 2;

        for (int aliceBox : aliceSizes) {
            for (int bobBox : bobSizes) {
                if (aliceCandies < bobCandies && bobBox - aliceBox == extra) {
                    return new int[]{aliceBox, bobBox};
                } else if (bobCandies < aliceCandies && aliceBox - bobBox == extra) {
                    return new int[]{aliceBox, bobBox};
                }
            }
        }
        return new int[]{-1, -1};
    }
}