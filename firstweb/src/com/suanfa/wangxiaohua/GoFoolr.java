package com.suanfa.wangxiaohua;

import java.math.BigInteger;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 动态规划
 * <p>
 * 一次上一层台阶或两层
 * 共20层
 * 问有多少种上楼梯的方法
 * <p>
 * 1. 一层的时候有 1种    【1】   f(1)
 * 2. 二层的时候有 2种    【1，1】 【2】  f(2)
 * 3. 三层的时候有 3种 【1，1，1】 【1，2】 【 2，1】     f(3) = f(1) + f(2)
 * 。。
 * n. n导的时候共有      f(n) = f(n-1) + f(n-2)
 *
 * 这种用递归的方式显示是计算了太多的子问题，不好。要用动态规划来。
 *
 * 子问题具有无后向性就可以用动态规划来
 *
 */
public class GoFoolr {

    Map<BigInteger,BigInteger> map;
    public static void main(String[] args) {
//10946
        GoFoolr g = new GoFoolr();
/*        long l1 = new Date().getTime();
        System.out.println(g.getNum(new BigInteger("1000")));
        long l2 = new Date().getTime();
        System.out.println("共用时："+(l2-l1)+"毫秒");*/
        System.out.println(g.dp(20));
    }

    void init(BigInteger n){
        map = new HashMap<>();
        map.put(new BigInteger("1"), new BigInteger("1"));
        map.put(new BigInteger("2"), new BigInteger("2"));
    }

    //动态规划 只是加了个记录
    public BigInteger getNum(BigInteger n){
        init(n);
        return getN(n);
    }

    public BigInteger getN(BigInteger n){
        if(map.get(n)!=null){
            return map.get(n);
        }else{
            BigInteger b = getN(n.subtract(new BigInteger("1"))).add(getN(n.subtract(new BigInteger("2"))));
            map.put(n, b);
            return b;
        }
    }



    //原始方法
    public int f(int n){
        if(n==1){
            return 1;
        }else if(n==2){
            return 2;
        }else{
            return f(n-1) + f(n-2);
        }
    }

    //直接这样
    int dp(int n){
        int[] m = new int[n+1];
        m[1] = 1;
        m[2] = 2;

        for(int i = 3; i <= n; i++){
            m[i] = m[i-1] + m[i-2];
        }

        return m[n];
    }

}
