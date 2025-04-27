package com.problems.easy;

/**
 * 860 - 柠檬水找零
 */
public class LemonadeChange {

    public static void main(String[] args) {
        // System.out.println(lemonadeChange(new int[]{5, 5, 10, 20}));
        System.out.println(lemonadeChange(new int[]{5, 5, 5, 20}));
    }

    /**
     * 确保每个人都可以找零
     * 5块钱不用找，10块钱，需要找5块钱，20 块钱，需要找1个10块1个5块，或者3个五块
     *
     * @param bills
     * @return
     */
    public static boolean lemonadeChange(int[] bills) {
        int five = 0, ten = 0;
        for (int i = 0; i < bills.length; i++) {
            if (bills[i] == 5) {
                five++;
                continue;
            }
            if (bills[i] == 10 && five == 0) {
                return false;
            }

            if (bills[i] == 10) {
                five--;
                ten++;
                continue;
            }
            // 20的情况
            if (ten > 0 && five > 0) {
                ten--;
                five--;
                continue;
            }

            if (five >= 3) {
                five -= 3;
                continue;
            }

            return false;
        }

        return true;
    }
}
