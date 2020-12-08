
//将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
//
// 
//
// 示例： 
//
// 输入：1->2->4, 1->3->4
//输出：1->1->2->3->4->4
// 
// Related Topics 链表 
// 👍 1417 👎 0


package per.yyz.leetcode.editor.cn;

import com.google.gson.Gson;

/**
 * Java: 合并两个有序链表
 * Difficulty: easy
 * Date: 2020-12-03 17:55:56
 */
public class P21MergeTwoSortedLists {
    public static void main(String[] args) {
        Gson gson = new Gson();
        Solution solution = new P21MergeTwoSortedLists().new Solution();
        ListNode l1 = new ListNode(1, new ListNode(2, new ListNode(4)));
        ListNode l2 = new ListNode(1, new ListNode(3, new ListNode(4)));
        System.out.println(gson.toJson(solution.mergeTwoLists(l1, l2)));
    }
//leetcode submit region begin(Prohibit modification and deletion)

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode() {}
     * ListNode(int val) { this.val = val; }
     * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    class Solution {
        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            ListNode result = new ListNode();
            ListNode temp = result;
            while (l1 != null && l2 != null) {
                if (l1.val < l2.val) {
                    temp.next = new ListNode(l1.val);
                    l1 = l1.next;
                } else {
                    temp.next = new ListNode(l2.val);
                    l2 = l2.next;
                }
                temp = temp.next;
            }
            temp.next = l1 == null ? l2 : l1;
            return result.next;
        }
    }

    class Solution01 {
        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            ListNode result = new ListNode();

            if (l1 != null && l2 != null) {
                if (l1.val > l2.val) {
                    result.val = l2.val;
                    l2 = l2.next;
                } else {
                    result.val = l1.val;
                    l1 = l1.next;
                }
            } else if (l1 == null) {
                return l2;
            } else {
                return l1;
            }
            result.next = mergeTwoLists(l1, l2);
            return result;

        }
    }

}
