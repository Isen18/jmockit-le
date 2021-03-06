package com.isen.le.jmockit;

/**
 * @author Isen
 * @date 2019/1/22 20:47
 * @since 1.0
 */
// 用户身份校验
public interface UserCheckService {

    /**
     * 校验某个用户是否是合法用户
     *
     * @param userId
     *            用户ID
     * @return 合法的就返回true,否则返回false
     */
    public boolean check(long userId);
}//订单服务类 ,用于下订单