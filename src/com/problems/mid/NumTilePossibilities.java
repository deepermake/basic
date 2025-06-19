package com.problems.mid;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 1079 - 活字印刷
 */
public class NumTilePossibilities {

    public static void main(String[] args) {
        System.out.println(numTilePossibilities("AAB"));
        System.out.println(numTilePossibilities("AAABBC"));
    }

    public static int numTilePossibilities(String tiles) {
        Set<String> set = new HashSet<>();
        boolean[] visited = new boolean[tiles.length()];
        back(tiles, set, visited, new ArrayList<>());
        return set.size();
    }

    public static void back(String tiles, Set<String> set, boolean[] visited, List<String> path) {
        for (int i = 0; i < tiles.length(); i++) {
            if (visited[i]) {
                continue;
            }

            String pathStr = String.join("", path);
            String str = String.valueOf(tiles.charAt(i));
            pathStr = pathStr.concat(str);
            if (set.contains(pathStr)) {
                continue;
            }
            set.add(pathStr);

            path.add(str);
            visited[i] = true;
            back(tiles, set, visited, path);
            visited[i] = false;
            path.remove(path.size() - 1);
        }
    }


}
