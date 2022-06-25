package com.problems.easy.array.leetcode.editor.cn;

import java.util.Arrays;

/**
 * Description: 455 分发饼干
 * Link:
 * Author:      lianhai.deng
 * Date:        2022-06-25 10:42:30
 */
public class AssignCookies {
    public static void main(String[] args) {
        Solution solution = new AssignCookies().new Solution();
        int[] g = new int[]{2, 5,6};
        int[] s = new int[]{2, 6};
        solution.findContentChildren(g, s);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findContentChildren(int[] g, int[] s) {
            // [2,99,100] [2,98]
            Arrays.sort(g);
            Arrays.sort(s);
            int i = 0;
            int j = 0;
            while (j < g.length && i < s.length) {
                if (s[i++] >= g[j]) {
                    j++;
                    continue;
                }
            }
            return j;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

