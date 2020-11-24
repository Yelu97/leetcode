
//给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。 
//
// 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。 
//
// 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。 
//
// 示例： 
//
// 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
//输出：7 -> 0 -> 8
//原因：342 + 465 = 807
// 
// Related Topics 链表 数学 
// 👍 5292 👎 0


package per.yyz.leetcode.editor.cn;

import com.google.gson.Gson;

import java.io.Serializable;

/**
 *Java: 两数相加
 *Difficulty: medium
 *Date: 2020-11-24 15:48:05
 * 
 */
public class P2AddTwoNumbers{
    public static void main(String[] args) {
        
        Gson gson = new Gson();
        Solution solution = new P2AddTwoNumbers().new Solution();
        
        ListNode listNode = new P2AddTwoNumbers().new ListNode(9);
        //listNode = new P2AddTwoNumbers().new ListNode(9,listNode);
       
        System.out.println(gson.toJson(listNode));


        ListNode listNode1 = new P2AddTwoNumbers().new ListNode(9);
        //listNode1 = new P2AddTwoNumbers().new ListNode(6,listNode1);
        //listNode1= new P2AddTwoNumbers().new ListNode(5,listNode1);
        System.out.println(gson.toJson(listNode1));

        System.out.println(gson.toJson(solution.addTwoNumbers(listNode, listNode1)));
    }
/**
 * Definition for singly-linked list. */
 class ListNode implements Serializable {
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode();
        int val = l1.val + l2.val;
        result.val = val % 10;
        if(l1.next == null && l2.next == null){
            if(val/10 > 0){
                result.next = new ListNode(1);
            }
            return result;
        }
        if(l1.next == null){
            l1.next = new ListNode(0);    
        }
        if(l2.next == null){
            l2.next = new ListNode(0);
        }
        if((val / 10)> 0){
            l1.next.val++;
        }
        result.next = addTwoNumbers(l1.next,l2.next);
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
