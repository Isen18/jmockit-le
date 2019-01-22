package com.isen.le.jmockit;

/**
 * @author Isen
 * @date 2019/1/22 20:59
 * @since 1.0
 */
//权限类，校验用户没有权限访问某资源
public interface IPrivilege {
    /**
     * 判断用户有没有权限
     *
     * @param userId
     * @return 有权限，就返回true,否则返回false
     */
    public boolean isAllow(long userId);

}