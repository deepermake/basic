package com.problems.mid;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * 140 - 单词拆分 II
 */
public class WordBreak {

    public static void main(String[] args) {

//        String[] str = new String[]{"cat", "cats", "and", "sand", "dog"};
//        List<String> list = Arrays.stream(str).collect(Collectors.toList());
//        wordBreak("catsanddog", list);

        String[] str1 = new String[]{"apple", "pen", "applepen", "pine", "pineapple"};
        List<String> list1 = Arrays.stream(str1).collect(Collectors.toList());
        wordBreak("pineapplepenapple", list1);
    }

    /**
     * (0)
     * (0)
     * (4)
     * (3)
     * (7)
     * <p>
     * 把 s 分割成几段，这几段都在目标集合中存在，有几种分法
     *
     * @param s
     * @param wordDict
     * @return
     */
    public static List<String> wordBreak(String s, List<String> wordDict) {

        List<String> res = new ArrayList<>();
        back(s, wordDict, res, new ArrayList<>());
        return res;
    }

    public static void back(String s, List<String> dict, List<String> res, List<String> path) {
        // 是否满足要求
        String pathStr = String.join("", path);
        if (Objects.equals(pathStr, s)) {
            res.add(String.join(" ", path));
            return;
        }

        for (int i = 0; i < dict.size(); i++) {
            path.add(dict.get(i));
            if (s.indexOf(String.join("", path)) != 0) {
                path.remove(path.size() - 1);
                continue;
            }
            back(s, dict, res, path);
            path.remove(path.size() - 1);
        }
    }
}
