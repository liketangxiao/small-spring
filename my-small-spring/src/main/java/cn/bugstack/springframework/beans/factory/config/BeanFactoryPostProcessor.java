package cn.bugstack.springframework.beans.factory.config;

import cn.bugstack.springframework.beans.BeansException;
import cn.bugstack.springframework.beans.factory.ConfigurableListableBeanFactory;

/**
 * @Description: BeanFactoryPostProcessor 提供BeanDefinition加载完成后, 实例化前对其属性进行修改
 * @Author wangyuj
 * @Date 2021/7/29
 */
public interface BeanFactoryPostProcessor {
    void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException;
}
