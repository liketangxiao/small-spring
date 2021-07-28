package cn.bugstack.springframework.beans.factory.config;

/**
 * @Description: SingletonBeanRegistry 单例模式接口
 * @Author wangyuj
 * @Date 2021/7/27
 */
public interface SingletonBeanRegistry {

    Object getSingleton(String beanName);
}
