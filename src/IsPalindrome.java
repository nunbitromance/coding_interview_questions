/*
is string palindrome? "abcba" => true, "aab" = false
*/
public static bool isPalindrome(string s)
{
	bool isPalindrome = true;
	
	int begin = 0; int end = s.length - 1;
	
	while (begin < end)
	{
		if (s[begin++] != s[end--])
		{
			isPalindrome = false;
			break;
		}
	}
	return isPalindrome;
}

/*
is linked list palindrome? 1->2->3->2->1 => true, 1->2->3->2->2 => false, 1->2->2->1 => true
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
    public boolean isPalindrome(ListNode head) {
        if (head == null) {
            return true;
        }
        
        ListNode first = head;
        ListNode second = head;
        
        while (second != null) {
            first = first.next;
            second = second.next;
            if (second != null) {
                second = second.next;
            }
        }
        
        ListNode revFirst = reverse(first);
        first = head;
        
        while (revFirst != null && first != null) {
            if (revFirst.val != first.val) {
                return false;
            }
            revFirst = revFirst.next;
            first = first.next;
        }
        
        return true;
    }
    
    private ListNode reverse(ListNode head) {
        ListNode cur = head;
        ListNode prev = null;
        
        while (cur != null) {
            ListNode temp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = temp;
        }
        
        return prev;
    }
}

/*
is integer a palindrome?
12321 -> true, 12333 -> false
*/
public static bool IsPalindrome(int n)
{
	int div = 1;
	int k = n;
	while (k)
	{
		k /= 10;
		div *= 10;
	}

	k = n;
	while (k > 0)
	{
		if (k % 10 != k / div)
		{
			return false;
		}
		// 12321 % 10000 = 2321
		k %= div;
		// 1000
		div /= 10;
	}
	return true;
}
