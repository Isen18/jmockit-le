package com.isen.le.jmockit.dubbo;

import com.alibaba.dubbo.config.spring.ReferenceBean;
import java.util.Map;
import mockit.Invocation;
import mockit.Mock;
import mockit.MockUp;

/**
 * @author Isen
 * @date 2019/1/22 23:43
 * @since 1.0
 */

//dubbo消费bean的MockUp(伪类）
@SuppressWarnings("rawtypes")
public class DubboConsumerBeanMockUp extends MockUp<ReferenceBean> {
    // 自定义的消费bean mock对象
    private Map<String, Object> mockMap;

    public DubboConsumerBeanMockUp() {
    }

    public DubboConsumerBeanMockUp(Map<String, Object> mockMap) {
        this.mockMap = mockMap;
    }

    // 对ReferenceBean的getObject方法的Mock
    @SuppressWarnings("unchecked")
    @Mock
    public Object getObject(Invocation inv) throws Exception {
        ReferenceBean ref = inv.getInvokedInstance();
        String interfaceName = ref.getInterface();
        Object mock = mockMap.get(interfaceName);
        if (mock != null) {
            return mock;
        }
        return (new MockUp(Class.forName(interfaceName)) {
        }).getMockInstance();
    }
}