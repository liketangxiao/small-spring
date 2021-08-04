package cn.bugstack.springframework.beans.factory;

/**
 * @Description: FactoryBean 接口
 * @Author wangyuj
 * @Date 2021/8/3
 */
public interface FactoryBean<T> {
    T getObject() throws Exception;

    Class<?> getObjectType();

    boolean isSingleton();
}
