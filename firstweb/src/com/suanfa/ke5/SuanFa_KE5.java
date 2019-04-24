package com.suanfa.ke5;

import com.suanfa.model.Link;

public class SuanFa_KE5 {

    public static void main(String[] args) {
//        test1();
        test2();
    }


    //把一个单链表逆序   不使用额外的存储空间
    static void test1() {
        Link<Integer> link = new Link<>(-1);
        link.insertTail(1);
        link.insertTail(2);
        link.insertTail(3);
        link.show();
        link.reserver1(link.head);
        link.show();
    }


    //算法  二维数组一次循环遍历出所有数据
    static void test2() {
        int[][] a = new int[3][6];
        for (int i = 0; i < 3 * 6; i++) {
            int row = i / 6;
            int col = i % 6;
            a[row][col] = i;
//            System.out.println("i="+i+" \t i=" + (row*6 + col));
            System.out.println(a[row][col]);
        }
    }


}
