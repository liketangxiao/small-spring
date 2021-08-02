package cn.bugstack.springframework.beans.factory;

import cn.bugstack.springframework.beans.BeansException;

import java.util.Map;

/**
 * @Description: ListableBeanFactory BeanFactory扩展接口
 * @Author wangyuj
 * @Date 2021/7/29
 */
public interface ListableBeanFactory extends BeanFactory {
    <T> Map<String,T> getBeansOfType(Class<T> clazz) throws BeansException;

    String[] getBeanDefinitionNames();
}
