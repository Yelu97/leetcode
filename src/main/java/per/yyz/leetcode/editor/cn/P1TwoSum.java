
//给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。 
//
// 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。 
//
// 
//
// 示例: 
//
// 给定 nums = [2, 7, 11, 15], target = 9
//
//因为 nums[0] + nums[1] = 2 + 7 = 9
//所以返回 [0, 1]
// 
// Related Topics 数组 哈希表 
// 👍 9677 👎 0


package per.yyz.leetcode.editor.cn;

import java.util.HashMap;

/**
 *Java: 两数之和
 *Difficulty: easy
 *Date: 2020-11-24 14:44:26
 * 
 */
public class P1TwoSum{
    public static void main(String[] args) {
        Solution solution = new P1TwoSum().new Solution(); 
        int[] nums = new int[]{2,2,3};
        for (int i : solution.twoSum(nums, 5)) {
            System.out.println(i);
        }
    }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            int temp = target - nums[i];
            for (int j = i+1; j < nums.length; j++) {
                if(nums[j] == temp){
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{};
    }
}
//leetcode submit region end(Prohibit modification and deletion)
    class Solution01 {
        public int[] twoSum(int[] nums, int target) {
            HashMap<Integer,Integer> hashMap = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                int temp = target - nums[i];
                if(hashMap.containsKey(temp)){
                    return new int[]{i,hashMap.get(temp)};
                }
                hashMap.put(nums[i],i);
            }
            return new int[]{};
        }
    }



}
