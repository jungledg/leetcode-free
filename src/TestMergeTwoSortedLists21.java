public class TestMergeTwoSortedLists21 {
    public static void main(String[] args){
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(1);
        ListNode l3 = new ListNode(2);
        ListNode l4 = new ListNode(3);
        ListNode l5 = new ListNode(4);
        ListNode l6 = new ListNode(4);
        l1.next = l3;
        l3.next = l5;
        l2.next = l4;
        l4.next = l6;
        Solution21 solution21 = new Solution21();
        ListNode res = solution21.mergeTwoLists(l1, l2);
        while(res != null) {
            System.out.println(res.val);
            res = res.next;
        }

    }

}

class Solution21 {
    ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        ListNode head;
        ListNode now = new ListNode(0);
        head = now;
        while (l1 != null || l2 != null) {
            if (l1 == null) {
                now.next = l2;
                break;
            }
            if (l2 == null) {
                now.next = l1;
                break;
            }
            if (l1.val > l2.val) {
                now.next = l2;
                l2 = l2.next;
            } else {
                now.next = l1;
                l1 = l1.next;
            }
            now = now.next;
        }
        return head.next;

    }
}


class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}