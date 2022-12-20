package kidchai.algortithms.tasks.leetcode.problem88;

class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = 0;
        int j = 0;
        int k = 0;

        if (n == 0) {
            return;
        }

        if (m == 0) {
            while (i < n) {
                nums1[i] = nums2[i];
                i++;
            }
            return;
        }

        int[] nums3 = new int[m];
        System.arraycopy(nums1, 0, nums3, 0, m);

        while (k < m && j < n) {
            if (nums3[k] <= nums2[j]) {
                nums1[i] = nums3[k];
                k++;
            } else {
                nums1[i] = nums2[j];
                j++;
            }
            i++;
        }

        while (i < m + n) {
            if (j < n) {
                nums1[i] = nums2[j];
                j++;
            } else {
                nums1[i] = nums3[k];
                k++;
            }
            i++;
        }
    }
}
