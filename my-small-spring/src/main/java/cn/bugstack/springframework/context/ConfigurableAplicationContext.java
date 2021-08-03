package cn.bugstack.springframework.context;

import cn.bugstack.springframework.beans.BeansException;

import javax.sound.midi.VoiceStatus;

/**
 * @Description: ConfigurableAplicationContext 提供刷新容器的接口refresh
 * @Author wangyuj
 * @Date 2021/8/2
 */
public interface ConfigurableAplicationContext extends AplicationContext {
    void refresh() throws BeansException;

    void registerShutdownHook();

    void close();
}
