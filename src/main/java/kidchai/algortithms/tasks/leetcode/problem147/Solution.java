package kidchai.algortithms.tasks.leetcode.problem147;


class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

class Solution {
    public ListNode insertionSortList(ListNode head) {
        ListNode headSorted = new ListNode(head.val, null);
        ListNode nullHeadSorted = new ListNode(0, headSorted);

        ListNode current = head.next;
        ListNode currentSorted = headSorted;

        while (current != null) {
            currentSorted = nullHeadSorted;
            while (currentSorted.next != null) {
                if (currentSorted.next.val > current.val) {
                    break;
                }
                currentSorted = currentSorted.next;
            }
            currentSorted.next = new ListNode(current.val, currentSorted.next);
            if (nullHeadSorted.next.equals(currentSorted.next)) {
                headSorted = currentSorted.next;
            }

            current = current.next;
        }
        return headSorted;
    }
}