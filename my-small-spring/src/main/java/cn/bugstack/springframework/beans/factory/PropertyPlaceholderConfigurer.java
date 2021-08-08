package cn.bugstack.springframework.beans.factory;

import cn.bugstack.springframework.beans.BeansException;
import cn.bugstack.springframework.beans.factory.config.BeanFactoryPostProcessor;

/**
 * @Description: PropertyPlaceholderConfigurer 处理占位符配置
 * @Author wangyuj
 * @Date 2021/8/6
 */
public class PropertyPlaceholderConfigurer implements BeanFactoryPostProcessor {
    public static final String DEFAULT_PLACEHOLDER_PREFIX = "${";
    public static final String DEFAULT_PLACEHOLDER_SUFFIX = "}";
    private String location;

    public PropertyPlaceholderConfigurer() {
    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {

    }
}
