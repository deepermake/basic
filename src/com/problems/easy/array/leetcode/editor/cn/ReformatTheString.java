package com.problems.easy.array.leetcode.editor.cn;

import java.util.*;

/**
 * Description: 1417 重新格式化字符串 todo：如何缩短执行时长
 * Link:
 * Author:      lianhai.deng
 * Date:        2022-08-12 12:54:19
 */
public class ReformatTheString {
    public static void main(String[] args) {
        Solution solution = new ReformatTheString().new Solution();
        System.out.println(solution.reformat("1"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String reformat(String s) {
            if (s.length() == 1){
                return s;
            }
            Set<Character> numSet = new HashSet<>();
            numSet.add('0');
            numSet.add('1');
            numSet.add('2');
            numSet.add('3');
            numSet.add('4');
            numSet.add('5');
            numSet.add('6');
            numSet.add('7');
            numSet.add('8');
            numSet.add('9');
            List<Character> numList = new ArrayList<>();
            List<Character> notNumList = new ArrayList<>();
            for (char cr : s.toCharArray()) {
                if (numSet.contains(cr)) {
                    numList.add(cr);
                    continue;
                }
                notNumList.add(cr);
            }
            boolean isValid = numList.size() - notNumList.size() > -2 && numList.size() - notNumList.size() < 2;
            if (!isValid) {
                return "";
            }
            if (numList.size() >= notNumList.size()) {
                return getSt(numList, notNumList);
            }
            return getSt(notNumList, numList);
        }

        private String getSt(List<Character> numList, List<Character> notNumList) {
            String result = "";
            int i = 0, j = 0;
            while (i < numList.size() || j < notNumList.size()) {
                if (i < numList.size()) {
                    result = result.concat(String.valueOf(numList.get(i)));
                }
                if (j < notNumList.size()) {
                    result = result.concat(String.valueOf(notNumList.get(j)));
                }
                i++;
                j++;
            }
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

