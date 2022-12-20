package kidchai.algortithms.tasks.leetcode.problem451;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

class Solution {
    public String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (char letter : s.toCharArray()) {
            map.put(letter, map.getOrDefault(letter, 0) + 1);
        }

        PriorityQueue<Character> maxHeap = new PriorityQueue<>((a, b) -> map.get(b) - map.get(a));
        maxHeap.addAll(map.keySet());

        StringBuilder sb = new StringBuilder();
        while (maxHeap.peek() != null) {
            char letter = maxHeap.poll();
            for (int i = 0; i < map.get(letter); i ++) {
                sb.append(letter);
            }
        }
        return sb.toString();
    }
}
