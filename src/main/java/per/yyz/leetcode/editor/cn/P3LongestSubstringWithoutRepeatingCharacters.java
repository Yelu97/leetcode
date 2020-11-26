
//给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。 
//
// 
//
// 示例 1: 
//
// 
//输入: s = "abcabcbb"
//输出: 3 
//解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
// 
//
// 示例 2: 
//
// 
//输入: s = "bbbbb"
//输出: 1
//解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
// 
//
// 示例 3: 
//
// 
//输入: s = "pwwkew"
//输出: 3
//解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
//     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
// 
//
// 示例 4: 
//
// 
//输入: s = ""
//输出: 0
// 
//
// 
//
// 提示： 
//
// 
// 0 <= s.length <= 5 * 104 
// s 由英文字母、数字、符号和空格组成 
// 
// Related Topics 哈希表 双指针 字符串 Sliding Window 
// 👍 4627 👎 0


package per.yyz.leetcode.editor.cn;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * Java: 无重复字符的最长子串
 * Difficulty: medium
 * Date: 2020-11-25 17:28:35
 */
public class P3LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        Solution solution = new P3LongestSubstringWithoutRepeatingCharacters().new Solution();
        System.out.println(solution.lengthOfLongestSubstring("anviaj"));

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int lengthOfLongestSubstring(String s) {
            int result = 0;
            int start = 0;
            int[] index = new int[128];
            for (int i = 0; i < s.length(); i++) {
                start = Math.max(index[s.charAt(i)], start);
                result = Math.max(result, i - start + 1);
                index[s.charAt(i)] = i + 1;

            }
            return result;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    class Solution02 {
        public int lengthOfLongestSubstring(String s) {
            int result = 0;
            char[] strs = s.toCharArray();
            for (int i = 0; i < strs.length; i++) {
                HashSet set = new HashSet<Character>();
                for (int j = i; j < strs.length; j++) {
                    if (!set.add(strs[j])) {
                        break;
                    }
                }
                result = Math.max(result, set.size());
            }
            return result;
        }
    }

    class Solution01 {
        public int lengthOfLongestSubstring(String s) {
            int result = 0;
            Map<Character, Integer> hash = new HashMap<>();
            int start = 0;
            char[] chars = s.toCharArray();
            for (int end = 0; end < chars.length; end++) {
                char oneChar = chars[end];
                if (hash.containsKey(oneChar)) {
                    start = Math.max(hash.get(oneChar), start);
                }
                result = Math.max(end - start + 1, result);
                hash.put(oneChar, end + 1);
            }
            return result;
        }
    }

}
