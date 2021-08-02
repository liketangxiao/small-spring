package cn.bugstack.springframework.beans.factory.support;

import cn.bugstack.springframework.beans.factory.config.BeanDefinition;

/**
 * @ClassName: BeanDefinitionRegistry
 * @Description:
 * @Author wangyuj
 * @Date 2021/7/27
 */
public interface BeanDefinitionRegistry {
    
    void registerBeanDefinition(String beanName, BeanDefinition beanDefinition);

    boolean containsBeanDefinition(String beanName);
}
