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
    public ListNode deleteNodes(ListNode head, int m, int n) {
        ListNode cur = head, pre = null;

        while (cur != null) {
            int left = m, remove = n;

            while (left-- > 0 && cur != null) {
                pre = cur;
                cur = cur.next;
            }
            while (remove-- > 0 && cur != null) {
                cur = cur.next;
            }
            pre.next = cur;
        }

        return head;
    }
}