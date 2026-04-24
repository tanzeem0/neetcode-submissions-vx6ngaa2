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
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0) return null;
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b)->a.val-b.val);
        for(ListNode node:lists){
            if(node!=null)
                pq.offer(node);
        }
        
        ListNode mergedListHead = null,mergePtr = null;
        while(!pq.isEmpty()){
            ListNode currList = pq.poll();
            if(mergedListHead == null){
                mergedListHead = mergePtr = currList;
            }else{
                mergePtr.next = currList;
                mergePtr = mergePtr.next;
            }
            currList = currList.next;
            if(currList!=null)
                pq.offer(currList);
        }
        return mergedListHead;
        
    }
}