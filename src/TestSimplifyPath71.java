import javax.swing.*;
import java.util.Stack;

/**
 * @Author: gaozhengdong <gaozhengdong@corp.netease.com>
 * @Date: 2020/1/1 23:03
 */
public class TestSimplifyPath71 {

    public static void main(String[] args) {
        Solution71 solution71 = new Solution71();


        System.out.println(solution71.simplifyPath("/a/./b/../../c/"));
        System.out.println(solution71.simplifyPath("/home//foo/"));
        System.out.println(solution71.simplifyPath("/a/../../b/../c//.//"));
        System.out.println(solution71.simplifyPath("/a//b////c/d//././/.."));
    }
}


class Solution71 {
    public String simplifyPath(String path) {
        path = path.charAt(path.length() - 1) == '/' ? path.substring(0, path.length() - 1) : path;

        String[] paths = path.split("/");

        StringBuilder results = new StringBuilder();
        Stack<String> stack = new Stack<>();
        for (String p : paths) {
            if (p.isEmpty()) {
                continue;
            }
            if (p.equals(".")) {
                continue;
            } else if (p.equals("..")) {
                if (stack.isEmpty()) {
                    continue;
                }
                stack.pop();
            } else {
                stack.push(p);
            }

        }
        if (stack.isEmpty()){
            return "/";
        }

        while (!stack.isEmpty()) {
            results.insert(0, "/" + stack.pop());
        }
        return results.toString();

    }
}
