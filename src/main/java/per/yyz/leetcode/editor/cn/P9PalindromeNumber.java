
//判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。 
//
// 示例 1: 
//
// 输入: 121
//输出: true
// 
//
// 示例 2: 
//
// 输入: -121
//输出: false
//解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
// 
//
// 示例 3: 
//
// 输入: 10
//输出: false
//解释: 从右向左读, 为 01 。因此它不是一个回文数。
// 
//
// 进阶: 
//
// 你能不将整数转为字符串来解决这个问题吗？ 
// Related Topics 数学 
// 👍 1322 👎 0


package per.yyz.leetcode.editor.cn;

/**
 * Java: 回文数
 * Difficulty: easy
 * Date: 2020-11-27 16:13:36
 */
public class P9PalindromeNumber {
    public static void main(String[] args) {
        Solution solution = new P9PalindromeNumber().new Solution();
        System.out.println(solution.isPalindrome(121));
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isPalindrome(int x) {
            String str = String.valueOf(x);
            StringBuilder str1 = new StringBuilder(str).reverse();
            return str.equals(str1.toString());
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    class Solution02 {
        public boolean isPalindrome(int x) {
            String str = String.valueOf(x);
            for (int i = 0; i < str.length() / 2; i++) {
                if (str.charAt(i) != str.charAt(str.length() - i - 1)) {
                    return false;
                }
            }
            return true;
        }
    }

    class Solution01 {
        public boolean isPalindrome(int x) {
            if (x < 0) {
                return false;
            }
            int tmp = x;
            int result = 0;
            do {
                result = result * 10 + x % 10;
                x /= 10;
            } while (x != 0);
            return result == tmp;
        }
    }
}
