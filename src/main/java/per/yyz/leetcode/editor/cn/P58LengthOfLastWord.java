
//给定一个仅包含大小写字母和空格 ' ' 的字符串 s，返回其最后一个单词的长度。如果字符串从左向右滚动显示，那么最后一个单词就是最后出现的单词。 
//
// 如果不存在最后一个单词，请返回 0 。 
//
// 说明：一个单词是指仅由字母组成、不包含任何空格字符的 最大子字符串。 
//
// 
//
// 示例: 
//
// 输入: "Hello World"
//输出: 5
// 
// Related Topics 字符串 
// 👍 262 👎 0


package per.yyz.leetcode.editor.cn;
/**
 *Java: 最后一个单词的长度
 *Difficulty: easy
 *Date: 2020-12-14 15:00:45
 * 
 */
public class P58LengthOfLastWord{
    public static void main(String[] args) {
        Solution solution = new P58LengthOfLastWord().new Solution();
        System.out.println(solution.lengthOfLastWord("hello  workd "));
    }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int lengthOfLastWord(String s) {
        int result = 0;
        for (int length = s.length() -1; length >= 0; length--) {
            if(s.charAt(length) != ' '){
                result++;    
                continue;
            }
            if(s.charAt(length) == ' ' && result != 0){
                return result;
            }
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

    class Solution01 {
        public int lengthOfLastWord(String s) {
            String[] strs = s.split(" ");
            if(strs.length > 0){
                return strs[strs.length-1].length();
            }
            return 0;
        }
    }

}
