package cn.bugstack.springframework.beans.factory.support;

import cn.bugstack.springframework.beans.factory.config.SingletonBeanRegistry;

import java.util.HashMap;

/**
 * @Description: DefaultSingletonBeanRegistry
 * @Author wangyuj
 * @Date 2021/7/27
 */
public class DefaultSingletonBeanRegistry implements SingletonBeanRegistry {

    private final HashMap<String, Object> singletonObjects = new HashMap<>();

    @Override
    public Object getSingleton(String beanName) {
        return singletonObjects.get(beanName);
    }

    protected void addSingleton(String beanName, Object singletonObject) {
        singletonObjects.put(beanName, singletonObject);
    }
}
