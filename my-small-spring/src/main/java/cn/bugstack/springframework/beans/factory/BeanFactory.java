package cn.bugstack.springframework.beans.factory;

/**
 * @Description: BeanFactory
 * @Author wangyuj
 * @Date 2021/7/27
 */
public interface BeanFactory {

    Object getBean(String name);

    Object getBean(String name, Object... args) throws BeansException;

}
