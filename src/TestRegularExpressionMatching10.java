/**
 * @Author: gaozhengdong <gaozhengdong@corp.netease.com>
 * @Date: 2019/12/16 23:55
 */
public class TestRegularExpressionMatching10 {

    public static void main(String[] args) {

        Solution10 solution10 = new Solution10();

        System.out.println(solution10.isMatch("aa", "a"));
        System.out.println(solution10.isMatch("aa", "a*"));
        System.out.println(solution10.isMatch("ab", ".*"));
        System.out.println(solution10.isMatch("aab", "c*a*b"));
        System.out.println(solution10.isMatch("mississippi", "mis*is*p*."));
    }

}

class Solution10 {
    public boolean isMatch(String s, String p) {
        char[] acs = s.toCharArray();
        char[] pcs = s.toCharArray();

        if (acs.length < 1) {

            if (pcs.length == 0) {
                return true;
            }
            if (pcs.length == 2 && pcs[0] < 'z' && pcs[0] > 'a' && pcs[1] == '*') {
                return true;
            }

            return false;
        }
        char temp = '^';
        boolean needJudge = false;
        char last;
        for (int i = 0,j = 0; i < acs.length || j < pcs.length; ) {



            if (pcs[j] == '.') {
                i++;
                j++;
                continue;
            }

            if (pcs[j] == '*'){

                if (acs[i] == temp) {
                    i++;
                } else {
                    j++;
                }
            }



            if (needJudge) {
                if (pcs[j] == '*'){
                    j++;
                    needJudge = false;
                    continue;
                }else {
                    return false;
                }
            }

            if (acs[i] != pcs[j]){
                needJudge = true;
                j++;
                continue;
            }

            if (acs[i] == pcs[j]){
                i++;
                temp = acs[i];
                last = temp;
                while(j < pcs.length ) {

                    if (pcs[j] == '*' || pcs[j] == temp || pcs[j] == '.'){
                        if (pcs[j] == '*' && last == '*'){
                            return false;
                        }
                        last = pcs[j];
                        j++;
                    }else {
                        break;
                    }
                }
            }

        }
        return true;

    }
}