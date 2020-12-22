
//给你两个二进制字符串，返回它们的和（用二进制表示）。 
//
// 输入为 非空 字符串且只包含数字 1 和 0。 
//
// 
//
// 示例 1: 
//
// 输入: a = "11", b = "1"
//输出: "100" 
//
// 示例 2: 
//
// 输入: a = "1010", b = "1011"
//输出: "10101" 
//
// 
//
// 提示： 
//
// 
// 每个字符串仅由字符 '0' 或 '1' 组成。 
// 1 <= a.length, b.length <= 10^4 
// 字符串如果不是 "0" ，就都不含前导零。 
// 
// Related Topics 数学 字符串 
// 👍 531 👎 0


package per.yyz.leetcode.editor.cn;

/**
 * Java: 二进制求和
 * Difficulty: easy
 * Date: 2020-12-17 16:52:42
 */
public class P67AddBinary {
    public static void main(String[] args) {
        Solution solution = new P67AddBinary().new Solution();
        System.out.println(solution.addBinary("10", "10"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String addBinary(String a, String b) {
            int maxlength = Math.max(a.length(), b.length());
            int carray = 0;
            StringBuffer result = new StringBuffer();
            for (int i = 0; i < maxlength; i++) {
                carray += a.length() - i > 0 ? a.charAt(a.length() - 1 - i) - '0' : 0;
                carray += b.length() - i > 0 ? b.charAt(b.length() - 1 - i) - '0' : 0;
                result.insert(0, carray % 2);
                carray /= 2;
            }
            if (carray > 0) {
                result.insert(0, 1);
            }
            return result.toString();
        }
    }

    //leetcode submit region end(Prohibit modification and deletion)

    class Solution02 {
        public String addBinary(String a, String b) {
            return Integer.toBinaryString(
                    Integer.parseInt(a, 2) + Integer.parseInt(b, 2)
            );
        }
    }

    class Solution01 {
        public String addBinary(String a, String b) {
            StringBuffer result = new StringBuffer();
            int index = 0;
            int carry = 0;
            while (a.length() - 1 - index >= 0 || b.length() - 1 - index >= 0) {
                int sum;
                if (a.length() - 1 - index < 0) {
                    sum = Integer.parseInt(String.valueOf(b.charAt(b.length() - 1 - index))) + carry;
                } else if (b.length() - 1 - index < 0) {
                    sum = Integer.parseInt(String.valueOf(a.charAt(a.length() - 1 - index))) + carry;
                } else {
                    sum = Integer.parseInt(String.valueOf(a.charAt(a.length() - 1 - index))) + Integer.valueOf(String.valueOf(b.charAt(b.length() - 1 - index))) + carry;
                }
                int temp = sum % 2;
                carry = sum / 2;
                result.insert(0, temp);
                index++;
            }
            if (carry > 0) {
                result.insert(0, 1);
            }
            return result.toString();
        }
    }
}
