package com.isen.le.jmockit;

/**
 * @author Isen
 * @date 2019/1/23 14:56
 * @since 1.0
 */
public interface MailServiceControllerInter {
    public boolean sendMail(long userId, String content);
}
