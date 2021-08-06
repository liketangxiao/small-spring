package cn.bugstack.springframework.beans.factory.config;

import cn.bugstack.springframework.beans.BeansException;

/**
 * @Description: InstantiationAwareBeanPostProcessor
 * @Author wangyuj
 * @Date 2021/8/5
 */
public interface InstantiationAwareBeanPostProcessor extends BeanPostProcessor {
    Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException;
}
