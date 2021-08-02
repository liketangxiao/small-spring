package cn.bugstack.springframework.beans.factory.config;

import cn.bugstack.springframework.beans.BeansException;

/**
 * @Description: BeanPostProcessor 提供实例化bean对象的扩展点
 * @Author wangyuj
 * @Date 2021/8/2
 */
public interface BeanPostProcessor {
    Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException;

    Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException;
}
