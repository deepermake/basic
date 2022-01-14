package com.bloomFilter;

import java.util.BitSet;

/**
 * @Auther: 邓联海
 * @Date: 2022/1/14 15
 * @Description: 通过BitSet实现布隆过滤器实现
 */
public class BloomFilter {


    private static final int DEFAULT_SIZE = 2 << 24;

    private static final int[] SEEDS = new int[]{3, 13, 46, 71, 91, 134};

    private BitSet bits = new BitSet(DEFAULT_SIZE);

    private SimpleHash[] func = new SimpleHash[SEEDS.length];

    public BloomFilter() {
        for (int i = 0; i < SEEDS.length; i++) {
            func[i] = new SimpleHash(DEFAULT_SIZE, SEEDS[i]);
        }
    }

    /**
     * 将指定下标的位设为true,表示添加
     * @param value
     */
    public void add(Object value) {
        for (SimpleHash f : func) {
            bits.set(f.hash(value), true);
        }
    }

    /**
     * 获取value对应下标的位值
     * @param value
     * @return
     */
    public boolean contains(Object value) {
        boolean ret = true;
        for (SimpleHash f : func) {
            ret = ret && bits.get(f.hash(value));
        }
        return ret;
    }

    public static class SimpleHash {
        private int cap;

        private int seed;

        public SimpleHash(int cap, int seed) {
            this.cap = cap;
            this.seed = seed;
        }

        public int hash(Object value) {
            int h;
            return (value == null) ? 0 : Math.abs(seed * (cap - 1) & ((h = value.hashCode()) ^ (h >>> 16)));
        }
    }

    public static void main(String[] args) {
        String var = "121212";
        String var2 = "121212";

        BloomFilter bloomFilter = new BloomFilter();
        System.out.println(bloomFilter.contains(var));
        System.out.println(bloomFilter.contains(var2));

        bloomFilter.add(var);
        bloomFilter.add(var2);

        System.out.println(bloomFilter.contains(var));
        System.out.println(bloomFilter.contains(var2));
    }
}
