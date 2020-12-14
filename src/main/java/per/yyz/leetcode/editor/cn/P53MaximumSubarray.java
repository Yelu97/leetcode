
//给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。 
//
// 示例: 
//
// 输入: [-2,1,-3,4,-1,2,1,-5,4]
//输出: 6
//解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
// 
//
// 进阶: 
//
// 如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。 
// Related Topics 数组 分治算法 动态规划 
// 👍 2708 👎 0


package per.yyz.leetcode.editor.cn;

import java.util.Arrays;

/**
 * Java: 最大子序和
 * Difficulty: easy
 * Date: 2020-12-11 18:01:05
 */
public class P53MaximumSubarray {
    public static void main(String[] args) {
        Solution01 solution = new P53MaximumSubarray().new Solution01();
        System.out.println(solution.maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
    }

    class Solution {
        public int maxSubArray(int[] nums) {
            int max = 0;
            int result = nums[0];
            for (int num : nums) {
                max = Math.max(max + num, num);
                result = Math.max(result, max);
            }
            return result;
        }
    }

    //leetcode submit region begin(Prohibit modification and deletion)    
    @Deprecated
    class Solution01 {
        public int maxSubArray(int[] nums) {
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < nums.length; i++) {
                int temp = 0;
                for (int j = i; j < nums.length; j++) {
                    temp += nums[j];
                    max = Math.max(temp, max);
                }
            }
            return max;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)
}
