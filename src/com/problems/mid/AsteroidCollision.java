package com.problems.mid;

import java.util.Stack;

/**
 * 735 - 小行星碰撞
 */
public class AsteroidCollision {
    public static void main(String[] args) {
        // asteroidCollision(new int[]{5, 10, -5});
        // asteroidCollision(new int[]{10, -100, 20, 200});
        // asteroidCollision(new int[]{10, -100, 20});
        asteroidCollision(new int[]{-2, -2, 1, -2});

    }

    public static int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < asteroids.length; i++) {
            if (stack.isEmpty()) {
                stack.push(i);
                continue;
            }
            boolean isNeedToPush = false;
            while (!stack.isEmpty()) {
                boolean isNotCollision =
                        asteroids[stack.peek()] < 0 && asteroids[i] < 0 ||
                                asteroids[stack.peek()] > 0 && asteroids[i] > 0 ||
                                asteroids[stack.peek()] < 0 && asteroids[i] > 0;
                if (isNotCollision) {
                    isNeedToPush = true;
                    break;
                }
                if (Math.abs(asteroids[stack.peek()]) < Math.abs(asteroids[i])) {
                    isNeedToPush = true;
                    stack.pop();
                    continue;
                }
                if (Math.abs(asteroids[stack.peek()]) == Math.abs(asteroids[i])) {
                    stack.pop();
                }
                isNeedToPush = false;
                break;
            }
            if (isNeedToPush) {
                stack.push(i);
            }
        }


        if (stack.isEmpty()) {
            return new int[]{};
        }

        int[] res = new int[stack.size()];
        for (int i = res.length - 1; i >= 0; i--) {
            res[i] = asteroids[stack.pop()];
        }
        return res;
    }
}
