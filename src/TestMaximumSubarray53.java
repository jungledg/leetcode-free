/**
 * @Author: gaozhengdong <gaozhengdong@corp.netease.com>
 * @Date: 2019/12/19 23:50
 */
public class TestMaximumSubarray53 {

    public static void main(String[] args){
        int[] nums = new int[]{-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(new Solution53().maxSubArray(nums));
    }

}

class Solution53 {
    public int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];

        dp[0] = nums[0];
        int max = dp[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = dp[i-1] > 0 ? dp[i-1] + nums[i] : nums[i];
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}