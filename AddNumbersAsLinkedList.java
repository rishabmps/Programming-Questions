/**
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
public class Solution {
	public ListNode addTwoNumbers(ListNode a, ListNode b) {
	    if(a==null){
	        return b;
	    }
	    else if(b == null){
	        return a;
	    }
	    ListNode temp = a;
	    ListNode temp2 = b;
	    int carry = 0;
	    int sum=0;
	    ListNode head = new ListNode(0);
	    ListNode temp3 = head;
	    while(temp!=null || temp2!=null){
	        if(temp!=null && temp2!=null){
	            sum = temp.val+temp2.val+carry;
	            temp = temp.next;
	            temp2 = temp2.next;
	        }
	        else if(temp==null && temp2!=null){
	            sum = temp2.val +carry;
	             temp2 = temp2.next;

	        }
	        else if(temp!=null && temp2==null){
	            sum = temp.val +carry;
	             temp = temp.next;
	        }

	        temp3.next = new ListNode(sum%10);
	        carry = sum/10;
	        temp3 = temp3.next;

	    }
	    if(carry!=0){
	        temp3.next = new ListNode(carry);
	    }
	    return head.next;

	}
}
