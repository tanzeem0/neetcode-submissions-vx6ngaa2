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
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null) return null;
        int cnt = 0;
        ListNode curr = head;
        while(curr!= null && cnt<k){
            cnt++;
            curr = curr.next;
        }
        if(cnt < k) return head;
        ListNode nextNode = curr;
        ListNode prev = null;
        curr = head;
        while(cnt!=0){
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
            cnt--;
        }
        head.next = reverseKGroup(nextNode,k);
        return prev;
    }
}