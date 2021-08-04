package cn.bugstack.springframework.context.event;

import cn.bugstack.springframework.beans.factory.BeanFactory;
import cn.bugstack.springframework.context.ApplicationEvent;

/**
 * @Description: SimpleApplicationEventMulticaster
 * @Author wangyuj
 * @Date 2021/8/4
 */
public class SimpleApplicationEventMulticaster extends AbstractApplicationEventMulticast {
    public SimpleApplicationEventMulticaster(BeanFactory beanFactory) {
        setBeanFactory(beanFactory);
    }

    @Override
    public void multicastEvent(ApplicationEvent event) {
        getApplicationListeners(event).forEach(applicationListener -> applicationListener.onApplicationEvent(event));
    }
}
