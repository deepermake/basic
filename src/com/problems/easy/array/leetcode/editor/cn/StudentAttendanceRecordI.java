package com.problems.easy.array.leetcode.editor.cn;

/**
 * Description: 551 学生出勤记录 I
 * Link:
 * Author:      lianhai.deng
 * Date:        2022-06-16 15:56:57
 */
public class StudentAttendanceRecordI {
    public static void main(String[] args) {
        Solution solution = new StudentAttendanceRecordI().new Solution();
        String s = "LLLALL";
        System.out.println(solution.checkRecord(s));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean checkRecord(String s) {
            if (s.length() < 2) {
                return true;
            }
            int ANum = 0;
            int LSerialNum = 0;
            for (int i = 0; i < s.length(); i++) {
                if (ANum == 2 || LSerialNum == 3){
                    return false;
                }
                if (s.charAt(i) == 'A') {
                    ANum++;
                    LSerialNum = 0;
                    continue;
                }
                if (s.charAt(i) == 'L') {
                    LSerialNum++;
                    continue;
                }
                LSerialNum = 0;
            }
            return ANum < 2 && LSerialNum < 3;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

