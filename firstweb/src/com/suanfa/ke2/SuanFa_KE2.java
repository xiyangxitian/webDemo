package com.suanfa.ke2;

public class SuanFa_KE2 {

    public static void main(String[] args) {
        test1();
    }
    /*
    A说：“我不是小偷。”    x !=0
    B说：“C 是小偷。”     x = 2
    C说：“小偷肯定是 D。”  x = 3
    D说：“C 是在冤枉人。”  x != 3

    abcd 用0-3表示
     */
    //3个人说的是真的 1个是假的 求谁是小偷
    //x表示小偷的编号， 说的是真1  假0   之和为3 就输出x
    private static void test1(){
        for(int x = 0;x < 4; x++){
            int dis_a = (x != 0) ? 1 : 0;
            int dis_b = (x == 2) ? 1 : 0;
            int dis_c = (x == 3) ? 1 : 0;
            int dis_d = 1 - dis_c;
            if(dis_a + dis_b + dis_c + dis_d == 3){
                System.out.println("x：" + x); // 得到结果小偷是C
            }
        }

    }




}
