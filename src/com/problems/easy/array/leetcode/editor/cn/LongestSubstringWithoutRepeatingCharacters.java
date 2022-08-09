package com.problems.easy.array.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

/**
 * Description: 3 无重复字符的最长子串
 * Link:
 * Author:      lianhai.deng
 * Date:        2022-08-09 22:05:35
 */
public class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        Solution solution = new LongestSubstringWithoutRepeatingCharacters().new Solution();
        System.out.println(solution.lengthOfLongestSubstring("pwwkew"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int lengthOfLongestSubstring(String s) {
            char[] str = s.toCharArray();
            List<Character> characters = new ArrayList<>();
            int len = 0;
            for (char w : str) {
                if (characters.contains(w)) {
                    len = Math.max(len, characters.size());
                    int index = characters.indexOf(w) + 1;
                    characters = characters.subList(index, characters.size());

                }
                characters.add(w);
            }
            return Math.max(len, characters.size());
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

