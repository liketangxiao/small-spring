package cn.bugstack.springframework.beans.factory.support;

import cn.bugstack.springframework.beans.BeansException;
import cn.bugstack.springframework.beans.factory.FactoryBean;
import cn.bugstack.springframework.beans.factory.config.BeanDefinition;
import cn.bugstack.springframework.beans.factory.config.BeanPostProcessor;
import cn.bugstack.springframework.beans.factory.config.ConfigurableBeanFactory;
import cn.bugstack.springframework.util.ClassUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: AbstractBeanFactory
 * @Description:
 * @Author wangyuj
 * @Date 2021/7/26
 */
public abstract class AbstractBeanFactory extends FactoryBeanRegistrySupport implements ConfigurableBeanFactory {

    private final ClassLoader beanClassLoader = ClassUtils.getDefaultClassLoader();
    /** BeanPostProcessors to apply in createBean */
    private final List<BeanPostProcessor> beanPostProcessors = new ArrayList<BeanPostProcessor>();

    @Override
    public Object getBean(String name) {
        return doGetBean(name, null);
    }

    @Override
    public Object getBean(String name, Object... args) {
        return doGetBean(name, args);
    }

    @Override
    public <T> T getBean(String name, Class<T> requiredType) throws BeansException {
        return (T) getBean(name);
    }

    protected <T> T doGetBean(String name, Object[] args) {
        Object bean = getSingleton(name);
        if (bean != null) {
            return (T) getObjectForBeanInstance(name, bean);
        }
        BeanDefinition beanDefinition = getBeanDefinition(name);
        return (T) createBean(name, beanDefinition, args);
    }

    private Object getObjectForBeanInstance(String name, Object bean) {
        if (!(bean instanceof FactoryBean)) {
            return bean;
        }
        Object object = getObjectFormFactoryBean((FactoryBean) bean, name);
        if (object == null) {
            object=  getObjectFormFactoryBean((FactoryBean) bean, name);
        }
        return object;
    }

    protected abstract BeanDefinition getBeanDefinition(String beanName) throws BeansException;

    protected abstract Object createBean(String beanName, BeanDefinition beanDefinition, Object[] args) throws BeansException;

    @Override
    public void addBeanPostProcessor(BeanPostProcessor beanPostProcessor){
        this.beanPostProcessors.remove(beanPostProcessor);
        this.beanPostProcessors.add(beanPostProcessor);
    }

    /**
     * Return the list of BeanPostProcessors that will get applied
     * to beans created with this factory.
     */
    public List<BeanPostProcessor> getBeanPostProcessors() {
        return this.beanPostProcessors;
    }

    protected ClassLoader getBeanClassLoader() {
        return beanClassLoader;
    }
}
