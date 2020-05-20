package com.dlh;

/**
 *
 * @description Voliate 测试demo
 * @author 邓联海
 * @date 2020/5/19 16:51
 */
public class VoliateTest {
    private volatile static Integer i = 0;

    public synchronized static void iPlus() {
        i++;
    }

    public static void main(String[] args){
        for (int i=0;i<1000;i++){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    VoliateTest.iPlus();
                }
            }).start();
        }
        System.out.println("结果i:"+ VoliateTest.i);
    }
}
