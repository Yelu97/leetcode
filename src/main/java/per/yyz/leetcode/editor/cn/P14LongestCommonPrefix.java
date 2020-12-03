
//编写一个函数来查找字符串数组中的最长公共前缀。 
//
// 如果不存在公共前缀，返回空字符串 ""。 
//
// 示例 1: 
//
// 输入: ["flower","flow","flight"]
//输出: "fl"
// 
//
// 示例 2: 
//
// 输入: ["dog","racecar","car"]
//输出: ""
//解释: 输入不存在公共前缀。
// 
//
// 说明: 
//
// 所有输入只包含小写字母 a-z 。 
// Related Topics 字符串 
// 👍 1365 👎 0


package per.yyz.leetcode.editor.cn;

import java.util.*;

/**
 * Java: 最长公共前缀
 * Difficulty: easy
 * Date: 2020-12-02 16:23:05
 */
public class P14LongestCommonPrefix {
    public static void main(String[] args) {
        Solution solution = new P14LongestCommonPrefix().new Solution();
        String[] strs = new String[]{"dog", "racecar", "car"};
        System.out.println(solution.longestCommonPrefix(strs));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String longestCommonPrefix(String[] strs) {
            String result = Arrays.stream(strs).min(Comparator.comparing(String::length)).orElse("");
            for (int length = result.length(); length > 0; length--) {
                for (String str : strs) {
                    if (!str.startsWith(result)) {
                        result = result.substring(0, result.length() - 1);
                        break;
                    }
                }
            }
            return result;
        }
    }

    //leetcode submit region end(Prohibit modification and deletion)
    class Solution01 {
        public String longestCommonPrefix(String[] strs) {
            String result = new String();
            int minLength = Arrays.stream(strs).min(Comparator.comparing(String::length)).orElse("").length();
            for (int i = 0; i < minLength; i++) {
                String preStr = strs[0].substring(0, i + 1);
                for (int j = 1; j < strs.length; j++) {
                    String str = strs[j].substring(0, i + 1);
                    if (preStr.equals(str)) {
                        continue;
                    } else {
                        return result;
                    }

                }
                result = preStr;
            }
            return result;
        }

    }
}
