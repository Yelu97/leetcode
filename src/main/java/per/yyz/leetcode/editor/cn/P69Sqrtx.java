
//实现 int sqrt(int x) 函数。 
//
// 计算并返回 x 的平方根，其中 x 是非负整数。 
//
// 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。 
//
// 示例 1: 
//
// 输入: 4
//输出: 2
// 
//
// 示例 2: 
//
// 输入: 8
//输出: 2
//说明: 8 的平方根是 2.82842..., 
//     由于返回类型是整数，小数部分将被舍去。
// 
// Related Topics 数学 二分查找 
// 👍 558 👎 0


package per.yyz.leetcode.editor.cn;

/**
 * Java: x 的平方根
 * Difficulty: easy
 * Date: 2020-12-18 11:04:27
 */
public class P69Sqrtx {
    public static void main(String[] args) {
        Solution solution = new P69Sqrtx().new Solution();
        System.out.println(solution.mySqrt(8));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int mySqrt(int x) {
            int pow = (int) Math.pow(x, 0.5);
            return (pow + 1 * pow + 1) <= x ? pow + 1 : pow;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    class Solution02 {
        public int mySqrt(int x) {
            if (x == 0) {
                return 0;
            }
            int left = 0;
            int right = x;
            do {
                int mid = right - (right - left) / 2;
                if (mid > x / mid) {
                    right = mid;
                } else if (mid < x / mid) {
                    left = mid;
                } else {
                    return mid;
                }
            } while (right - left > 1);
            return left;
        }
    }

    class Solution01 {
        public int mySqrt(int x) {
            return (int) Math.sqrt(x);
        }
    }
}
