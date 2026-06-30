class Solution {

    public ListNode reverseKGroup(ListNode head, int k) {

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode groupPrev = dummy;

        while (true) {

            ListNode kth = groupPrev;

            for (int i = 0; i < k && kth != null; i++) {
                kth = kth.next;
            }

            if (kth == null) {
                break;
            }

            ListNode groupNext = kth.next;

            ListNode prev = groupNext;
            ListNode current = groupPrev.next;

            while (current != groupNext) {

                ListNode nextNode = current.next;

                current.next = prev;

                prev = current;
                current = nextNode;
            }

            ListNode temp = groupPrev.next;

            groupPrev.next = kth;

            groupPrev = temp;
        }

        return dummy.next;
    }
}