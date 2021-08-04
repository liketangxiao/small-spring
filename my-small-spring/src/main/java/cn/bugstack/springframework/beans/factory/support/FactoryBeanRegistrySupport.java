package cn.bugstack.springframework.beans.factory.support;

import cn.bugstack.springframework.beans.BeansException;
import cn.bugstack.springframework.beans.factory.FactoryBean;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Description: FactoryBeanRegistrySupport FactoryBean注册服务
 * @Author wangyuj
 * @Date 2021/8/3
 */
public class FactoryBeanRegistrySupport extends DefaultSingletonBeanRegistry {
    private final Map<String, Object> factoryBeanObejectCache = new ConcurrentHashMap<>();

    protected Object getCacheObjectForFactoryBean(String beanName) {
        Object object = factoryBeanObejectCache.get(beanName);
        return (object != NULL_OBJECT ? object : null);
    }

    protected Object getObjectFormFactoryBean(FactoryBean factoryBean, String beanName) {
        if (factoryBean.isSingleton()) {
            Object object = factoryBeanObejectCache.get(beanName);
            if (object == null) {
                object = doGetObjectFormFactoryBean(factoryBean, beanName);
                factoryBeanObejectCache.put(beanName, object);
            }
            return (object != NULL_OBJECT ? object : null);
        } else {
            return doGetObjectFormFactoryBean(factoryBean, beanName);
        }
    }

    private Object doGetObjectFormFactoryBean(FactoryBean factoryBean, String beanName) {
        try {
            return factoryBean.getObject();
        } catch (Exception e) {
            throw new BeansException("FactoryBean threw exception on object[" + beanName + "] creation");
        }
    }
}
