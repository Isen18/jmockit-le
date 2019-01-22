package com.isen.le.jmockit;

import java.util.Locale;
import mockit.Expectations;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Isen
 * @date 2019/1/22 17:02
 * @since 1.0
 */
//HelloJMockit类的测试类
public class HelloJMockitTest {

    /**
     * 测试场景：当前是在中国
     */
    @Test
    public void testSayHelloAtChina() {
        System.out.println(System.getProperty("java.class.path"));
        // 假设当前位置是在中国
        new Expectations(Locale.class) {
            {
                Locale.getDefault();
                result = Locale.CHINA;
            }
        };
        // 断言说中文
        Assert.assertTrue("你好，JMockit!".equals((new HelloJMockit()).sayHello()));
    }

//    /**
//     * 测试场景：当前是在美国
//     */
//    @Test
//    public void testSayHelloAtUS() {
//        // 假设当前位置是在美国
//        new Expectations(Locale.class) {
//            {
//                Locale.getDefault();
//                result = Locale.US;
//            }
//        };
//        // 断言说英文
//        Assert.assertTrue("Hello，JMockit!".equals((new HelloJMockit()).sayHello()));
//    }
}
