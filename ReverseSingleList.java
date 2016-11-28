/**
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
public class Solution {
    public int lPalin(ListNode A) {
        ListNode slow,fast,prev_slow,mid;
        slow = A; fast = A;
        prev_slow = A;
        if(A!=null && A.next!=null){


        while(fast!=null && fast.next!=null){
            fast = fast.next.next;
            prev_slow = slow;
            slow = slow.next;
        }
        if(fast != null){
            mid = slow;
            slow = slow.next;
        }
        prev_slow.next = null;


        return compareList(A ,reverse(slow));
        }
        return 1;
    }
    public static ListNode reverse(ListNode A){
        ListNode prev = null;
        ListNode current = A;
        ListNode next = null;
        while(current!=null){
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }

    public static int compareList(ListNode head1, ListNode head2)
    {
        ListNode temp1 = head1;
        ListNode temp2 = head2;

        while (temp1 != null && temp2 != null)
        {
            if (temp1.val == temp2.val)
            {
                temp1 = temp1.next;
                temp2 = temp2.next;
            } else
                return 0;
        }

        /* Both are empty reurn 1*/
        if (temp1 == null && temp2 == null)
            return 1;

        /* Will reach here when one is NULL
           and other is not */
        return 0;
    }
}
