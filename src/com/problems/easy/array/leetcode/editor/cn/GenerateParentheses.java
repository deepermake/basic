package com.problems.easy.array.leetcode.editor.cn;


import java.util.*;

/**
 * Description: 22 括号生成
 * Link:
 * Author:      lianhai.deng
 * Date:        2022-07-18 18:31:00
 */
public class GenerateParentheses {
    public static void main(String[] args) {
        Solution solution = new GenerateParentheses().new Solution();
        solution.generateParenthesis(4);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<String> generateParenthesis(int n) {
            List<String> list = new ArrayList<>();
            List<String> res = backTract(list, n, new ArrayList<>());
            return res;
        }
        public List<String> backTract(List<String> res, int n, List<String> list) {
            if (list.size() == n * 2) {
                if (isValid(list)) {
                    String str = toStr(list);
                    res.add(str);
                }
                return null;
            }
            String[] arr = new String[]{"(", ")"};
            for (String s : arr) {
                list.add(s);
                backTract(res, n, list);
                list.remove(list.size() - 1);
            }
            return res;
        }
        public String toStr(List<String> list) {
            String s = "";
            for (String st : list){
                s = s.concat(st);
            }
            return s;
        }

        public boolean isValid(List<String> list) {
            if (list.get(0).equals(")") || list.get(list.size() - 1).equals("(")) {
                return false;
            }
            Stack<String> stack = new Stack<>();
            for (int i = 0; i < list.size(); i++) {
                if (!stack.isEmpty() && list.get(i).equals(")") && stack.pop().equals("(")){
                    continue;
                }
                stack.add(list.get(i));
            }
            return stack.isEmpty();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

