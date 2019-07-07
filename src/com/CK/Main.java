package com.CK;

import java.util.Collections;

public class Main {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l1_1 = new ListNode(2);
        ListNode l1_2 = new ListNode(3);
        ListNode l1_3 = new ListNode(4);
        //ListNode l1_4 = new ListNode(5);
        //l1_3.next = l1_4;
        l1_2.next = l1_3;
        l1_1.next = l1_2;
        l1.next = l1_1;

        Solution solution = new Solution();
        ListNode.printListNode(solution.reverseKGroup(l1, 2));
    }
}

class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode prevTail = dummyHead, nextHead = null, currentNode = dummyHead;
        ListNode[] listNodes = new ListNode[k];
        int counter = 0;
        while (currentNode.next != null) {
            currentNode = currentNode.next;
            counter++;
            if (counter % k != 0) listNodes[(counter % k) - 1] = currentNode;
            else {
                listNodes[k - 1] = currentNode;
                nextHead = currentNode.next;
                for (int i = 0; i < k - 1; i++) {
                    listNodes[k - 2].next = nextHead;
                    if (i == 0) prevTail.next = listNodes[k - 1];
                    else listNodes[i - 1].next = listNodes[k - 1];
                    listNodes[k - 1].next = listNodes[i];
                    ListNode temp = prevTail.next;
                    for (int j = 0; j < k; j++) {
                        listNodes[j] = temp;
                        temp = temp.next;
                    }
                }
                currentNode = listNodes[k - 1];
                prevTail = listNodes[k - 1];
            }
        }
        return dummyHead.next;
    }
}