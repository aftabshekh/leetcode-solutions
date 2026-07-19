/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode[] splitListToParts(ListNode head, int k) {

        ListNode[] ans = new ListNode[k];

        // Find length
        int len = 0;
        ListNode temp = head;

        while (temp != null) {
            len++;
            temp = temp.next;
        }

        int baseSize = len / k;
        int extra = len % k;

        ListNode curr = head;

        for (int i = 0; i < k; i++) {

            if (curr == null) {
                ans[i] = null;
                continue;
            }

            ans[i] = curr;

            int partSize = baseSize + (extra > 0 ? 1 : 0);

            if (extra > 0)
                extra--;

            // Move to last node of current part
            for (int j = 1; j < partSize; j++) {
                curr = curr.next;
            }

            // Break the list
            ListNode nextPart = curr.next;
            curr.next = null;
            curr = nextPart;
        }

        return ans;
    }
}