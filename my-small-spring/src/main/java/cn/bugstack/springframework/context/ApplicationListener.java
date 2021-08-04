package cn.bugstack.springframework.context;

import java.util.EventListener;

/**
 * @Description: ApplicationListener 事件监听器
 * @Author wangyuj
 * @Date 2021/8/4
 */
public interface ApplicationListener<E extends ApplicationEvent> extends EventListener {
    void onApplicationEvent(E event);
}
