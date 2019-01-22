package com.isen.le.jmockit.common;

/**
 * @author Isen
 * @date 2019/1/22 22:36
 * @since 1.0
 */
//一个普通类
public class AnOrdinaryClass {

    // 静态方法
    public static int staticMethod() {
        return 1;
    }

    // 普通方法
    public int ordinaryMethod() {
        return 2;
    }

    // final方法
    public final int finalMethod() {
        return 3;
    }

    // native方法,返回4
    public native int navtiveMethod();

    // private方法
    private int privateMethod() {
        return 5;
    }

    // 调用private方法
    public int callPrivateMethod() {
        return privateMethod();
    }
}