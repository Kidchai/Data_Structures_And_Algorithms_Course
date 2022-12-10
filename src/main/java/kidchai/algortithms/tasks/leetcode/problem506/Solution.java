package kidchai.algortithms.tasks.leetcode.problem506;

import java.util.Arrays;
import java.util.Collections;

public class Solution {
    public String[] findRelativeRanks(int[] score) {
        String[] result = new String[score.length];
        Integer[] sortedArray = new Integer[score.length];

        for (int i = 0; i < score.length; i++) {
            sortedArray[i] = score[i];
        }
        Arrays.sort(sortedArray, Collections.reverseOrder());

        for (int i = 0; i < score.length; i++) {
            int rankNumber = binarySearchId(score[i], sortedArray);
            String rankMeaning = switch (rankNumber) {
                case 0 -> "Gold Medal";
                case 1 -> "Silver Medal";
                case 2 -> "Bronze Medal";
                default -> String.valueOf(rankNumber + 1);
            };

            result[i] = rankMeaning;
        }
        return result;
    }

    private static int binarySearchId(int i, Integer[] array) {
        int firstId = 0;
        int lastId = array.length - 1;

        while (firstId <= lastId) {
            int midId = (firstId + lastId) / 2;
            if (array[midId] == i) {
                return midId;
            } else if (array[midId] < i) {
                lastId = midId - 1;
            } else if (array[midId] > i) {
                firstId = midId + 1;
            }
        }
        return -1;
    }
}