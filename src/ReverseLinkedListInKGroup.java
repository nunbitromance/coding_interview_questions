/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode first = head;
        
        while (first != null) {
            ListNode cur = first;
            boolean isEndReached = false;
            for (int i = 0; i < k; i++) {
                if (cur.next == null) {
                    isEndReached = true;
                    break;
                } else {
                    cur = cur.next;
                }
            }
            
            if (!isEndReached) {
                ListNode tail = cur.next;
                first.next = reverse(first, tail, k);
                first = tail;
            }
        }
        
        return head;
    }
    
    public ListNode reverse(ListNode head, ListNode tail, int k) {
        ListNode prev = null;
        ListNode cur = head;
        int i = 0;
        while (cur != null && i < k) {
            ListNode temp = cur.next;
            cur.next = prev;
            prev.next = temp;
            i++;
        }
        head.next = tail;
        return prev;
    }
}
