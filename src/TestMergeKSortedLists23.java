public class TestMergeKSortedLists23 {

    public static void main(String[] args){
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(4);
        ListNode l3 = new ListNode(5);
        ListNode l4 = new ListNode(1);
        ListNode l5 = new ListNode(3);
        ListNode l6 = new ListNode(4);
        ListNode l7 = new ListNode(2);
        ListNode l8 = new ListNode(6);
        l1.next = l2;
        l2.next = l3;
        l4.next = l5;
        l5.next = l6;
        l7.next = l8;
        Solution23 solution23 = new Solution23();
        ListNode[] nodes = new ListNode[]{l1,l4,l7};
        ListNode res = solution23.mergeKLists(nodes);
        while(res != null){
            System.out.println(res.val);
            res = res.next;
        }
    }

}


class Solution23 {
    public ListNode mergeKLists(ListNode[] lists) {

        if (lists.length == 0) {
            return null;
        }
        if (lists.length == 1){
            return lists[0];
        }

        ListNode head = new ListNode(0);
        ListNode minNode = head;

        boolean flag = true;
        while (flag) {
            flag = false;
            int min = 0;
            boolean add = false;
            for (int i = 0; i < lists.length; i++) {
                if(lists[i] != null && !add) {
                    flag = true;
                    add = true;
                    min = i;
                }
                if(lists[i] == null){
                    continue;
                }
                if(lists[i].val < lists[min].val){
                    min = i;
                }
            }

            minNode.next = lists[min];
            minNode = minNode.next;
            if (lists[min] == null) {
                break;
            }
            lists[min] = lists[min].next;

        }
        return head.next;

    }
}
