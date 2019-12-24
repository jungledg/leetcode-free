import java.util.LinkedList;
import java.util.List;

/**
 * @Author: gaozhengdong <gaozhengdong@corp.netease.com>
 * @Date: 2019/12/22 21:11
 */
public class TestSpiralMatrix54 {

    public static void main(String[] args){

        int[][] matrix = new int[][]{{ 1, 2, 3, 4} ,{ 5, 6 ,7, 8},{ 9,10,11,12}};

        Solution54 solution = new Solution54();


        solution.spiralOrder(matrix).forEach(System.out::println);
    }
}


class Solution54 {
    public List<Integer> spiralOrder(int[][] matrix) {

        List<Integer> results = new LinkedList<>();

        if(matrix.length == 0) {
            return results;
        }

        int low = matrix.length - 1;
        int top = 0;
        int right = matrix[0].length - 1;
        int left = 0;

        int x  = left,y=top;
        while(left <= right && top <= low){

            if (x > right) {
                break;
            }
            for (; x <= right; x++) {
                results.add(matrix[y][x]);
            }
            x--;
            y++;
            top++;

            if (y > low){
                break;
            }
            for (; y <= low ; y++){
                results.add(matrix[y][x]);

            }

            y--;
            x--;
            right--;

            if (x < left) {
                break;
            }
            for (; x >= left; x--){
                results.add(matrix[y][x]);
            }
            x++;
            y--;
            low--;
            if (y < top){
                break;
            }
            for (; y >= top; y--){
                results.add(matrix[y][x]);
            }
            y++;
            x++;
            left++;


        }


        return results;

    }
}