package com.suanfa.ke4;

/**
 * 百钱买鸡问题
 * <p>
 * 一百个钱买一百只鸡，是个典型的穷举法应用。问题描述：每只大公鸡值 5 个钱，
 * 每只母鸡值 3 个钱，每 3 只小鸡值 1 个钱，现在有 100 个钱，
 * 想买 100 只鸡，问如何买？有多少种方法？
 */
public class SuanFa_KE4 {

    public static void main(String[] args) {
        getJi();
    }

    /*
    公鸡 5元一只
    母鸡 3元一只
    小鸡 3只一元
    问共花了100元买了100只，那么3种鸡分别有多少只
     */
    static void getJi() {
        for (int x = 0; x <= 20; x++) {//公鸡最多不会超过20个
            for (int y = 0; y <= 33; y++) {//母鸡最多不会超过33只
                int z = 100 - x - y;
                if (z % 3 == 0 && (5*x + 3*y + z/3 == 100)) {
                    System.out.println("公鸡：" + x + " 母鸡：" + y + "  小鸡：" + z);
                }
            }
        }
    }

}
