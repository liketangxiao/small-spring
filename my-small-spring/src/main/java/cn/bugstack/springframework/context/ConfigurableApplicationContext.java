package cn.bugstack.springframework.context;

import cn.bugstack.springframework.beans.BeansException;

/**
 * @Description: ConfigurableAplicationContext 提供刷新容器的接口refresh
 * @Author wangyuj
 * @Date 2021/8/2
 */
public interface ConfigurableApplicationContext extends ApplicationContext {

    /**
     * 刷新容器
     *
     * @throws BeansException
     */
    void refresh() throws BeansException;

    void registerShutdownHook();

    void close();
}
