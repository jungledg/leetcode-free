/**
 * @Author: gaozhengdong <gaozhengdong@corp.netease.com>
 * @Date: 2020/1/13 7:59 PM
 */

/**
 *
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
 *
 * (i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).
 *
 * You are given a target value to search. If found in the array return its index, otherwise return -1.
 *
 * You may assume no duplicate exists in the array.
 *
 * Your algorithm's runtime complexity must be in the order of O(log n).
 *
 * Example 1:
 *
 * Input: nums = [4,5,6,7,0,1,2], target = 0
 * Output: 4
 * Example 2:
 *
 * Input: nums = [4,5,6,7,0,1,2], target = 3
 * Output: -1
 *
 */

public class TestSearchInRotatedSortedArray {

    public static void main(String[] args){

        Solution33 solution33 = new Solution33();

        int[] nums = new int[]{4,5,6,7,0,1,2};


        System.out.println(solution33.search(nums, 0));

        System.out.println(solution33.search(nums, 3));

        int[] numsTest2 = new int[]{1,3};
        System.out.println(solution33.search1(numsTest2, 3));
        int[] numsTest3 = new int[]{8,9,2,3,4};
        System.out.println(solution33.search1(numsTest3, 9));
        int[] numsTest4 = new int[]{4,5,6,7,0,1,2};
        System.out.println(solution33.search1(numsTest4, 7));

        int[] numsTest5 = new int[]{1};
        System.out.println(solution33.search1(numsTest5, 1));
    }

}


class Solution33 {
    public int search(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] == target){
                return i;
            }
        }
        return -1;
    }

    public int search1(int[] nums, int target) {
        if (nums.length < 1){
            return -1;
        }
        int start = findStart(nums);
        int end;
        if (nums[start] == target) {
            return start;
        }

        if (nums[nums.length-1] < target){
            end = start - 1;
            start = 0;
        }else {
            end = nums.length - 1;
        }

        while (start <= end){
            int mid = start + (end - start) / 2;
            if (nums[mid] > target) {
                end = mid - 1;
            }else if (nums[mid] < target) {
                start = mid + 1;
            }else {
                return mid;
            }
        }
        return -1;

    }

    private int findStart(int[] nums){
        int start = 0;
        int end = nums.length - 1;
        int mid = 0;
        while (start < end) {
            mid = start + (end - start) / 2;
            if (nums[mid] < nums[end]){
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return start;
    }


}