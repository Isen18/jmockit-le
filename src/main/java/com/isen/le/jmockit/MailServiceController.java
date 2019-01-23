package com.isen.le.jmockit;

import javax.annotation.Resource;

/**
 * @author Isen
 * @date 2019/1/23 14:49
 * @since 1.0
 */
public class MailServiceController implements MailServiceControllerInter{

    @Resource
    MailService mailService;

    public boolean sendMail(long userId, String content){
        return mailService.sendMail(userId, content);
    }
}
