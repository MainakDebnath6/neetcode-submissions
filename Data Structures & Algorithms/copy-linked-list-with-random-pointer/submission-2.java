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
        Map<Node,Node> otc=new HashMap<>();
        otc.put(null,null);
        Node curr=head;
        while(curr!=null){
            Node copy=new Node(curr.val);
            otc.put(curr,copy);
            curr=curr.next;
        }
        curr=head;
        while(curr!=null){
            Node copy=otc.get(curr);
            copy.next=otc.get(curr.next);
            copy.random=otc.get(curr.random);
            curr=curr.next;
        }
        return otc.get(head);
    }
}
