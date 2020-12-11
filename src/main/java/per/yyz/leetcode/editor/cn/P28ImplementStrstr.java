
//实现 strStr() 函数。 
//
// 给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如
//果不存在，则返回 -1。 
//
// 示例 1: 
//
// 输入: haystack = "hello", needle = "ll"
//输出: 2
// 
//
// 示例 2: 
//
// 输入: haystack = "aaaaa", needle = "bba"
//输出: -1
// 
//
// 说明: 
//
// 当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。 
//
// 对于本题而言，当 needle 是空字符串时我们应当返回 0 。这与C语言的 strstr() 以及 Java的 indexOf() 定义相符。 
// Related Topics 双指针 字符串 
// 👍 640 👎 0


package per.yyz.leetcode.editor.cn;

/**
 * Java: 实现 strStr()——滑动窗口
 * Difficulty: easy
 * Date: 2020-12-10 16:41:29
 */
public class P28ImplementStrstr {
    public static void main(String[] args) {
        Solution solution = new P28ImplementStrstr().new Solution();
        System.out.println(solution.strStr("mississippi", "mississippi"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int strStr(String haystack, String needle) {
            int pn = 0;
            int curryLength = 0;
            if (needle.length() == 0) {
                return 0;
            }
            for (int ph = 0; ph < haystack.length(); ph++) {
                if (haystack.charAt(ph) == needle.charAt(pn)) {
                    curryLength++;
                    pn++;
                } else {
                    ph -= curryLength;
                    pn = 0;
                    curryLength = 0;
                }
                if (curryLength == needle.length()) {
                    return ph - curryLength + 1;
                }
            }
            return -1;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)


    class Solution01 {
        public int strStr(String haystack, String needle) {
            if (needle.length() == 0) {
                return 0;
            }
            if (needle.length() > haystack.length()) {
                return -1;
            }
            for (int i = 0; i < haystack.length() && haystack.length() >= i + needle.length(); i++) {
                if (haystack.startsWith(needle, i)) {
                    return i;
                }

            }
            return -1;
        }
    }
}
