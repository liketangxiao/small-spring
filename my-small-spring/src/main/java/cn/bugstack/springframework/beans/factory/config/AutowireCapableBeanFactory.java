package cn.bugstack.springframework.beans.factory.config;

import cn.bugstack.springframework.beans.BeansException;

/**
 * @Description: AutowireCapableBeanFactory 自动化处理Bean工厂配置的接口
 * @Author wangyuj
 * @Date 2021/7/29
 */
public interface AutowireCapableBeanFactory {
    Object applyBeanPostProcessorsBeforeInitialization(Object existingBean, String beanName) throws BeansException;

    Object applyBeanPostProcessorsAfterInitialization(Object existingBean, String beanName) throws BeansException;
}
