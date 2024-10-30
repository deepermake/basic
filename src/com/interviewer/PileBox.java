package com.interviewer;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class PileBox {
    public static void main(String[] args) {
        pileBox(new int[][]{{1, 1, 1}, {2, 3, 4}, {2, 6, 10}, {3, 4, 5}, {1, 1, 2}});

    }

    public static int pileBox(int[][] box) {

        int result = 0;

        int len = box.length;
        List<List<Integer>> lists = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            list.add(i);
        }
        lists.add(list);
        while (!list.isEmpty()) {
            List<Integer> removes = new ArrayList<>();
            for (int i = 0; i < list.size(); i++) {
                for (int j = 0; j < list.size(); j++) {
                    if (Objects.equals(list.get(i), list.get(j))) {
                        continue;
                    }
                    if (box[i][0] > box[j][0] && box[i][1] > box[j][1] && box[i][2] > box[j][2] && !removes.contains(j)) {
                        removes.add(j);
                    }
                }
            }
            if (removes.isEmpty()) {
                break;
            }
            lists.get(lists.size() - 1).removeAll(removes);
            lists.add(removes);
            list = removes;
        }



        return result;

    }
}
