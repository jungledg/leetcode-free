/**
 * @Author: gaozhengdong <gaozhengdong@corp.netease.com>
 * @Date: 2019/12/23 23:41
 */
public class TestJumpGame55 {

    public static void main(String[] args){

        Solution55 solution55 = new Solution55();

        int[] nums = new int[]{2,3,1,1,4};
        System.out.println(solution55.canJump(nums));

        int[] nums2 = new int[]{3,2,1,0,4};
        System.out.println(solution55.canJump(nums2));
    }

}


class Solution55 {
    public boolean canJump(int[] nums) {
//        boolean[] flags = new boolean[nums.length];
//        return canArrive(nums, nums.length-1, flags);
        int n = nums.length;
        int last = n - 1;
        for (int i = n - 2 ; i >= 0; i--) {

            if (i + nums[i] >= last) {
                last = i;
            }
        }
        return last <= 0;

    }

    private boolean canArrive(int[] nums,int index, boolean[] flags) {
        if (flags[index]) {
            return false;
        }
        if (index == 0) {
            return true;
        }

        for (int i = index - 1; i >=0 ; i--) {
            if(i + nums[i] >= index){
                 if (canArrive(nums, i, flags)){
                     return true;
                 } else {
                     flags[i] = true;
                 }
            }
        }

        return false;
    }
}