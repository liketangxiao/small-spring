package cn.bugstack.springframework.beans.factory;

import cn.bugstack.springframework.beans.BeansException;

/**
 * @Description: BeanFactoryAware 实现BeanFactoryAware可以感知BeanFactory
 * @Author wangyuj
 * @Date 2021/8/3
 */
public interface BeanFactoryAware extends Aware {
    void setBeanFactory(BeanFactory beanFactory) throws BeansException;
}
