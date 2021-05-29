public class L2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        helper(dummy, l1, l2, 0);
        return dummy.next;
    }

    void helper(ListNode prev, ListNode l1, ListNode l2, int carry) {
        if (l1 == null && l2 == null && carry == 0) {
            prev.next = null; return;
        }
        int tmp=carry;
        if (l1 != null) { tmp += l1.val; l1 = l1.next; }
        if (l2 != null) { tmp += l2.val; l2 = l2.next; }
        carry = tmp/10; tmp %= 10;
        ListNode next = new ListNode(tmp);
        prev.next = next;
        helper(next, l1, l2, carry);
    }
}
