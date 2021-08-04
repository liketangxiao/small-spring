package cn.bugstack.springframework.context.event;

/**
 * @Description: ContextRefreshedEvent 定义应用容器刷新事件
 * @Author wangyuj
 * @Date 2021/8/4
 */
public class ContextRefreshedEvent extends ApplicationContextEvent{
    /**
     * Constructs a prototypical Event.
     *
     * @param source The object on which the Event initially occurred.
     * @throws IllegalArgumentException if source is null.
     */
    public ContextRefreshedEvent(Object source) {
        super(source);
    }
}
