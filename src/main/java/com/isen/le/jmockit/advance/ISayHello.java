package com.isen.le.jmockit.advance;

import java.util.List;

/**
 * @author Isen
 * @date 2019/1/23 11:00
 * @since 1.0
 */
//打招呼的接口
public interface ISayHello {
    // 性别：男
    int MALE = 0;
    // 性别：女
    int FEMALE = 1;

    /**
     * 打招呼
     *
     * @param who    向谁说
     * @param gender 对方的性别
     * @return 返回打招呼的内容
     */
    String sayHello(String who, int gender);

    /**
     * 向多个人打招呼
     *
     * @param who    向谁说
     * @param gender 对方的性别
     * @return 返回向多个人打招呼的内容
     */
    List<String> sayHello(String[] who, int[] gender);

}
