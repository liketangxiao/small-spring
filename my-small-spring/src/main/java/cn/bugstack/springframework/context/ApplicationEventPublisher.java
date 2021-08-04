package cn.bugstack.springframework.context;

/**
 * @Description: ApplicationEventPublisher 事件发布接口
 * @Author wangyuj
 * @Date 2021/8/4
 */
public interface ApplicationEventPublisher {
    void publishEvent(ApplicationEvent event);
}
