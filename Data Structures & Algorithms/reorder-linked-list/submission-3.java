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
    public void reorderList(ListNode head) {
        ListNode slow=head;
        ListNode fast=head;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        ListNode head1=slow.next;
        slow.next=null;
        ListNode prev=null;
        while(head1!=null){
            ListNode next=head1.next;
            head1.next=prev;
            prev=head1;
            head1=next;
        }
        ListNode first=head;
        ListNode second=prev;
        while(second!=null){
            ListNode tmp1=first.next;
            ListNode tmp2=second.next;
            first.next=second;
            second.next=tmp1;
            first=tmp1;
            second=tmp2;
        }
    }
}
