import java.util.Arrays;
import java.util.Comparator;

/**
 * Given a collection of intervals, merge all overlapping intervals.
 * <p>
 * Example 1:
 * <p>
 * Input: [[1,3],[2,6],[8,10],[15,18]]
 * Output: [[1,6],[8,10],[15,18]]
 * Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
 * Example 2:
 * <p>
 * Input: [[1,4],[4,5]]
 * Output: [[1,5]]
 * Explanation: Intervals [1,4] and [4,5] are considered overlapping.
 * NOTE: input types have been changed on April 15, 2019. Please reset to default code definition to get new method signature.
 */

public class TestMergeIntervals56 {

    public static void main(String[] args) {

        Solution56 solution56 = new Solution56();

        int[][] datas = new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        System.out.println(Arrays.deepToString(solution56.merge(datas)));

        int[][] datas2 = new int[][]{{1, 4}, {4, 5}};
        System.out.println(Arrays.deepToString(solution56.merge(datas2)));

        int[][] datas3 = new int[][]{{1, 4}, {0, 0}};
        System.out.println(Arrays.deepToString(solution56.merge(datas3)));

        int[][] datas4 = new int[][]{{2,3},{4,5},{6,7},{8,9},{1,10}};
        System.out.println(Arrays.deepToString(solution56.merge(datas4)));
    }
}

class Solution56 {
    public int[][] merge(int[][] intervals) {
        if (intervals.length <= 1) {
            return intervals;
        }
        int length = intervals.length;
        int nLength = intervals[0].length;
        int[][] res = new int[length][nLength];
        int count = 0;
        int i = 1;

        Arrays.sort(intervals, Comparator.comparingInt(i2 -> i2[0]));

//        for (int j = 0; j < intervals.length; j++) {
//            int min = intervals[j][0];
//            int flag = j;
//            for (int k = j+1; k < intervals.length; k++) {
//                if (intervals[k][0] < min){
//                    flag = k;
//                    min = intervals[k][0];
//                }
//            }
//            int[] tmp = intervals[j];
//            intervals[j] = intervals[flag];
//            intervals[flag] = tmp;
//        }

        for (; i < intervals.length; i++) {

            // check whick is bigger
//            if (intervals[i-1][0] > intervals[i][0]){
//                int[] tmp = intervals[i-1];
//                intervals[i-1] = intervals[i];
//                intervals[i] = tmp;
//            }

            int[][] mergedArrays = mergeTwoArray(intervals[i - 1], intervals[i]);
            if (mergedArrays[1].length != 0) {
                res[count++] = mergedArrays[0];
            } else {
                intervals[i] = mergedArrays[0];
            }
        }
        res[count++] = intervals[i - 1];

        int[][] resCounted = new int[count][2];
        System.arraycopy(res, 0, resCounted, 0, count);
        return resCounted;
    }

    private int[][] mergeTwoArray(int[] min, int[] max) {
        int[][] res = new int[2][2];

        if (min[1] >= max[1]) {
            res[0] = min;
            res[1] = new int[]{};
        } else if (min[1] < max[0]) {
            res[0] = min;
            res[1] = max;
        } else {
            res[0] = new int[]{min[0], max[1]};
            res[1] = new int[]{};
        }
        return res;
    }


}
