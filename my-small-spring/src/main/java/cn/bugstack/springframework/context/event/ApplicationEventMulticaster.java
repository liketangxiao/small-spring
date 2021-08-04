package cn.bugstack.springframework.context.event;

import cn.bugstack.springframework.context.ApplicationEvent;
import cn.bugstack.springframework.context.ApplicationListener;

/**
 * @Description: ApplicationEventMulticaster 事件广播器
 * @Author wangyuj
 * @Date 2021/8/4
 */
public interface ApplicationEventMulticaster {
    void addApplicationListener(ApplicationListener<?> listener);

    void removeApplicationListener(ApplicationListener<?> listener);

    /**
     * 广播事件接口
     */
    void multicastEvent(ApplicationEvent event);
}
