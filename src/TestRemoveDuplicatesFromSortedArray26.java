/**
 * @Author: gaozhengdong <gaozhengdong@corp.netease.com>
 * @Date: 2020/1/9 7:30 PM
 */
public class TestRemoveDuplicatesFromSortedArray26 {

    public static void main(String[] args){

        Solution26 solution26 = new Solution26();

        System.out.println(solution26.removeDuplicates(new int[]{0,0,1,1,1,2,2,3,3,4}));

    }

}



class Solution26 {
    public int removeDuplicates(int[] nums) {
        if(nums.length == 0) {
            return 0;
        }
        int length = 1;
        int tmp = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if(tmp != nums[i]) {
                nums[length++] = nums[i];
                tmp = nums[i];
            }
        }
        return length;
    }
}