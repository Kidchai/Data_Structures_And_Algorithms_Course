package kidchai.algortithms.tasks.leetcode.problem350;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            return intersect(nums2, nums1);
        }

        Map<Integer, Integer> map = new HashMap<>();
        for (int element : nums1) {
            if (map.computeIfPresent(element, (key, val) -> ++val) == null) {
                map.put(element, 1);
            }
        }

        List<Integer> list = new ArrayList<>();
        for (int element : nums2) {
            int value = map.getOrDefault(element, 0);
            if (value > 0) {
                list.add(element);
                map.put(element, value - 1);
            }
        }

        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }
}
