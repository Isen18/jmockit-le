package com.isen.le.jmockit.dubbo;

import com.isen.le.jmockit.MailService;
import com.isen.le.jmockit.MailServiceController;
import com.isen.le.jmockit.MailServiceControllerInter;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Resource;
import mockit.Mock;
import mockit.MockUp;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author Isen
 * @date 2019/1/22 23:39
 * @since 1.0
 */
//dubbo消费bean Mock
@SuppressWarnings({ "unchecked", "rawtypes" })
@ContextConfiguration(locations = { "classpath:/config/dubbo/dubbo-consumer.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
public class DubboConsumerBeanMockingTest {
    // 这里要@BeforeClass,因为要抢在spring加载dubbo前，对dubbo的消费工厂bean
    // ReferenceBean进行mock，不然dubbo可能因为连上不zk或无法找不
    // 服务的提供者等原因而无法初始化的，进而，单元测试运行不下去
    @BeforeClass
    public static void mockDubbo() {
        // 你准备mock哪个消费bean
        // 比如要对dubbo-consumber.xml里配置的com.isen.le.jmockit.MailService这个消费bean进行mock
        Map<String, Object> mockMap = new HashMap<String, Object>();
        mockMap.put("com.isen.le.jmockit.MailService", new MockUp(MailService.class) {
            // 在这里书写对这个消费bean进行mock的mock逻辑，想mock哪个方法，就自行添加，注意方法一定要加上@Mock注解哦
            @Mock
            public boolean sendMail(long userId, String content) {
                // 单元测试时，不需要调用邮件服务器发送邮件，这里统一mock邮件发送成功
                return true;
            }
        }.getMockInstance());
        // 如果要Mock其它的消费bean，自行添加,mockMap.put.....如上
        new DubboConsumerBeanMockUp(mockMap);
    }

    // 现在你使用的dubbo消费bean就是本地mock过的了，并不是指向远程dubbo服务的bean了
    @Resource
//    MailService mailService;
    MailServiceControllerInter mailServiceControllerInter;

    @Test
    public void testSendMail() {
        long userId = 123456;
        String content = "test mail content";
//        Assert.assertTrue(mailService.sendMail(userId, content));
        Assert.assertTrue(mailServiceControllerInter.sendMail(userId, content));

    }
}
