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
    public ListNode deleteDuplicates(ListNode head) {
        ListNode tmp= new ListNode(101);
        ListNode start = head;
        while (head!=null){
            if (tmp.val==head.val){
                tmp.next=head.next;
                head=head.next;
            }
            else {
                tmp=head;
                head = head.next;    
            }
            
        }

        return start;
    }
}