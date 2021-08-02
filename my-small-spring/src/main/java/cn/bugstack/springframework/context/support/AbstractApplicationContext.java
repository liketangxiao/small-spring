package cn.bugstack.springframework.context.support;

import cn.bugstack.springframework.beans.BeansException;
import cn.bugstack.springframework.beans.factory.ConfigurableListableBeanFactory;
import cn.bugstack.springframework.beans.factory.config.BeanFactoryPostProcessor;
import cn.bugstack.springframework.beans.factory.config.BeanPostProcessor;
import cn.bugstack.springframework.context.ConfigurableAplicationContext;
import cn.bugstack.springframework.core.io.DefaultResourceLoader;

import java.util.Map;

/**
 * @Description: AbstractApplicationContext 应用上下文抽象实现类
 * @Author wangyuj
 * @Date 2021/8/2
 */
public abstract class AbstractApplicationContext extends DefaultResourceLoader implements ConfigurableAplicationContext {

    @Override
    public void refresh() throws BeansException {
        /** 创建BeanFactory 并加载BeanDefinition */
        refreshBeanFactory();
        /** 获取BeanFactory */
        ConfigurableListableBeanFactory beanFactory = getBeanFactory();
        /** Bean实例化之前执行 */
        invokebeanFactroyPostProcessors(beanFactory);
        /** BeanPostProcessor需要提前于其他Bean对象实例化执行注册操作 */
        registerBeanPostProcessors(beanFactory);
    }

    private void registerBeanPostProcessors(ConfigurableListableBeanFactory beanFactory) {
        Map<String, BeanPostProcessor> beansOfType = beanFactory.getBeansOfType(BeanPostProcessor.class);

        beansOfType.forEach((beanName, beanPostProcessor) -> beanFactory.addBeanPostProcessor(beanPostProcessor));
    }

    private void invokebeanFactroyPostProcessors(ConfigurableListableBeanFactory beanFactory) {
        Map<String, BeanFactoryPostProcessor> beansOfType = beanFactory.getBeansOfType(BeanFactoryPostProcessor.class);
        beansOfType.forEach((beanName, beanFactoryPostProcessor) -> {
            beanFactoryPostProcessor.postProcessBeanFactory(beanFactory);
        });
    }

    protected abstract void refreshBeanFactory() throws BeansException;

    protected abstract ConfigurableListableBeanFactory getBeanFactory();

    @Override
    public Object getBean(String name) {
        return getBeanFactory().getBean(name);
    }

    @Override
    public Object getBean(String name, Object... args) throws BeansException {
        return getBeanFactory().getBean(name, args);
    }

    @Override
    public <T> T getBean(String name, Class<T> requiredType) throws BeansException {
        return getBeanFactory().getBean(name, requiredType);
    }

    @Override
    public <T> Map<String, T> getBeansOfType(Class<T> clazz) throws BeansException {
        return getBeanFactory().getBeansOfType(clazz);
    }

    @Override
    public String[] getBeanDefinitionNames() {
        return getBeanFactory().getBeanDefinitionNames();
    }


}
