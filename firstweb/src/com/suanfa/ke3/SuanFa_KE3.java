package com.suanfa.ke3;

/**
 * 字符串的全排列
 * 迭代法是分治法的好朋友
 */
public class SuanFa_KE3 {

    /*
     *对一个不重复的字符串进行全排列
     * 用分治法来实现
     */
    public static void main(String[] args) {
        String s = "abcd";
        char[] chList = s.toCharArray();
        Permutation(chList, 0, s.length() - 1);
    }

    static void Permutation(char[] chList, int begin, int end) {
        if (begin == end) {
            System.out.println(chList);
        } else {
            for (int i = begin; i <= end; i++) {
                Swap(chList, begin, i); //把第 i 个字符换到 begin 位置，将 begin+1 位置看作新的子串开始
                Permutation(chList, begin + 1, end); //求解子问题
                Swap(chList, begin, i); //在挑选下一个固定字符之前，需要换回来
            }
        }
    }

    //交换字符串中的两个字符的位置
    static void Swap(char[] chList, int pos1, int pos2) {
        char temp = chList[pos1];
        chList[pos1] = chList[pos2];
        chList[pos2] = temp;
    }

}
