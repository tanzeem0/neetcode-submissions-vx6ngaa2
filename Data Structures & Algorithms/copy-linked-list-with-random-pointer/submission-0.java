/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if(head == null) return head;
        Node curr = head;
        while(curr!=null){
            Node copyNode = new Node(curr.val);
            copyNode.next = curr.next;
            curr.next = copyNode;
            curr = curr.next.next;
        }
        curr = head;
        while(curr!=null){
            if(curr.random!=null){
                curr.next.random = curr.random.next;
            }
            curr = curr.next.next;
        }
        Node newhead = head.next;
        curr = head;
        Node curr2 = newhead;
        while(curr2!=null && curr2.next!=null){
            curr.next = curr.next.next;
            curr = curr.next;
            curr2.next = curr2.next.next;
            curr2 = curr2.next;
        }
        curr.next = null;
        return newhead;
    }
}