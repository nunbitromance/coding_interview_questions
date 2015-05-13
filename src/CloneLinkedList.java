/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        RandomListNode head2 = new RandomListNode(0);
        Map<RandomListNode, RandomListNode> map = new HashMap<RandomListNode, RandomListNode>();
        RandomListNode cur = head;
        RandomListNode cur2 = head2;
        while (cur != null) {
            cur2.next = new RandomListNode(cur.label);
            cur2.random = cur.random;
            map.put(cur, cur2);
            cur = cur.next;
            cur2 = cur2.next;
        }
        
        cur2 = head2.next;
        while (cur2 != null) {
            cur2.random = map.get(cur2.random);
            cur2 = cur2.next;
        }
        
        return head2.next;
    }
}
