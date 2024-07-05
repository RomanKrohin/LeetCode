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
    public int[] nodesBetweenCriticalPoints(ListNode head) {
      int[] distances= {-1, -1};
        int tmp = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(head.val);
        head =  head.next;
        Stack<Integer> conditions = new Stack<>();
        conditions.push(0);
        ArrayList<Integer> list = new ArrayList<>();
        int previously = 0;
        while (head!=null) {
            if (head.val > stack.peek()){
                if (conditions.peek()==-1){
                    list.add(tmp);
                    if ((tmp-previously<distances[0] || distances[0]==-1) && list.size()>1){
                        distances[0]=tmp-previously;
                    }
                    previously=tmp;
                }
                conditions.push(1);
            }
            if (head.val < stack.peek()){
                if (conditions.peek()==1){
                    list.add(tmp);
                    if ((tmp-previously<distances[0] || distances[0]==-1) && list.size()>1){
                        distances[0]=tmp-previously;
                    }
                    previously=tmp;
                }
                conditions.push(-1);
            }
            if (head.val==stack.peek()){
                conditions.push(0);
            }
            stack.push(head.val);
            head = head.next;
            tmp++;
        }
        if (list.size()>1){
            distances[1]=list.get(list.size()-1)-list.get(0);
        }
        return distances;
    }
}