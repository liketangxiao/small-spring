package cn.bugstack.springframework.beans.factory.support;

import cn.bugstack.springframework.beans.BeansException;
import cn.bugstack.springframework.beans.factory.DisposableBean;
import cn.bugstack.springframework.beans.factory.config.SingletonBeanRegistry;

import java.util.HashMap;
import java.util.Set;

/**
 * @Description: DefaultSingletonBeanRegistry
 * @Author wangyuj
 * @Date 2021/7/27
 */
public class DefaultSingletonBeanRegistry implements SingletonBeanRegistry {

    private final HashMap<String, Object> singletonObjects = new HashMap<>();
    private final HashMap<String, DisposableBean> disposableBeans = new HashMap<>();

    @Override
    public Object getSingleton(String beanName) {
        return singletonObjects.get(beanName);
    }

    protected void addSingleton(String beanName, Object singletonObject) {
        singletonObjects.put(beanName, singletonObject);
    }

   protected void registerDisposableBean(String beanName, DisposableBean disposableBean) {
        disposableBeans.put(beanName, disposableBean);
    }

    public void destroySingletons() {
        Set<String> beanNames = disposableBeans.keySet();
        Object[] objects = beanNames.toArray();
        for (Object beanName : objects) {
            DisposableBean disposableBean = disposableBeans.remove(beanName);
            try {
                disposableBean.destroy();
            } catch (Exception e) {
                throw new BeansException("Destroy method on bean with name" + beanName + "throw an exception", e);
            }
        }
    }
}
