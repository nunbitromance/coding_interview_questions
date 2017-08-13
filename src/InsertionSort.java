/// <summary>
/// Insertion sort algorithm
/// 4, 2, 3, 5, 1 -> 1, 2, 3, 4, 5
/// </summary>
/// <param name="array"></param>
public static void insertionSort(int[] array)
{
    for (int i = 1; i < array.Length; i++)
    {
        int j = i;
        while (j > 0 && array[j] < array[j-1])
        {
            int temp = array[j - 1];
            array[j - 1] = array[j];
            array[j] = temp;
            j--;
        }
    }
}


/*
Insertion sort linked list
*/
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode insertionSortList(ListNode head) {
        ListNode result = new ListNode(0);
        ListNode rPtr = result;
        ListNode cur = head;
        while (cur != null) {
            ListNode x = result;
            while (x.next != null && x.next.val < cur.val) {
                x = x.next;
            }
            ListNode temp = x.next;
            x.next = new ListNode(cur.val);
            x = x.next;
            x.next = temp;
            cur = cur.next;
        }
        return result.next;
    }
}
