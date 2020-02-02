/**
 * @Author: gaozhengdong <gaozhengdong@corp.netease.com>
 * @Date: 2020/1/27 5:52 下午
 */

//Given a linked list, remove the n-th node from the end of list and return its
//head.
//
// Example:
//
//
//Given linked list: 1->2->3->4->5, and n = 2.
//
//After removing the second node from the end, the linked list becomes 1->2->3->
//5.
//
//
// Note:
//
// Given n will always be valid.
//
// Follow up:
//
// Could you do this in one pass?
// Related Topics Linked List Two Pointers


//leetcode submit region begin(Prohibit modification and deletion)

import java.util.List;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */
class Solution19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {

        int length = 0;
        ListNode node = head;
        while (node != null) {
            node = node.next;
            length++;
        }
        int removeNum = length - n;
        int i = 0;
        ListNode firstNode = new ListNode(0);
        firstNode.next = head;
        ListNode resNode = firstNode;
        while (i < removeNum) {
            resNode = resNode.next;
            i++;
        }
        ListNode tmpNode = resNode.next;

        resNode.next = tmpNode.next;

        return firstNode.next;

    }

    public ListNode removeNthFromEnd1(ListNode head, int n){

        int zone = n + 1;

        zone = Math.max(zone, 3);

        ListNode[] nodes = new ListNode[zone];

        ListNode tmp = head;
        int length = 0;
        while (tmp != null){
            int hash = length % zone;
            length++;
            nodes[hash] = tmp;
            tmp = tmp.next;
        }

        if (length == 1) {
            return null;
        }

//        for (int i = (length - n) % zone ; i < zone; i++) {
//            nodes[i] = null;
//        }

        ListNode pre = nodes[(length - n - 1) % zone];
        ListNode last = nodes[(length - n + 1) % zone];

        pre.next = last;

        return head;

    }


    public ListNode removeNthFromEnd2(ListNode head,int n){

        ListNode first = new ListNode(0);
        first.next = head;
        ListNode slow = first;
        ListNode result = first;
        for (int i = 0; i < n ; i++) {
            first = first.next;
        }

        while (first.next != null){
            slow = slow.next;
            first = first.next;
        }

        slow.next = slow.next.next;

        return result.next;

    }


}


public class TestRemoveNthNodeFromEndOfList19 {

    public static void main(String[] args) {


        Solution19 solution19 = new Solution19();
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = null;

        node1 = solution19.removeNthFromEnd2(node1, 2);

        while (node1 != null) {
            System.out.println(node1.val);
            node1 = node1.next;
        }

        ListNode node7 = new ListNode(7);
        node7 = solution19.removeNthFromEnd2(node7, 1);
        while (node7 != null) {
            System.out.println(node7.val);
            node7 = node7.next;
        }
        System.out.println(node7);


        ListNode node8 = new ListNode(8);
        ListNode node9 = new ListNode(9);
        node8.next = node9;
        node9.next = null;
        node8 = solution19.removeNthFromEnd2(node8,1);
        System.out.println(node8);
        while (node8 != null) {
            System.out.println(node8.val);
            node8 = node8.next;
        }

    }

}
