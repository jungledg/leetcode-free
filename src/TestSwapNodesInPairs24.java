public class TestSwapNodesInPairs24 {

    public static void main(String[] args){
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        Solution24 solution = new Solution24();
        ListNode node = solution.swapPairs(l1);

        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }
    }
}

class Solution24 {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }
        ListNode node = new ListNode(0);
        node.next = head;
        ListNode p = node;
        while(head != null && head.next != null) {
          ListNode o = head.next;

          head.next = o.next;

          o.next = head;

          p.next = o;

          p = head;

          head = head.next;
        }
        return node.next;
    }
}