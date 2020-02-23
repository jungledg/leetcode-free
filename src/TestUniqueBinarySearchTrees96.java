/**
 * @Author: gaozhengdong <gaozhengdong@corp.netease.com>
 * @Date: 2020/2/11 4:08 下午
 */


//Given n, how many structurally unique BST's (binary search trees) that store values 1 ... n?
//
// Example:
//
//
//Input: 3
//Output: 5
//Explanation:
//Given n = 3, there are a total of 5 unique BST's:
//
//   1         3     3      2      1
//    \       /     /      / \      \
//     3     2     1      1   3      2
//    /     /       \                 \
//   2     1         2                 3
//
// Related Topics Dynamic Programming Tree


public class TestUniqueBinarySearchTrees96 {

    public static void main(String[] args) {

        Solution96 solution96 = new Solution96();
        System.out.println(solution96.numTrees1(3));
        System.out.println(solution96.numTrees1(4));
        System.out.println(solution96.numTrees1(5));

    }

}


class Solution96 {

    public int numTrees(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }

        if (n == 2) {
            return 2;
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            int left = numTrees(i);
            int right = numTrees(n - i - 1);
            res += left * right;
        }

        return res;
    }

    public int numTrees1(int n) {
        int[] solved = new int[n + 1];
        solved[0] = 1;
        solved[1] = 1;
        return cal(solved, n);
    }

    private int cal(int[] solved, int n) {
        if (solved[n] != 0) {
            return solved[n];
        }

        int res = 0;

        for (int i = 0; i < n; i++) {
            int left = cal(solved, i);
            int right = cal(solved, n - i - 1);
            res += left * right;
        }
        solved[n] = res;
        return res;
    }


}
