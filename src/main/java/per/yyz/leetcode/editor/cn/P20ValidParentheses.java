
//给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。 
//
// 有效字符串需满足： 
//
// 
// 左括号必须用相同类型的右括号闭合。 
// 左括号必须以正确的顺序闭合。 
// 
//
// 注意空字符串可被认为是有效字符串。 
//
// 示例 1: 
//
// 输入: "()"
//输出: true
// 
//
// 示例 2: 
//
// 输入: "()[]{}"
//输出: true
// 
//
// 示例 3: 
//
// 输入: "(]"
//输出: false
// 
//
// 示例 4: 
//
// 输入: "([)]"
//输出: false
// 
//
// 示例 5: 
//
// 输入: "{[]}"
//输出: true 
// Related Topics 栈 字符串 
// 👍 2020 👎 0


package per.yyz.leetcode.editor.cn;

import java.util.*;

/**
 * Java: 有效的括号
 * Difficulty: easy
 * Date: 2020-12-02 17:38:51
 */
public class P20ValidParentheses {
    public static void main(String[] args) {
        Solution solution = new P20ValidParentheses().new Solution();
        System.out.println(solution.isValid("){"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isValid(String s) {
            if (s.length() % 2 == 1) {
                return false;
            }
            HashMap<Character, Character> map = new HashMap() {{
                put(')', '(');
                put(']', '[');
                put('}', '{');
            }};
            Deque<Character> deque = new LinkedList<>();
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (map.containsKey(c)) {
                    if (!deque.isEmpty() && map.get(c).equals(deque.peek())) {
                        deque.pop();
                    } else {
                        return false;
                    }
                } else {
                    deque.push(c);
                }
            }
            return deque.isEmpty();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    class Solution01 {
        public boolean isValid(String s) {
            Map<Character, Character> temp = new HashMap<>(16);
            temp.put('}', '{');
            temp.put(')', '(');
            temp.put(']', '[');
            LinkedList<Character> list = new LinkedList<>();
            if (s.length() % 2 == 1) {
                return false;
            }
            for (int i = 0; i < s.length(); i++) {
                char ch = s.charAt(i);
                if (temp.containsKey(ch)) {
                    if (list.contains(temp.get(ch)) && temp.get(ch).equals(list.getLast())) {
                        list.removeLast();
                    } else {
                        return false;
                    }
                } else {
                    list.addLast(ch);
                }
            }
            return list.size() == 0;
        }
    }

}
