package com.advance;

import java.util.ArrayList;
import java.util.List;

/**
 * Description: 模拟一个高CPU场景
 * Link:     https://juejin.cn/post/7119116752939646984
 * Author:   lianhai.deng
 * Date:     2022/7/18 11:33
 */
public class HighCpuTest {
    public static void main(String[] args) {
        List<HighCpu> list = new ArrayList<>();

        Thread highCpuThread = new Thread(() -> {
            int i = 0;
            while (true){
                HighCpu cpu = new HighCpu("java test", i);
                list.add(cpu);
                System.out.println("high cpu size:"+list.size());
                i++;
            }
        });
        highCpuThread.setName("HighCpu");
        highCpuThread.start();
    }
}
