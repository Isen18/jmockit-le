package com.isen.le.jmockit;

/**
 * @author Isen
 * @date 2019/1/22 20:47
 * @since 1.0
 */
// 邮件服务类，用于发邮件
public interface MailService {

    /**
     * 发送邮件
     *
     * @param userId
     *            邮件接受人id
     * @param content
     *            邮件内容
     * @return 发送成功了，就返回true,否则返回false
     */
    public boolean sendMail(long userId, String content);
}
