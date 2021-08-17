package cn.bugstack.springframework.context.event;

/**
 * @Description: ContextCloseEvent 定义关闭监听事件
 * @Author wangyuj
 * @Date 2021/8/4
 */
public class ContextClosedEvent extends ApplicationContextEvent {

    /**
     * Constructs a prototypical Event.
     *
     * @param source The object on which the Event initially occurred.
     * @throws IllegalArgumentException if source is null.
     */
    public ContextClosedEvent(Object source) {
        super(source);
    }
}
