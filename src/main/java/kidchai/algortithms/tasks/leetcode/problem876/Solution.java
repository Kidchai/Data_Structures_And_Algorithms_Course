package kidchai.algortithms.tasks.leetcode.problem876;

class Solution {
    private static class ListNode {
        int val;
        ListNode next;
        ListNode() {
        }
        ListNode(int val) {
            this.val = val;
        }
        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode middleNode(ListNode head) {
        ListNode currentNode = head;
        int counter = 0;

        while (currentNode != null) {
            currentNode = currentNode.next;
            counter++;
        }

        currentNode = head;
        int targetIndex = counter / 2 == 0 ? counter / 2 + 1 : counter / 2;

        for (int index = 0; index < targetIndex; index++) {
            if (currentNode.next != null) {
                currentNode = currentNode.next;
            }
        }
        return currentNode;
    }
}
