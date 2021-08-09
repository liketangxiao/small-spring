package cn.bugstack.springframework.context.support;

import cn.bugstack.springframework.beans.BeansException;
import cn.bugstack.springframework.beans.factory.ConfigurableListableBeanFactory;
import cn.bugstack.springframework.beans.factory.config.BeanFactoryPostProcessor;
import cn.bugstack.springframework.beans.factory.config.BeanPostProcessor;
import cn.bugstack.springframework.context.ApplicationEvent;
import cn.bugstack.springframework.context.ApplicationListener;
import cn.bugstack.springframework.context.ConfigurableAplicationContext;
import cn.bugstack.springframework.context.event.ApplicationEventMulticaster;
import cn.bugstack.springframework.context.event.ContextCloseEvent;
import cn.bugstack.springframework.context.event.ContextRefreshedEvent;
import cn.bugstack.springframework.context.event.SimpleApplicationEventMulticaster;
import cn.bugstack.springframework.core.io.DefaultResourceLoader;

import java.util.Collection;
import java.util.Map;

/**
 * @Description: AbstractApplicationContext 应用上下文抽象实现类
 * @Author wangyuj
 * @Date 2021/8/2
 */
public abstract class AbstractApplicationContext extends DefaultResourceLoader implements ConfigurableAplicationContext {

    public static final String APPLICATION_EVENT_MULTICASTER_BEAN_NAME = "applicationEventMulticaster";
    private ApplicationEventMulticaster applicationEventMulticaster;

    @Override
    public void refresh() throws BeansException {
        /** 创建BeanFactory 并加载BeanDefinition */
        refreshBeanFactory();
        /** 获取BeanFactory */
        ConfigurableListableBeanFactory beanFactory = getBeanFactory();
        /** 添加ApplicationContextAwareProcessor, 让继承自ApplicationContextAware的bean对象能感知所属的ApplicationContext */
        beanFactory.addBeanPostProcessor(new ApplicationContextAwareProcessor(this));
        /** Bean实例化之前执行 */
        invokebeanFactroyPostProcessors(beanFactory);
        /** BeanPostProcessor需要提前于其他Bean对象实例化执行注册操作 */
        registerBeanPostProcessors(beanFactory);
        /** 初始化事件发布者 */
        initApplicationEventMulticaster();
        /** 注册监听事件 */
        registerListeners();
        /** 提前实例化单例bean对象 */
        beanFactory.preInstantiateSingletons();
        /** 发布容器刷新事件 */
        finishRefresh();
    }

    private void finishRefresh() {
        publishEvent(new ContextRefreshedEvent(this));
    }

    private void registerListeners() {
        Collection<ApplicationListener> applicationListeners = getBeansOfType(ApplicationListener.class).values();
        applicationListeners.forEach(applicationListener -> applicationEventMulticaster.addApplicationListener(applicationListener));
    }

    private void initApplicationEventMulticaster() {
        ConfigurableListableBeanFactory beanFactory = getBeanFactory();
        applicationEventMulticaster = new SimpleApplicationEventMulticaster(beanFactory);
        beanFactory.registerSingleton(APPLICATION_EVENT_MULTICASTER_BEAN_NAME, applicationEventMulticaster);
    }

    @Override
    public void publishEvent(ApplicationEvent event) {
        applicationEventMulticaster.multicastEvent(event);
    }

    @Override
    public void registerShutdownHook() {
        Runtime.getRuntime().addShutdownHook(new Thread(this::close));
    }

    @Override
    public void close() {
        publishEvent(new ContextCloseEvent(this));
        getBeanFactory().destroySingletons();
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
    public <T> T getBean(Class<T> requiredType) throws BeansException {
        return getBeanFactory().getBean(requiredType);
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
