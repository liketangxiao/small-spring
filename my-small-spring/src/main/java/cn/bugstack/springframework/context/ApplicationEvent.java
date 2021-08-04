package cn.bugstack.springframework.context;

import java.util.EventObject;

/**
 * @Description: ApplicationEvent 定义事件
 * @Author wangyuj
 * @Date 2021/8/4
 */
public abstract class ApplicationEvent extends EventObject {
    /**
     * Constructs a prototypical Event.
     *
     * @param source The object on which the Event initially occurred.
     * @throws IllegalArgumentException if source is null.
     */
    public ApplicationEvent(Object source) {
        super(source);
    }
}
