package com.problems.easy.array.leetcode.editor.cn;

import java.util.*;

/**
 * Description: 3 无重复字符的最长子串 todo 优化耗时
 * Link:
 * Author:      lianhai.deng
 * Date:        2022-08-09 22:05:35
 */
public class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        Solution solution = new LongestSubstringWithoutRepeatingCharacters().new Solution();
        System.out.println(solution.lengthOfLongestSubstring("abcabcbb"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
//        public int lengthOfLongestSubstring(String s) {
//            char[] str = s.toCharArray();
//            List<Character> characters = new ArrayList<>();
//            int len = 0;
//            for (char w : str) {
//                if (characters.contains(w)) {
//                    len = Math.max(len, characters.size());
//                    int index = characters.indexOf(w) + 1;
//                    characters = characters.subList(index, characters.size());
//
//                }
//                characters.add(w);
//            }
//            return Math.max(len, characters.size());
//        }

        public int lengthOfLongestSubstring(String s) {
            Set<Character> set = new HashSet<>();
            int n = s.length();
            int rk = -1, ans = 0;
            for (int i = 0; i < n; ++i) {
                if (i != 0) {
                    set.remove(s.charAt(i - 1));
                }
                while (rk + 1 < n && !set.contains(s.charAt(rk + 1))) {
                    set.add(s.charAt(rk + 1));
                    ++rk;
                }
                ans = Math.max(ans, rk - i + 1);
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

