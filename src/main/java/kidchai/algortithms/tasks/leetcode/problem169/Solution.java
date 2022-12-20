package kidchai.algortithms.tasks.leetcode.problem169;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

class Solution {
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int element : nums) {
            if (map.computeIfPresent(element, (key, val) -> ++val) == null) {
                map.put(element, 1);
            }
        }
        int max = Integer.MIN_VALUE;
        for (int value : map.values()) {
            if (value > max) {
                max = value;
            }
        }
        for(Entry<Integer, Integer> entry : map.entrySet()) {
            if(entry.getValue() == max) {
                return entry.getKey();
            }
        }
        return 0;
    }
}