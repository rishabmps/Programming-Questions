/**
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
public class Solution {
	public ListNode deleteDuplicates(ListNode a) {
	    if(a!= null && null!=a.next){
	        ListNode temp = a;
	        ListNode next,prev = a;
	        int val = -1;
	        while(temp!= null && temp.next!=null){

	            if(temp.val == temp.next.val){
	                val = temp.val;
	                while(temp.val == temp.next.val){

	                        temp = temp.next;
	                            if(temp.next==null){
	                                break;
	                            }

	                }
	                if(prev.val == val){
	                    a = temp.next;
	                    temp = a;
	                    prev = a;
	                    continue;
	                }
	                else{
	                    prev.next = temp.next;
	                    temp = temp.next;
	                    continue;
	                }

	            }



	            prev = temp;
	            temp = temp.next;



	        }
	        return a;
	    }
	    return a;
	}
}
