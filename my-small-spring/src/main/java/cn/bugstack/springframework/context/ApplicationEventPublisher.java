package cn.bugstack.springframework.context;

/**
 * @Description: ApplicationEventPublisher 事件发布接口
 * @Author wangyuj
 * @Date 2021/8/4
 */
public interface ApplicationEventPublisher {

    /**
     * Notify all listeners registered with this application of an application
     * event. Events may be framework events (such as RequestHandledEvent)
     * or application-specific events.
     *
     * @param event the event to publish
     */
    void publishEvent(ApplicationEvent event);
}
