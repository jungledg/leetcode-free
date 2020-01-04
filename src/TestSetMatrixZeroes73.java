/**
 * @Author: gaozhengdong <gaozhengdong@corp.netease.com>
 * @Date: 2020/1/4 19:06
 */

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in-place.
 * <p>
 * Example 1:
 * <p>
 * Input:
 * [
 * [1,1,1],
 * [1,0,1],
 * [1,1,1]
 * ]
 * Output:
 * [
 * [1,0,1],
 * [0,0,0],
 * [1,0,1]
 * ]
 * Example 2:
 * <p>
 * Input:
 * [
 * [0,1,2,0],
 * [3,4,5,2],
 * [1,3,1,5]
 * ]
 * Output:
 * [
 * [0,0,0,0],
 * [0,4,5,0],
 * [0,3,1,0]
 * ]
 * Follow up:
 * <p>
 * A straight forward solution using O(mn) space is probably a bad idea.
 * A simple improvement uses O(m + n) space, but still not the best solution.
 * Could you devise a constant space solution?
 */

public class TestSetMatrixZeroes73 {

    public static void main(String[] args) {

        Solution73 solution73 = new Solution73();

        int[][] matrix = new int[][]{{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        solution73.setZeroes2(matrix);

        matrix = new int[][]{{0, 1, 2, 0}, {3, 4, 5, 2}, {1, 3, 1, 5}};
        solution73.setZeroes2(matrix);
    }

}

class Solution73 {
    public void setZeroes(int[][] matrix) {

        Set<Integer> rows = new HashSet<>();
        Set<Integer> columns = new HashSet<>();


        for (int column = 0; column < matrix.length; column++) {
            for (int row = 0; row < matrix[column].length; row++) {

                if (matrix[column][row] == 0) {
                    rows.add(row);
                    columns.add(column);
                }

            }
        }
        for (int column = 0; column < matrix.length; column++) {
            for (int row = 0; row < matrix[column].length; row++) {

                if (rows.contains(row) || columns.contains(column)) {
                    matrix[column][row] = 0;
                }

            }
        }


        System.out.println(Arrays.deepToString(matrix));
    }


    public void setZeroes1(int[][] matrix) {

        int colLen = matrix.length;
        int rowLen = matrix[0].length;

        Set<Integer> rows = new HashSet<>();
        Set<Integer> columns = new HashSet<>();


        for (int column = 0; column < colLen; column++) {
            for (int row = 0; row < rowLen; row++) {

                if (matrix[column][row] == 0) {
                    rows.add(row);
                    columns.add(column);
                }

            }
        }

        for (Integer i: rows) {
            for (int j = 0; j < colLen; j++) {
                matrix[j][i] = 0;
            }
        }
        for (Integer i: columns) {
            for (int j = 0; j < rowLen; j++) {
                matrix[i][j] = 0;
            }
        }


        System.out.println(Arrays.deepToString(matrix));
    }


    public void setZeroes2(int[][] matrix) {

        if (matrix.length < 1){
            return;
        }

        int colLen = matrix.length;
        int rowLen = matrix[0].length;

        boolean colNeedSetZero = false;
        boolean rowNeedSetZero = false;

        for (int i = 0; i < colLen; i++) {
            if (matrix[i][0] == 0){
                colNeedSetZero = true;
                break;
            }
        }

        for (int i = 0; i < rowLen; i++) {
            if (matrix[0][i] == 0){
                rowNeedSetZero = true;
                break;
            }
        }


        for (int i = 0; i < colLen; i++) {
            for (int j = 0; j < rowLen; j++) {
                if (matrix[i][j] == 0){
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }

        for (int i = 1; i < colLen; i++) {
            for (int j = 1; j < rowLen; j++) {
                if (matrix[0][j] == 0 || matrix[i][0] == 0){
                    matrix[i][j] = 0;
                }
            }
        }

        if (rowNeedSetZero){
            for (int i = 0; i < rowLen; i++) {
                matrix[0][i] = 0;
            }
        }

        if (colNeedSetZero){
            for (int i = 0; i < colLen; i++) {
                matrix[i][0] = 0;
            }
        }


        System.out.println(Arrays.deepToString(matrix));
    }

}
