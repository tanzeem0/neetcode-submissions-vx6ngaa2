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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummyNode = new ListNode(-1,head);
        ListNode e = head,s = head,p = dummyNode;
        while(n!=0){
            e = e.next;
            n--;
        }
        while(e!=null){
            s = s.next;
            e = e.next;
            p = p.next;
        }
        p.next = s.next;
        return dummyNode.next;
    }
}